(ns fy-inventory.handler
  (:require [fy-inventory.routes.services :refer [service-routes]]
            [fy-inventory.routes.oauth :refer [oauth-routes]]
            [compojure.core :refer [routes wrap-routes]]
            [ring.util.http-response :as response]
            [fy-inventory.middleware :as middleware]
            [compojure.route :as route]
            [fy-inventory.env :refer [defaults]]
            [mount.core :as mount]))

(mount/defstate init-app
  :start ((or (:init defaults) identity))
  :stop  ((or (:stop defaults) identity)))

(mount/defstate app
  :start
  (middleware/wrap-base
    (routes
          #'oauth-routes
          #'service-routes
          (route/not-found
             "page not found"))))

