(ns app.views.resume
  (:require[app.state.state :as state]))

(defn work-history []
  [:ul {:class "mx-2 mt-4"}
   (for [item @app.state.state/work-history] ^{:key (:id item)}
        [:li {:class "mb-4"}
         [:div {:class "row border-bottom"}
          [:div {:class "p-3 col-sm-8"}
           [:div \[ (:company item) \] " " (:name item)]
           [:div {:class "pr-4" :style {:text-align "justify" :padding-right "20px" :line-height "1.4"}}(:body item)]]
          [:div {:class "col-sm-4 p-2" :style {:text-align "center"}}
           (when (:thumbnail item)
             [:img 
              {:src (:thumbnail item)
               :class "img-fluid"}])]
          ]])])

(defn main []
  [:div {:class "m-4 px-1 pb-4 border shadow-lg"}
     [:div
      [:div {:class "ps-3 p-2 pt-3 m-2 bg-primary h4"} "Work History"]
      [:div {:class "m-3"}
       [work-history]]]])

(state/apicall state/work-history)