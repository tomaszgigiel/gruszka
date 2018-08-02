(defproject gruszka "1.0.0.0"
  :description "gruszka: pictures against younger sister"
  :url "http://tomaszgigiel.pl"
  :license {:name "Apache License"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.google.zxing/core "3.3.3"]
                 [com.google.zxing/javase "3.3.3"]]
  :main ^:skip-aot pl.tomaszgigiel.gruszka.core

  :source-paths ["src/main/clojure"]
  :test-paths ["src/test/clojure"]
  :resource-paths ["src/main/resources"]
  :target-path "target/%s"

  :profiles {:uberjar {:aot :all :jar-name "gruszka.jar" :uberjar-name "gruszka-uberjar.jar"}})
