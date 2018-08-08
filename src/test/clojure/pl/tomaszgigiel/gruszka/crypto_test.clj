(ns pl.tomaszgigiel.gruszka.crypto-test
  (:use [clojure.test])
  (:require [pl.tomaszgigiel.gruszka.crypto :as gruszka]))

(deftest encrypted-decrypted-test
  (let [k "password"
        iv (gruszka/initialization-vector 16)
        s "zażółć gęślą jaźń"]
    (testing "encrypted decrypted test" (is (= s (gruszka/decrypted (gruszka/encrypted s k iv) k iv))) "Expected string.")))
