(ns app.hello
  (:require [reagent.core :as r]
            [app.header :as header]))

(defn click-counter [click-count]
  [:div
   "The atom " [:code "click-count"] " has value: "
   @click-count ". "
   [:input {:type "button" :value "Click me!" :class "btn btn-primary m-2"
            :on-click #(swap! click-count inc)}]])

(def click-count (r/atom 0))
(defn hello []
  [:<>
   [header/banner]
   [:p "Here's an example of using a component with state:"]
   [click-counter click-count]])
