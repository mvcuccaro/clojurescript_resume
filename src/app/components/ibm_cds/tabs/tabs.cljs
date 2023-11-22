(ns app.components.ibm-cds.tabs.tabs)

(defn tabs [tabs default-value]
  [:div
   [:cds-tabs {:value default-value}
    (doall 
     (for [tab tabs] ^{:key (:name tab)}
          [:cds-tab {:target (:target tab) :value (:value tab)} (:name tab)]))]
   [:div.m-4
    (doall
     (for [tab tabs] ^{:key (:name tab)}
          [:div {:id (:target tab)
                 :role "tabpanel"
                 :hidden true
                 :dangerouslySetInnerHTML {:__html (:body tab)}}]))]])