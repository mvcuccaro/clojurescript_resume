(ns app.header
  (:require [reagent.core :as r]))

(def menu-links '(
                  {:href "/#/about" :body "About Me"}
                  {:href "/#/sandbox" :body "Sandbox"}
                  {:href "/#/resume" :body "Resume"}
                  {:href "https://www.michaelcuccaro.com" :body "VueJS Site"}))

(defn banner []
  [:div {:id "banner":class "col-12 p-3"}
   [:div
    [:div {:class "text-primary"}"cljs.michaelcuccaro.com"]
    [:div {:id "subheading" :class "ms-2"} "A dynamic resume written in Clojure and Clojurescript"]]])

(defn menu [items]
  [:div {:class "main_nav my-2"}
   (for [item items] ^{:key (:href item)}
   [:a 
    {:href (:href item)
     :class "m-2 btn btn-primary"}
    (:body item)])])