(ns app.views.resume
  (:require[app.state.state :as state]))

(defn work-history []
  [:ul {:class "mx-2 mt-4"}
   (for [item @app.state.state/work-history] ^{:key (:id item)}
        [:li {:class "mb-3"}
         [:div \[ (:company item) \] " " (:name item) ]
         [:div (:body item)]])])

(defn main []
  [:div {:class "m-4 px-1 pb-4 border shadow-lg"}
     [:div
      [:div {:class "p-2 m-2 bg-primary h4"} "Work History"]
      [:div {:class "m-3"}
       [work-history]]]])

(state/apicall state/work-history)