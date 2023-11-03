(ns app.header
  (:require [reagent.core :as r]))


(defn banner []
  [:div {:class "col-12 p-3 bg-secondary"
         :on-click #((js/alert 'click))}
   [:div
    [:h3 "michaelcuccaro.com"]]])
