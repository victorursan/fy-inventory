(ns ^{:author "Victor Ursan"
      :doc "1. Listen for events from inventory_monitor regarding the 'Out of stock' for an item
            2. When an event is received with an SKU, call the clients db (fy-inventory.db.clients) to retrieve the brand's email
            3. Send the email."}
  fy-inventory.notifications)

