(ns open-encyclopedia.client.layout.toolbar
  (:require [re-frame.core :as rf]
            [open-encyclopedia.client.tooltip :as tooltip]
            [open-encyclopedia.client.tooltip.loading-popup :as loading-popup]
            [open-encyclopedia.client.view :as view]))

(defn main []
  [:div.toolbar
   [:a.toolbar--header {:href "/#/home"} "Open Encyclopedia"]
   [:div.toolbar--link-container
    [:a {:href "/#/history"} "History"]
    [:a {:href "/#/economics"} "Economics"]
    [:a {:href "/#/infosec"} "Information Security"]
    [:a {:href "/#/sex-education"} "Sex Education"]
    [:a {:href "/#/women-in-tech"} "Women in Tech"]]])
