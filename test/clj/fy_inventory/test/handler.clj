(ns fy-inventory.test.handler
  (:require [clojure.test :refer :all]
            [ring.mock.request :refer :all]
            [fy-inventory.handler :refer :all]
            [mount.core :as mount]))

(use-fixtures
  :once
  (fn [f]
    (mount/start #'fy-inventory.config/env
                 #'fy-inventory.handler/app)
    (f)))

(deftest test-app
  (testing "main route"
    (let [response (app (request :get "/"))]
      (is (= 200 (:status response)))))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= 404 (:status response))))))
