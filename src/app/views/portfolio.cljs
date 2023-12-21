(ns app.views.portfolio
  (:require [app.components.layouts :as layouts]
            [app.state.state :as state]))


(def static-items [])
;;   [{
;;     :id 10
;;     :name "Foo"
;;     :body "now is the time"
;;     :video "https://www.michaelcuccaro.com/data/videos/vuejs_dynamic_form_demo.mp4"}]

(defn main [] 
  [:<> 
   [layouts/page ":Portfolio"
    [layouts/section-container {:title "Applications"}
     [:ul
      (for [item (reduce conj (reverse @state/portfolio) static-items)] ^{:key (:id item)}
      [layouts/rich-list-item item])]]]])

;(state/search "/api/portfolio" state/portfolio)

