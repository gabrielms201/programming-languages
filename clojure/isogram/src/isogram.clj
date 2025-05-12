(ns isogram
  (:require [clojure.string :as str]))

(defn isogram?
  "Returns true if the given string is an isogram; otherwise, returns false"
  [s] 
  (->> s
       (str/upper-case)
       (filter (partial Character/isLetter))
        frequencies
        vals
        (every? #{1})))
