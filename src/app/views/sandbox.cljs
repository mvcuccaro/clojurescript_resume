(ns app.views.sandbox
  (:require [app.components.md5er :as md5er]
            [app.components.layouts :as layouts]
            [app.components.ibm-cds.tabs.tabs :as tabs]
            [app.components.ibm-cds.modal.modal :as modal]
            [reagent.core :as r]))

(def mytabs [
             {:target "tab1" :name "Demo Tab 1" :body "This is the tabs Component from the <a href=\"https://carbondesignsystem.com/developing/frameworks/web-components\">IBM Carbon Design System</a>. It is a design framework similar to bootstrap that enforces IBMs requirements for visibility and accessability. I put a reagent wrapper around the native web components from the design framework allowing it to be accessed dynamically in hiccup." :value 1}
             {:target "tab2" :name "Demo Tab 2" :body "This is the body of tab 2" :value 2 :hidden true}
             {:target "tab3" :name "Demo Tab 3" :body "This is the body of tab 3" :value 3 :hidden true}])


(defn get-section [title body]
  [layouts/section-container {:title title} body])


(defn main []
  (let [show-modal (r/atom false)]
  (fn [] 
    [:div
     [layouts/page ":Component-Sandbox"
      [:<>
       [:div
        [:div
         [md5er/main]]]
       [:div
        [:div.row.no-gutters
         [:div.col-sm-6
          (get-section "IBM Carbon Tabs Reagent Port - list driven"
                       [:div.m-1.w-75 {:style {:min-height "300px"}}
                        [tabs/tabs mytabs 1]])]
         [:div.col-sm-6
          [layouts/section-container {:title "IBM Carbon Tabs Reagent Port - hiccup driven"}
           [:div.m-1.w-75 {:style {:min-height "300px"}}
            [tabs/tabs2 {:alt "Test" :default-value 1}
             [tabs/tab2 {:name "tab name" :value 1}
              [:div 
               "Now is the time " [:a {:href "#"} "mylink"]]]
             [tabs/tab2 {:name "tab name 2" :value 2}
              [:div "Do you want to sing a song fiona?"]]]]]]]
        [:div
         [layouts/section-container {:title "IBM Carbon Modal Reagent Port"}
          [:div {:class "m-1 w-75"}
           [:input {:type "button" :on-click #((when (false? @show-modal) (swap! show-modal not))) :value "Show Modal"}]
           [modal/modal {:show show-modal  :title "My title" :label "This is the label"} "Now is the time for all good men ...."]]]]]]]])))
