(ns open-encyclopedia.client.history
  (:require [open-encyclopedia.client.layout.toolbar :as toolbar]
            [open-encyclopedia.client.view :as view]
            [re-frame.core :as rf]))

(rf/reg-event-fx
 ::go-to-history
 (fn [_ _]
   {:dispatch [::view/set-active-view :history]
    :redirect "/#/history"}))

(defn main []
  [:div
   [toolbar/main]])
