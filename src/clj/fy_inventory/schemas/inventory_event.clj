(ns fy-inventory.schemas.inventory-event
  (:require [schema.core :as s]))

;;events saved by the inventory_updater in the event store regarding the changes of quantity for an SKU
(s/defschema InventoryEvent
   {:sku s/Str
    :change s/Int})

;;snapshots (+checkpoints) saved by the inventory_updater in the event store regarding the quantity of an SKU at a certain point
(s/defschema InventorySnapshot
   {:sku s/Str
    :quantity Long})

;;request by the brand to change the status for a specific order_id (like "shipped")
(s/defschema OrderStatus
  {:order-id Long
   :status s/Str})


(s/defschema ReturnedItem
  {:order-id Long
   :sku s/Str})




