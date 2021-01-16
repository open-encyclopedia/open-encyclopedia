;; This Source Code Form is subject to the terms of the Mozilla Public
;; License, v. 2.0. If a copy of the MPL was not distributed with this
;; file, You can obtain one at http://mozilla.org/MPL/2.0/

(ns ^:figwheel-hooks open-encyclopedia.client
  (:require [day8.re-frame.http-fx]
            [open-encyclopedia.client.history :as history]
            [open-encyclopedia.client.home :as home]
            [open-encyclopedia.client.routes :as routes]
            [open-encyclopedia.client.sex-education :as sex-education]
            [open-encyclopedia.client.theme :as theme]
            [open-encyclopedia.client.tooltip :as tooltip]
            [open-encyclopedia.client.tooltip.generic-popup :as tooltip.generic-popup]
            [open-encyclopedia.client.tooltip.loading-popup :as tooltip.loading-popup]
            [open-encyclopedia.client.view :as view]
            [reagent.dom :as rd]
            [re-frame.core :as rf]))

(def default-db
  {:theme :light})

(rf/reg-event-fx
 ::load-app
 (fn [_ _]
   {:db default-db}))

(defn app []
  (let [theme (rf/subscribe [::theme/get-theme])
        active-view (rf/subscribe [::view/active-view])]
    (fn []
      [:div.app-container
       {:on-click #(tooltip/destroy-on-click-out (.. % -target))
        :class (str "theme-" (name @theme))}
       [:div.app-container__main
        {:id "app-container__main"}
        (case @active-view
          :history [history/main]
          :sex-education [sex-education/main]
          [home/main])]
       [tooltip.loading-popup/main]
       [tooltip.generic-popup/main]])))

(defn main []
  [app])

;; Make log level logs no-ops for production environment.
(rf/set-loggers! {:log (fn [& _])})

(defn dev-setup []
  (when goog.DEBUG
    ;; Reenable log level logs no-ops for dev environment.
    (rf/set-loggers! {:log js/console.log})
    (enable-console-print!)
    (println "Dev mode")))

(defn mount-root []
  (rf/clear-subscription-cache!)
  (rd/render [main] (.getElementById js/document "app")))

(defn ^:after-load re-render []
  (mount-root))

(defn ^:export init []
  (dev-setup)
  (rf/dispatch-sync [::load-app])
  (routes/app-routes)
  (mount-root))
