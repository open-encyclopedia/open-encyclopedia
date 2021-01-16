(ns open-encyclopedia.client.sex-education
  (:require [open-encyclopedia.client.layout.toolbar :as toolbar]
            [open-encyclopedia.client.view :as view]
            [re-frame.core :as rf]))

(rf/reg-event-fx
 ::go-to-sex-education
 (fn [_ _]
   {:dispatch [::view/set-active-view :sex-education]
    :redirect "/#/sex-education"}))

(defn main []
  [:div
   [toolbar/main]
   [:span "dipti"]])
