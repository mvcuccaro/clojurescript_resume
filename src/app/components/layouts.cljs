(ns app.components.layouts)

(defn page [content title]
  [:div {:class "m-2 px-1 pb-4 border shadow-lg page"}
   (when title [:h2 {:class "m-3"} title])
   content])

(defn section-container [title content]
  [:div {:class "m-4 px-1 pb-4 border shadow-lg"}
   [:div
    [:div {:class "ps-3 p-2 pt-3 m-2 bg-primary h4 section_title"} title]
    [:div {:class "m-3"}
     content]]])