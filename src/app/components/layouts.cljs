(ns app.components.layouts)


;; TODO: This would be a fun spot to put a multimethod
(defn parse-youtube [{youtube :youtube}]
  [:iframe {:src youtube
   :frameBorder "0"
   :allow "accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
   :allowFullScreen ""}])

(defn parse-video [{video :video}]
  [:video {:class "myvids" :controls true}
   [:source {:src video :type "video/mp4"}]])

(defn page [title content]
  [:div {:class "m-2 px-1 pb-4 border shadow-lg page"}
   (when title [:h2 {:class "m-3"} title])
   content])

(defn section-container [title content]
  [:div {:class "m-4 px-1 pb-4 border shadow-lg"}
   [:div
    [:div {:class "ps-3 p-2 pt-3 m-2 bg-primary h4 section_title"} title]
    [:div {:class "m-3"}
     content]]])

(defn rich-list-item
  [item]
  [:li {:class "mb-4"}
   [:div {:class "row border-bottom"}
    [:div {:class "p-3 col-xs-12 col-sm-6 col-md-7"}
     [:div {:class "mb-1 fw-bold"}\[(:name item)\]]
     [:div {:class "pr-4"
            :dangerouslySetInnerHTML {:__html (:body item)}
            :style {:text-align "justify" :padding-right "20px" :line-height "1.4"}}]]
    [:div {:class "col-xs-12 col-sm-6 col-md-5 p-2" :style {:text-align "center"}}
     (when (:thumbnail item)
       [:img
        {:src (:thumbnail item)
         :class "img-fluid thumb-container"}])
     (when (:youtube item)
       [:div {:class "video-con"}
        (parse-youtube item)])
     (when (:video item)
       [:div
        (parse-video item)]) ]]])
