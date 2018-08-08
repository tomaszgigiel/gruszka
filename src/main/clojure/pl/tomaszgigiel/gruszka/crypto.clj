(ns pl.tomaszgigiel.gruszka.crypto
  (:require [buddy.core.crypto :as crypto])
  (:require [buddy.core.codecs :as codecs])
  (:require [buddy.core.nonce :as nonce])
  (:require [buddy.core.hash :as hash])
  (:gen-class))

(defn initialization-vector [numbytes]
  (nonce/random-bytes numbytes))

(defn encrypted [t k iv] 
  (crypto/encrypt (codecs/to-bytes t) (hash/sha256 k) iv {:algorithm :aes128-cbc-hmac-sha256}))

(defn decrypted [t k iv] 
  (-> (crypto/decrypt t (hash/sha256 k) iv {:algorithm :aes128-cbc-hmac-sha256}) (codecs/bytes->str)))

(defn -main
  "gruszka: security against younger sister"
  [& args]
  (let [k "password"
        iv (initialization-vector 16)
        s "zażółć gęślą jaźń"]
    (println (decrypted (encrypted s k iv) k iv)))
  (println "ok"))
