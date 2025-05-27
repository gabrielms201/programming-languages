(ns etl
  (:require [clojure.string :as str]))

(defn transform
  [source]
  (reduce
   (fn [acc [key val]]
     (reduce (fn [acc v2] (assoc acc (str/lower-case v2) key)) acc val))
   {} source)
  )