(ns app.header
  (:require 
   [app.state.state :as state]))

(defn update-active-menu-item [{menu-id :menu-id} active]
  (reset! active menu-id))

(defn add-static-menu-item [url classes body]
  [:a {:class classes :href url} body ])

(defn banner []
  [:div {:id "banner":class "col-12 p-3"}
   [:div
    [:div {:class "text-primary"}"cljs.michaelcuccaro.com"]
    [:div {:id "subheading" :class "ms-2"} "A dynamic resume written in Clojure and Clojurescript"]]])

(defn menu [items]
  [:div {:class "row"}
   [:div {:class "main_nav my-2 col-sm-12 col-md-6"}
    (doall
     (for [item items] ^{:key (:href item)}
          [:a
           {:href (:href item)
            :class (str "m-2 btn btn-primary menu-item "
                   (when (= (:menu-id item) @state/active-menu-item) "isactive"))
            :on-click #(update-active-menu-item item state/active-menu-item)}
           (:body item)]))]
   [:div {:class "main_nav my-2 col-sm-12 col-md-6 text-end"}
    (add-static-menu-item
     "https://github.com/mvcuccaro"
     "m-2 btn btn-primary menu-item"
     "Github")
    (add-static-menu-item
     "https://www.michaelcuccaro.com"
     "m-2 btn btn-primary menu-item"
     "VueJS Site")
    (add-static-menu-item
     "https://www.linkedin.com/in/michael-cuccaro-704532134/"
     "m-2 btn btn-primary menu-item legacy"
     "LinkedIn")]])