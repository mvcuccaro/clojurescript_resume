(ns app.views.sandbox
  (:require [app.components.md5er :as md5er])
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]))

(defn main []
  [:div {:class "m-4"}
   [:div {:class "h1"} "Sandbox"]
   [:hr]
   [md5er/main]])

(def fakeapiurl "/api/users")

(defn apicall []
(go
  (let [response (<! (http/get fakeapiurl))]
    (js/console.log 
     (->> (response)
          (clj->js))))))