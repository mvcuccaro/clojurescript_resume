(ns app.utilities.logging
  (:require [cljs-http.client :as http]))

(defn log [url]
  (http/get url))

