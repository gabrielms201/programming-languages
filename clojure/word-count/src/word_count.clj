(ns word-count
  (:require [clojure.string :as str]))

(defn word-count
  "Counts how many times each word occurs in the given string"
  [s]
  (let [words (re-seq #"[a-z0-9]+(?:'[a-z0-9]+)?" (str/lower-case s))] 
   (reduce #(update %1 %2 (fnil inc 0)) {} words)))

