(ns app.views.sandbox
  (:require [app.components.md5er :as md5er]))

;; (defn mymd5 [s]
;;   (let [md5 (goog.crypt.Md5.)]
;;     (->> s (goog.crypt/stringToUtf8ByteArray)
;;          (.update md5))
    
;;     (->> (.digest md5)
;;          (goog.crypt/byteArrayToHex))))
        

;;(def hashin (r/atom "enter text here"))


(defn main []
  [:div {:class "m-4"}
   [:div {:class "h1"} "Sandbox"]
   [md5er/main]
   [:hr]])