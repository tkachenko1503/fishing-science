(ns fish-front.prod
  (:require [fish-front.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
