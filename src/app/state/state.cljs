(ns app.state.state
  (:require [cljs-http.client :as http]
            [clojure.core.async :refer [<! >! go chan]]
            [reagent.core :as r]
            [app.constants.menu :as menu]))

(def DEFAULT-ACTIVE-MENU-ITEM "about")

;;State containers
(def work-history (r/atom []))
(def portfolio (r/atom []))
(def docker-repositories (r/atom []))
(def github-repositories (r/atom []))

(defn init-active-menu-item
  "Set the active item based on the url"
  [menu-items]
  (let [hash (-> js/window .-location .-hash)
        route-name (last (re-matches #"#/(.+)" hash))]
    (-> (filter #(= (:menu-id %) route-name) menu-items)
        first
        :menu-id)))

(def active-menu-item
  (r/atom
   (or
    (init-active-menu-item menu/menu-links)
    DEFAULT-ACTIVE-MENU-ITEM))) ;;derive the current menu from the url OR set it to a default

(defn search [url state-container]
  (go (let [out (chan)
            response (<! (http/get url))]
      ;(js/console.log (:body response))
        (->> (:body response)
             (.parse js/JSON)
             (#(js->clj % :keywordize-keys true))
             (reset! state-container))
        (>! out response)
        out)))

(defn search-batch [searches cb]
  (let [out (chan)]
    (go
      (>! out
          (map #(<! %) searches)))
    (cb)
    out))


;;load data from api
(let [searches [(search "/api/portfolio" portfolio)
                (search "/api/work_history" work-history)
                (search "/api/docker_repositories" docker-repositories)
                (search "/api/github_repositories" github-repositories)]]
      (search-batch searches #(println "done")))
    