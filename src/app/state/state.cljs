(ns app.state.state
  (:require [cljs-http.client :as http]
            [clojure.core.async :refer [<! go]]
            [reagent.core :as r]))

(def work-history (r/atom []))
(def active-menu-item (r/atom 1))

(defn apicall [state-container]
  (go (let [response (<! (http/get "/api/work_history"))]
      ;(js/console.log (:body response))
         (->> (:body response)
              (.parse js/JSON)
              (#(js->clj % :keywordize-keys true))
              (reset! state-container)))))
    