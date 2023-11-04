(ns app.components.md5er
  (:require goog.crypt goog.crypt.Md5 [reagent.core :as r]))

;;state
(def hashin (r/atom ""))

(defn mymd5 [s]
  (let [md5 (goog.crypt.Md5.)]
    (->> s (goog.crypt/stringToUtf8ByteArray)
         (.update md5))

    (->> (.digest md5)
         (goog.crypt/byteArrayToHex))))


(defn main []
  [:<>
   [:div {:class "px-1 pb-4 border shadow-lg"}
    [:div
     [:div {:class "p-2 m-2 bg-primary h4"} "MD5 Hasher"]
     [:div {:class "m-3"}
      [:span "Input: "]
      [:input {:type "text"
               :value @hashin
               :on-change #(reset! hashin (-> % .-target .-value))}]
      [:div (str "MD5 Hash: " (mymd5 @hashin))]]]]])