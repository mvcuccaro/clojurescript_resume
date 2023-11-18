(ns app.views.about
   (:require [markdown-to-hiccup.core :as m]
             [app.components.layouts :as layouts]
             [app.text.about :as text]))

(def about-html 
  (->> (reduce (fn [a i] (str a i "\n\n")) "" text/about-md)
       (m/md->hiccup)
       (m/component)))

(defn main []
  [:<> [layouts/page ":About"
        [:div
         [layouts/section-container "Me" 
          [:div {:dangerouslySetInnerHTML {:__html text/about-me}}]]
         [layouts/section-container "Clojure" about-html]]]])