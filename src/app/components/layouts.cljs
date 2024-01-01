(ns app.components.layouts)


;; TODO: This would be a fun spot to put a multimethod
(defn parse-youtube [{youtube :youtube}]
  [:iframe {:src youtube
   :frameBorder "0"
   :allow "accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
   :allowFullScreen ""}])

(defn parse-video [{video :video}]
  [:video.myvids {:controls true}
   [:source {:src video :type "video/mp4"}]])

(defn page [title content]
  [:div.m-4.px-1.pb-4.border.shadow-lg.page.fade-in
   (when title [:h2.m-3 title])
   content])

(defn section-container [props content]
  [:div.my-3.mx-1.px-1.pb-4.border.shadow-lg
   [:div.h-100
    [:div.ps-3.p-2.pt-3.m-2.bg-primary.h4.section_title (:title props)]
    [:div.m-3
     content]]])

(defn rich-list-item
  [item]
  [:li.mb-4
   [:div.row.border-bottom
    [:div.p-3.col-xs-12.col-sm-6.col-md-7
     [:div.mb-1.fw-bold \[(:name item)\]]
     [:div.pr-4 {:dangerouslySetInnerHTML {:__html (or (:body item)(:description item))}
                 :style {:text-align "justify" :padding-right "20px" :line-height "1.4"}}]]
    [:div.col-xs-12.col-sm-6.col-md-5.p-2 {:style {:text-align "center"}}
     (when (:thumbnail item)
       [:img.img-fluid.thumb-container
        {:src (:thumbnail item)}])
     (when (:youtube item)
       [:div.video-con
        (parse-youtube item)])
     (when (:video item)
       [:div
        (parse-video item)]) ]]])
