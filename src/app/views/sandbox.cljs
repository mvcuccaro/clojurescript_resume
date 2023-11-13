(ns app.views.sandbox
  (:require [app.components.md5er :as md5er]
            [app.components.layouts :as layouts]))

(defn main []
  [:<> [layouts/page
   [md5er/main] ":Component-Sandbox"]])
