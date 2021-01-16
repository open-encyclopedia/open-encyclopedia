;; This Source Code Form is subject to the terms of the Mozilla Public
;; License, v. 2.0. If a copy of the MPL was not distributed with this
;; file, You can obtain one at http://mozilla.org/MPL/2.0/

(ns open-encyclopedia.client.routes
  (:require-macros [secretary.core :refer [defroute]])
  (:import goog.History)
  (:require [goog.events]
            [goog.history.EventType :as EventType]
            [open-encyclopedia.client.history :as history]
            [open-encyclopedia.client.home :as home]
            [open-encyclopedia.client.sex-education :as sex-education]
            [open-encyclopedia.client.view :as view]
            [re-frame.core :as rf]
            [secretary.core :as secretary]))

(defn hook-browser-navigation! []
  (doto (History.)
    (goog.events/listen EventType/NAVIGATE #(secretary/dispatch! (.-token %)))
    (.setEnabled true)))

(defn app-routes []
  (secretary/set-config! :prefix "#")
  ;; --------------------
  ;; define routes here

  (defroute "/" []
    (view/redirect! "/#/home"))

  (defroute "/home" []
    (rf/dispatch [::home/go-to-home]))

  (defroute "/history" []
    (rf/dispatch [::history/go-to-history]))

  (defroute "/sex-education" []
    (rf/dispatch [::sex-education/go-to-sex-education]))

  ;; --------------------
  (hook-browser-navigation!))
