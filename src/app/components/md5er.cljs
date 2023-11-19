(ns app.components.md5er
  (:require goog.crypt goog.crypt.Md5 [reagent.core :as r]
            [app.components.layouts :as layouts]))

;;state
(def hashin (r/atom ""))

(defn mymd5 [s]
  (let [md5 (goog.crypt.Md5.)]
    (->> s (goog.crypt/stringToUtf8ByteArray)
         (.update md5))

    (->> (.digest md5)
         (goog.crypt/byteArrayToHex))))

(defn main []
  [:div {:class "h-100"}[layouts/section-container "MD5 Hasher"
         [:div 
          [:span "Input: "]
          [:input {:class "form-control mb-3"
                   :type "text"
                   :value @hashin
                   :on-change #(reset! hashin (-> % .-target .-value))}]
          [:div (str "MD5 Hash: " (mymd5 @hashin))]]]]
  )