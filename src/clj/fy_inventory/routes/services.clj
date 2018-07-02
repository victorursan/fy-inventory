(ns fy-inventory.routes.services
  (:require [ring.util.http-response :refer :all]
            [compojure.api.sweet :refer :all]
            [fy-inventory.schemas.inventory-event :as s]))

(defapi service-routes
  {:swagger {:ui   "/swagger-ui"
             :spec "/swagger.json"
             :data {:info {:version     "1.0.0"
                           :title       "Sample API"
                           :description "Sample Services"}}}}

  (context "/api/v1/" []

    (GET "/inventories/:sku" [])

    (POST "/inventories" []
      :body [inventory-event s/InventoryEvent])))

    ;;+ CRUD Orders
