;; This Source Code Form is subject to the terms of the Mozilla Public
;; License, v. 2.0. If a copy of the MPL was not distributed with this
;; file, You can obtain one at http://mozilla.org/MPL/2.0/

(ns open-encyclopedia.api.example
  (:require [compojure.core :refer [context GET]]
            [integrant.core :as ig]))

(defmethod ig/init-key :open-encyclopedia.api/example [_ _]
  (context "/api/example" []
    (GET "/" []
      {:status 200
       :body {:msg "Welcome!"}
       :headers {"content-type" "application/json"}})))
