(ns wordy
  (:require [clojure.string :as str]))


(defn is-number? [str] (boolean (re-matches #"\d+" str)))

(defn calculate [problem]
  (cond
    (is-number? problem) (Integer/parseInt problem)
    :else (str "Invalid operation for expression: '" problem "'")))

(defn evaluate
  "Evaluates a simple math problem"
  [question]
  (let [[_ problem] (re-find #"What is (.+)\?" question)]
    (calculate problem)))