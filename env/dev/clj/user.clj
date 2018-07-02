(ns user
  (:require [fy-inventory.config :refer [env]]
            [clojure.spec.alpha :as s]
            [expound.alpha :as expound]
            [mount.core :as mount]
            [fy-inventory.core :refer [start-app]]
            [fy-inventory.db.core]
            [conman.core :as conman]
            [luminus-migrations.core :as migrations]))

(alter-var-root #'s/*explain-out* (constantly expound/printer))

(defn start []
  (mount/start-without #'fy-inventory.core/repl-server))

(defn stop []
  (mount/stop-except #'fy-inventory.core/repl-server))

(defn restart []
  (stop)
  (start))

(defn restart-db []
  (mount/stop #'fy-inventory.db.core/*db*)
  (mount/start #'fy-inventory.db.core/*db*)
  (binding [*ns* 'fy-inventory.db.core]
    (conman/bind-connection fy-inventory.db.core/*db* "sql/queries.sql")))

(defn reset-db []
  (migrations/migrate ["reset"] (select-keys env [:database-url])))

(defn migrate []
  (migrations/migrate ["migrate"] (select-keys env [:database-url])))

(defn rollback []
  (migrations/migrate ["rollback"] (select-keys env [:database-url])))

(defn create-migration [name]
  (migrations/create name (select-keys env [:database-url])))


