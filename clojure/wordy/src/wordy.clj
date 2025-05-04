(ns wordy
  (:require [clojure.string :as str]))


(defn is-number? [s] (boolean (re-matches #"\d+" s)))
(defn calculate-number [s] (Integer/parseInt s))

(defn is-sum? [s] (boolean (re-matches #"(\d+) plus (\d+)" s)))
(defn is-subtraction? [s] (boolean (re-matches #"(\d+) minus (\d+)" s)))

(defn calculate-sum [expr]
  (let [[_ first-term second-term] (re-find #"(\d+) plus (\d+)" expr)]
    (+ (calculate-number first-term) (calculate-number second-term))))

(defn calculate-sub [expr]
  (let [[_ first-term second-term] (re-find #"(\d+) minus (\d+)" expr)]
    (- (calculate-number first-term) (calculate-number second-term))))

(defn calculate [problem]
  (cond
    (is-number? problem) (calculate-number problem)
    (is-sum? problem) (calculate-sum problem)
    (is-subtraction? problem) (calculate-sub problem)

    :else (str "Invalid operation for expression: '" problem "'")))

(defn evaluate
  "Evaluates a simple math problem"
  [question]
  (let [[_ problem] (re-find #"What is (.+)\?" question)]
    (calculate problem)))