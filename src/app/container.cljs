(ns app.container
    (:require [reagent.core :as r]
              [app.header :as header]
              [app.views.about :as about]
              [app.views.dashboard :as dashboard]
              [app.views.sandbox :as sandbox]
              [app.views.resume :as resume]
              [app.views.portfolio :as portfolio]
              [app.views.resources :as resources]
              [app.constants.menu :as menu]))


;;force the container to rerender on route change
(def arender (r/atom 0))
(js/window.addEventListener "hashchange" #(swap! arender inc))

(defn getView [arender]
  (let [view (second 
              (re-find #"#/(.+)" (. js/document -location.hash)))]
    (js/console.log @arender)
    (condp = view ;clojurescript seems to have ifficulties converting strings to functions at run time so we create a static map here
      "about" about/main
      "dashboard" dashboard/main
      "sandbox" sandbox/main
      "resume" resume/main
      "portfolio" portfolio/main
      "resources" resources/main
      about/main)))


(defn container []
  [:div {:class "m-1 pb-2 shadow col-xl-10 route-container"}
   [header/banner]
   [header/menu menu/menu-links]
   [(getView arender)]])
