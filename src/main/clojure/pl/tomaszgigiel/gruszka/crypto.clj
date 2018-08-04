(ns pl.tomaszgigiel.gruszka.crypto
  (:require [buddy.core.crypto :as crypto])
  (:require [buddy.core.codecs :as codecs])
  (:require [buddy.core.nonce :as nonce])
  (:require [buddy.core.hash :as hash])
  (:gen-class))

(defn encrypted [t k iv] 
  (crypto/encrypt (codecs/to-bytes t) k iv {:algorithm :aes128-cbc-hmac-sha256}))

(defn decrypted [t k iv] 
  (-> (crypto/decrypt t k iv {:algorithm :aes128-cbc-hmac-sha256}) (codecs/bytes->str)))

(defn -main
  "gruszka: security against younger sister"
  [& args]
  (let [k (hash/sha256 "password")
        iv (nonce/random-bytes 16)]
    (println (decrypted (encrypted "zażółć gęślą jaźń" k iv) k iv)))
  (println "ok"))
