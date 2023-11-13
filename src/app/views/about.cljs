(ns app.views.about
   (:require [markdown-to-hiccup.core :as m]
             [app.components.layouts :as layouts]))

(def about-md '("###Interest In Clojure:"
                "I first became interested in studying functional programming after reading 'Functional Light Programming' by Kyle Simpson - a very good book on using javascript with the functional paradigm. His direction and examples gave me a vocabulary for a type of programming I preferred but hadnt studied formally. Essentially - globals always drove me nuts.  One of my first professonal programming jobs was in PHP and the lead developer had a global instance of a DB connection that was used to run all queries.  He was constantly getting on my case for passing the db into functions that ran queries. I told him that I didn't care that it was global. If i pass it in, I know how it got there." "This new interest would lead me to reading up on haskell, erlang and others but the one that I enjoyed the most was Clojure. I didn't know exactly what I was getting into when I started browsing Higginbotham's 'Clojure for the Brave and True' which I had gotten as part of a HumbleBundle of ebooks but it definitely resonated with me." "After that and a few Rich Hickey videos I was hooked."))
               

(def about-html 
  (->> (reduce (fn [a i] (str a i "\n\n")) "" about-md)
       (m/md->hiccup)
       (m/component)))


(js/console.log about-html)

(defn main []
  [:<> [layouts/page 
        [layouts/section-container "Clojure" about-html] ":About"]])