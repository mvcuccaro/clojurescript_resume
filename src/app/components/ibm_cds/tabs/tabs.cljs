(ns app.components.ibm-cds.tabs.tabs
  (:require [reagent.core :as r]
            [cljs.pprint :as pp]
            [clojure.string :as string]))

(defn make-target [name uuid]
  (-> name 
      (string/replace #"\s+" "")
      (str uuid)))

(defn render-body [children uuid]
[:div.m-4
 (doall
  (for [tab children] ^{:key (->> (:name tab) (str (rand)))}
       [:div {:id (str (:target tab) uuid)
              :role "tabpanel"
              :hidden false
              :dangerouslySetInnerHTML {:__html (:body tab)}}]))])

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

(defn tab2
  []
  (r/create-class
   {
    :reagent-render
    (fn [props body]
      [:div {:role "tabpanel"
             :hidden true
             :id (:id props)
             :name (:name props )} body])
    }))

(defn tabs2
  [props]
  (let [uuid (str (random-uuid))]
    (r/create-class
     {:display-name "tabs2"
      :reagent-render
      (fn []
        (let [children (r/children (r/current-component))]
          [:div 
          [:cds-tabs {:value (:default-value props)}
           (doall
            (for [tab children
                  :let [secondtab (second tab)
                        name (:name secondtab)
                        value (:value secondtab)
                        target (make-target name uuid)]]
              ^{:key (-> (:name (second tab)) (str (rand)))}
              [:cds-tab {:target target
                         :value value} name]))]
          [:div {:class "m-3"}
           (doall
            (for [tab children
                  :let [secondtab (second tab)
                        name (:name secondtab)
                        target (make-target name uuid)]]
              ^{:key (rand)}
              [tab2 {:uuid uuid
                     :id target} (nth tab 2)]))]]))
      })))
        
           
           