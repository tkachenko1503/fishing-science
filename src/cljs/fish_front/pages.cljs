(ns fish-front.pages
  (:require [reagent.core :as r]
            [reagent-forms.core :refer [bind-fields]]))

;; Blocks
(defn row [label input]
  [:div.row
   [:div.col-md-2 [:label label]]
   [:div.col-md-5 input]])

(def fish-form
  [:div
    [:form
      (row "Type of fish:" [:input.form-control {:field :text :id :fish.type}])
      (row "Fish-rod length:" [:input.form-control {:field :numeric :id :rod.length}])]])


;; Pages
(defn home-page []
  [:div
    [:h2 "Welcome to Fishing data science service!"]
    [:div
      "You can submit your results here -> "
      [:a {:href "/fishing-form"}
        "Fishing Results"]]])

(defn fishing-form []
  (let [form-state (r/atom {})]
    (fn []
      [:div
        [:h2 "Tell what you get"]
        [bind-fields fish-form form-state]
        [:label (str @form-state)]])))