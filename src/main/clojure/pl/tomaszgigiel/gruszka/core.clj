(ns pl.tomaszgigiel.gruszka.core
  (:import java.nio.file.Paths)
  (:import com.google.zxing.BarcodeFormat)
  (:import com.google.zxing.client.j2se.MatrixToImageWriter)
  (:import com.google.zxing.qrcode.QRCodeWriter)
  (:gen-class))

(defn create-barcode [t w h x p] 
  (let [q (.. (new QRCodeWriter) (encode t BarcodeFormat/QR_CODE w h))
        o (Paths/get p (into-array [""]))]
    (MatrixToImageWriter/writeToPath q x o)))

(defn -main
  "gruszka: pictures against younger sister"
  [& args]
  (create-barcode (nth args 0) (Integer/parseInt (nth args 1)) (Integer/parseInt (nth args 2)) (nth args 3) (nth args 4))
  (println "ok"))
