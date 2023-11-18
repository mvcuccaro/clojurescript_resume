(ns app.state.state
  (:require [cljs-http.client :as http]
            [clojure.core.async :refer [<! go]]
            [reagent.core :as r]
            [app.constants.menu :as menu]))

(def DEFAULT-ACTIVE-MENU-ITEM "about")

(defn init-active-menu-item
  "Set the active item based on the url"
  [menu-items] 
  (let [hash (-> js/window .-location .-hash)
        route-name (last (re-matches #"#/(.+)" hash))]
    (-> (filter #(= (:menu-id %) route-name) menu-items)
        first
        :menu-id)))

(def work-history (r/atom []))
(def portfolio (r/atom []))

(def active-menu-item (r/atom 
                       (or 
                        (init-active-menu-item menu/menu-links)
                        DEFAULT-ACTIVE-MENU-ITEM))) ;;derive the current menu from the url OR set it to a default

(defn search [url state-container]
  (go (let [response (<! (http/get url))]
      ;(js/console.log (:body response))
         (->> (:body response)
              (.parse js/JSON)
              (#(js->clj % :keywordize-keys true))
              (reset! state-container)))))
    