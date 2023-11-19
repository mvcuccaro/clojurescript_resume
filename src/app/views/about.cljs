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
          [:div {:class "row"}
           [:div {:class "col-sm-9" :dangerouslySetInnerHTML {:__html text/about-me}}]
           [:div {:class "col-sm-3 image-fluid"}
            [:img {:src "/app_images/mnt.jpg" :class "img-fluid" :style {:border-radius "50%"}}]]]]
         [layouts/section-container "Clojure" about-html]]]])
