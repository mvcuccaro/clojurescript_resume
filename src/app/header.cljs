(ns app.header
  (:require [reagent.core :as r]))

(def menu-links '(
                  {:href "/#/about" :body "About Me"}
                  {:href "/#/sandbox" :body "Sandbox"}
                  {:href "/#/resume" :body "Resume"}
                  {:href "https://www.michaelcuccaro.com" :body "VueJS Site"}))

(defn banner []
  [:div {:class "col-12 p-3 bg-secondary"
         :on-click #((js/alert 'click))}
   [:div
    [:h3 "cljs.michaelcuccaro.com"]]])

(defn menu [items]
  [:div {:class "main_nav my-2"}
   (for [item items] ^{:key (:href item)}
   [:a 
    {:href (:href item)
     :class "m-2 btn btn-primary"}
    (:body item)])])