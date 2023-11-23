(ns app.components.ibm-cds.tabs.tabs
  (:require [reagent.core :as r]))

(defn tabs [tabs default-value]
  (fn []
    (let [uid (str (random-uuid))]
     [:div
      [:cds-tabs {:value default-value}
       (doall
        (for [tab tabs] ^{:key (->> (:name tab) (str (rand)))}
             [:cds-tab {:target (str (:target tab) uid)
                        :value (:value tab)} (:name tab)]))]
      [:div.m-4
       (doall
        (for [tab tabs] ^{:key (->> (:name tab) (str (rand)))}
             [:div {:id (str (:target tab) uid)
                    :role "tabpanel"
                    :hidden true
                    :dangerouslySetInnerHTML {:__html (:body tab)}}]))]])))

;; (defn tabs2
;;   []
;;   (let [a 1]
;;     (r/create-class
;;      {:display-name tabs2
;;       :component-did-mount
;;       (fn [this]
;;         (println "mounted"))})))