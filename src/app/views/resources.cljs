(ns app.views.resources
  (:require [app.components.layouts :as layouts]
            [app.state.state :as state]))

(defn repos [items]
    [:ul
     (for [item items] ^{:key item}
          (let [item (-> (if
                          (string? item)
                           {:name item}
                           item))]
            [layouts/rich-list-item item]))])


(defn main []
  [:<> [layouts/page ":Resources"
        [layouts/section-container " "
         [:div
          [:ul {:class "nav nav-tabs", :id "myTab", :role "tablist"}
           [:li {:class "nav-item", :role "presentation"}
            [:button {:class "nav-link active", :id "docker-tab", :data-bs-toggle "tab", :data-bs-target "#docker", :type "button", :role "tab", :aria-controls "docker", :aria-selected "true"} "Docker Repositories"]]
           [:li {:class "nav-item", :role "presentation"}
            [:button {:class "nav-link", :id "github-tab", :data-bs-toggle "tab", :data-bs-target "#github", :type "button", :role "tab", :aria-controls "github", :aria-selected "false"} "Github Repositories"]]]
           [:div {:class "tab-content", :id "myTabContent"}
            [:div {:class "tab-pane fade show active", :id "docker", :role "tabpanel", :aria-labelledby "home-tab"}
             (repos (->> @state/docker-repositories
                          (js->clj)
                          (:repositories)))]
            [:div {:class "tab-pane fade", :id "github", :role "tabpanel", :aria-labelledby "contact-tab"}
             (repos @state/github-repositories)]]]]]]) 