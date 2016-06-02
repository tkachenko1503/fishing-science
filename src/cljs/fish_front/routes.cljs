(ns fish-front.routes
  (:require [secretary.core :refer-macros [defroute]]
            [reagent.session :as session]
            [fish-front.pages :refer [home-page fishing-form]]))

(defroute "/" []
  (session/put! :current-page #'home-page))

(defroute "/fishing-form" []
  (session/put! :current-page #'fishing-form))