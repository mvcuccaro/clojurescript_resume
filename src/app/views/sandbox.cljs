(ns app.views.sandbox
  (:require [app.components.md5er :as md5er]
            [app.components.layouts :as layouts]
            [app.components.ibm-cds.tabs.tabs :as tabs]))

(def mytabs [
             {:target "tab1" :name "Demo Tab 1" :body "This is the tabs Component from the <a href=\"https://carbondesignsystem.com/developing/frameworks/web-components\">IBM Carbon Design System</a>. It is a design framework similar to bootstrap that enforces IBMs requirements for visibility and accessability. I put a reagent wrapper around the native web components from the design framework allowing it to be accessed dynamically in hiccup." :value 1}
             {:target "tab2" :name "Demo Tab 2" :body "This is the body of tab 2" :value 2 :hidden true}
             {:target "tab3" :name "Demo Tab 3" :body "This is the body of tab 3" :value 3 :hidden true}])

(def mytabs2 (vec mytabs))

(defn main []
  (fn []
  [:div
   [layouts/page ":Component-Sandbox"
    [:<>
     [:div
      [:div
       [md5er/main]]]

     [:div
      [:div
       [layouts/section-container {:title "IBM Carbon Tabs Reagent Port"}
        [:div {:class "m-1 w-75"}
         [tabs/tabs mytabs 1]]]]
      [:div
       [layouts/section-container {:title "IBM Carbon Tabs Reagent Port"}
        [:div {:class "m-1 w-75"}
         [tabs/tabs mytabs2 1]]]]]]]]))


