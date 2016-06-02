(ns fish-front.core
    (:require [reagent.core :as r]
              [reagent.session :as session]
              [secretary.core :as secretary]
              [accountant.core :as accountant]
              [fish-front.routes]))

(defn current-page []
  [:div [(session/get :current-page)]])

(defn nav-handler [path]
  (secretary/dispatch! path))

(defn path-exists? [path]
  (secretary/locate-route path))

(defn mount-root []
  (r/render [current-page] (.getElementById js/document "app")))


;; Initialize app

(defn init! []
  (accountant/configure-navigation!
    {:nav-handler nav-handler
     :path-exists? path-exists?})
  (accountant/dispatch-current!)
  (mount-root))
