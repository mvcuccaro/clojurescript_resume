(ns app.container
    (:require [reagent.core :as r]
              [app.header :as header]
              [app.views.about :as about]
              [app.views.dashboard :as dashboard]
              [app.views.sandbox :as sandbox]))

(def routes
  (into #{} '(:about {:name "About" :path "/about"})))

(def arender (r/atom 0))

(js/window.addEventListener "hashchange" #(swap! arender inc))

(defn getView [arender]
  (js/console.log (. js/document -location.hash))
  (let [view (second 
              (re-find #"#/(.+)" (. js/document -location.hash)))]
    (js/console.log @arender)
    (condp = view ;clojurescript seems to have ifficulties converting strings to functions at run time so we create a static map here
      "about" about/main
      "dashboard" dashboard/main
      "sandbox" sandbox/main
      about/main)))


(defn container []
  [:<>
   [header/banner]
   [(getView arender)]])