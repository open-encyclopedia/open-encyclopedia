;; This Source Code Form is subject to the terms of the Mozilla Public
;; License, v. 2.0. If a copy of the MPL was not distributed with this
;; file, You can obtain one at http://mozilla.org/MPL/2.0/

(ns open-encyclopedia.static.root
  (:require [clojure.java.io :as io]
            [compojure.core :refer [context GET]]
            [integrant.core :as ig]))

(defmethod ig/init-key :open-encyclopedia.static/root [_ _]
  (context "/" []
    (GET "/" []
      (io/resource "open_encyclopedia/index.html"))))
