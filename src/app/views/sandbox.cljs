(ns app.views.sandbox
  (:require [app.components.md5er :as md5er]
            [app.components.layouts :as layouts]))

(defn main []
  [:<> [layouts/page ":Component-Sandbox" 
        [:div {:class "row"}
         [:div {:class "col-sm-6"}
          [md5er/main]]]]])
