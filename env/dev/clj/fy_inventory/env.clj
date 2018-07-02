(ns fy-inventory.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [fy-inventory.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[fy-inventory started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[fy-inventory has shut down successfully]=-"))
   :middleware wrap-dev})
