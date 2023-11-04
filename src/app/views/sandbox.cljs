(ns app.views.sandbox
  (:require [app.components.md5er :as md5er]))

(defn main []
  [:div {:class "m-4"}
   [:div {:class "h1"} "Sandbox"]
   [:hr]
   [md5er/main]])