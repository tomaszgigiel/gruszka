(ns pl.tomaszgigiel.gruszka.barcode
  (:import java.awt.image.BufferedImage)
  (:import java.io.File)
  (:import java.nio.file.Paths)
  (:import javax.imageio.ImageIO)
  (:import com.google.zxing.BarcodeFormat)
  (:import com.google.zxing.BinaryBitmap)
  (:import com.google.zxing.MultiFormatReader)
  (:import com.google.zxing.client.j2se.BufferedImageLuminanceSource)
  (:import com.google.zxing.client.j2se.MatrixToImageWriter)
  (:import com.google.zxing.common.HybridBinarizer)
  (:import com.google.zxing.qrcode.QRCodeWriter)
  (:gen-class))

(defn create-barcode [t w h x p] 
  (let [q (.. (new QRCodeWriter) (encode t BarcodeFormat/QR_CODE w h))
        o (Paths/get p (into-array [""]))]
    (MatrixToImageWriter/writeToPath q x o)))

(defn barcode-string [p] 
  (.getText (.decode (new MultiFormatReader)(new BinaryBitmap (new HybridBinarizer (new BufferedImageLuminanceSource (ImageIO/read (new File p))))))))

(defn -main
  "gruszka: security against younger sister"
  [& args]
  (cond
    (= (count args) 5)(create-barcode (nth args 0) (Integer/parseInt (nth args 1)) (Integer/parseInt (nth args 2)) (nth args 3) (nth args 4))
    (= (count args) 1)(println (barcode-string (first args))))
  (println "ok"))
