(defproject gruszka "1.0.0.0"
  :description "gruszka: security against younger sister"
  :url "http://tomaszgigiel.pl"
  :license {:name "Apache License"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.google.zxing/core "3.3.3"]
                 [com.google.zxing/javase "3.3.3"]
                 [buddy/buddy-core "1.4.0"]]

  :source-paths ["src/main/clojure"]
  :test-paths ["src/test/clojure"]
  :resource-paths ["src/main/resources"]
  :target-path "target/%s"
  
  :profiles {:uberjar {:aot :all :jar-name "gruszka.jar" :uberjar-name "gruszka-uberjar.jar"}
             :main-barcode {:main ^:skip-aot pl.tomaszgigiel.gruszka.barcode}
             :main-crypto {:main ^:skip-aot pl.tomaszgigiel.gruszka.crypto}}
  
  :aliases {"run-main-barcode" ["with-profile" "main-barcode" "run"]
            "run-main-crypto" ["with-profile" "main-crypto" "run"]})
