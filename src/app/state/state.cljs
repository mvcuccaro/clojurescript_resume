(ns app.state.state
  (:require [cljs-http.client :as http]
            [clojure.core.async :refer [<! go]]
            [reagent.core :as r]))

(def work-history (r/atom []))
(def portfolio (r/atom []))
(def active-menu-item (r/atom 1))

(defn search [url state-container]
  (go (let [response (<! (http/get url))]
      ;(js/console.log (:body response))
         (->> (:body response)
              (.parse js/JSON)
              (#(js->clj % :keywordize-keys true))
              (reset! state-container)))))
    