(ns app.views.resume
  (:require [app.state.state :as state]
            [app.components.layouts :as layouts]
   ))

(defn rich-list-item 
  [item]
  [:li {:class "mb-4"}
   [:div {:class "row border-bottom"}
    [:div {:class "p-3 col-sm-8"}
     [:div \[ (:company item) \] " " (:name item)]
     [:div {:class "pr-4" :style {:text-align "justify" :padding-right "20px" :line-height "1.4"}} (:body item)]]
    [:div {:class "col-sm-4 p-2" :style {:text-align "center"}}
     (when (:thumbnail item)
       [:img
        {:src (:thumbnail item)
         :class "img-fluid"}])]]]
)


(defn work-history []
  [:ul {:class "mx-2 mt-4"}
   (for [item @app.state.state/work-history] ^{:key (:id item)}
        [rich-list-item item])])

(defn main []
  [:<> [layouts/page ":Resume" 
        [layouts/section-container {:title "Work History"} [work-history]]]])

(state/search "/api/work_history" state/work-history)