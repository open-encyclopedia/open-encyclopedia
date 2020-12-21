;; This Source Code Form is subject to the terms of the Mozilla Public
;; License, v. 2.0. If a copy of the MPL was not distributed with this
;; file, You can obtain one at http://mozilla.org/MPL/2.0/

(ns open-encyclopedia.api.config
  (:require [compojure.core :refer [GET]]
            [integrant.core :as ig]))

(defmethod ig/init-key :open-encyclopedia.api/config [_ config]
  (GET "/api/config" []
    (fn [_]
      {:status 200
       :body config
       :headers {"content-type" "application/json"}})))
