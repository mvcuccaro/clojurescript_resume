(ns app.components.ibm-cds.modal.modal
  (:require [reagent.core :as r]))

(defn modal [props body]
  (let [modal (r/atom nil)]
    (fn []
      [:div
       [:cds-button {:id "modal-example-button"
                     :on-click #(set! (.-open @modal) true)} " Open Modal "]
       [:cds-modal {:id "modal-example" :ref #(reset! modal %)}
        [:div.bg-white.p-2
         [:cds-modal-header
          [:cds-modal-close-button]
          [:cds-modal-label (:label props)]
          [:cds-modal-heading (:title props)]]
         [:cds-modal-body {:style {:background-color "white"}}
          [:p body]]]
        [:cds-modal-footer
         [:cds-modal-footer-button {:kind "secondary"} "Cancel"]
         [:cds-modal-footer-button {:kind "primary"} "Save"]]]])))