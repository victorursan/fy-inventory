(ns fy-inventory.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[fy-inventory started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[fy-inventory has shut down successfully]=-"))
   :middleware identity})
