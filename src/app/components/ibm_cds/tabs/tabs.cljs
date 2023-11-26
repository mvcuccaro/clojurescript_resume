(ns app.components.ibm-cds.tabs.tabs
  (:require [reagent.core :as r]
            [cljs.pprint :as pp]))

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
  [props tab]
  (r/create-class
   {
    :component-did-mount
    (fn [this]
      (pp/pprint this))
    
    :reagent-render
    (fn [props body]
      [:div {:role "tabpanel"
             :hidden false
             :id (:id props)
             :name (:name props )} body])
    }))

(defn tabs2
  [props]
  (let [uuid (str (random-uuid))
        mounted-tabs (r/atom [])]
    (r/create-class
     {:display-name "tabs2"
      ;;:component-did-mount
      ;; (fn [this]
      ;;   (let [props (r/props this)
      ;;         children (r/children this)] 
      ;;     (pp/pprint children)))
      :reagent-render
      (fn []
        (let [children (r/children (r/current-component))
              x (pp/pprint children)]
          [:div 
          [:cds-tabs {:value (:default-value props)}
           (doall
            (for [tab children
                  :let [secondtab (second tab)
                        name (:name secondtab)
                        value (:value secondtab)
                        target (str (:target secondtab) uuid)]]
              ^{:key (->> (:name (second tab)) (str (rand)))}
              [:cds-tab {:target target
                         :value value} name]))]
          [:div {:class "m-4" :style {:font-weight "bold"}}
           (doall
            (for [tab children] ^{:key (rand)}
                 [tab2 {:uuid uuid
                        :id (str (:target (first tab)))} (nth tab 2)]
                 ))]]))
      })))
        
           
           