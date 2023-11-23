(ns app.components.ibm-cds.tabs.tabs
  (:require [reagent.core :as r]))

(defn tabs [tabs default-value]
  [:div
   [:cds-tabs {:value default-value :class "h-100"}
    (doall 
     (for [tab tabs] ^{:key (->> (:name tab) (str (rand)))}
          [:cds-tab {:target (:target tab) :value (:value tab)} (:name tab)]))]
   [:div.m-4
    (doall
     (for [tab tabs] ^{:key (->> (:name tab) (str (rand)) )}
          [:div {:id (:target tab)
                 :role "tabpanel"
                 :hidden true
                 :dangerouslySetInnerHTML {:__html (:body tab)}}]))]])

;; (defn tabs2
;;   []
;;   (let [a 1]
;;     (r/create-class
;;      {:display-name tabs2
;;       :component-did-mount
;;       (fn [this]
;;         (println "mounted"))})))