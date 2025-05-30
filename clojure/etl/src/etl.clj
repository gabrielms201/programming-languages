(ns etl
  (:require [clojure.string :as str]))

(defn transform-reduce ;;solution using reduce
  [source]
  (reduce
   (fn [acc [key val]]
     (reduce (fn [acc v2] (assoc acc (str/lower-case v2) key)) acc val))
   {} source))

(defn transform-for [source] ;;solution using for
  (let [score-vector (for [[score letters] source
                           letter letters]
                       [(str/lower-case letter) score])]
    (into {} score-vector)))

(defn zip-letters [[score letters]]
  (zipmap (map str/lower-case letters) (repeat score)))

(defn transform [source] ;;solution using for
  (let [xform (map zip-letters)]
    (into {} xform source))) ;; easy transduce call





