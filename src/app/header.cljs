(ns app.header
  (:require [reagent.core :as r]))


(defn banner []
  [:div {:class "col-12 p-3 bg-secondary"
         :on-click #((js/alert 'click))}
   [:div
    [:h3 "cljs.michaelcuccaro.com"]]])

(defn menu []
  [:div {:class "main_nav my-2"}
   [:a {:href "/#/about" :class "m-2 btn btn-primary"} "About Me"]
   [:a {:href "/#/sandbox" :class "m-2 btn btn-primary"} "Clojure Sandbox"]
   [:a {:href "https://www.michaelcuccaro.com" :class "m-2 btn btn-primary"} "VueJS Site"]
   ])
