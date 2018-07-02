(ns ^{:author "Victor Ursan"
      :doc "1. Is a subscriber of the Event Store and consumes inventory events (fy-inventory.schemas.inventory-event/InventoryEvent)
            2. Keeps track of each SKU and it's quantity
            3. Periodically creates a snapshot for each SKU and it's quantity and stores it in the Event Store
            4. Provides access to the quantity for each SKU
            5. Notifies the realtime_prod_feed of any changes to the quantity of an SKU
            6. If the quantity for an SKU is 0, Notify the notifications(fy_inventory/notifications) service to send the email to the brand "}
  fy-inventory.event-store.inventory-monitor)
