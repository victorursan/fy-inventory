(ns ^{:author "Victor Ursan"
      :doc "1. Create an order for a customer
            2. Add the order in the Logistics DB
            3. Call inventory_update to decrease the quantity for all the SKUs in the order
            4. Allow the change of the status for an order (fy_inventory.schemas.inventory_event/OrderStatus)
            5. Allow the change of the status of an item (fy_inventory.schemas.inventory_event/ReturnedItem)"}
  fy-inventory.db.orders)
