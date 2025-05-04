(ns wordy
  (:require [clojure.string :as str]))

(def ops {"minus" -
          "plus" +
          "divided by" /})

(defn is-number? [s] (boolean (re-matches #"\d+" s)))
(defn stoi [s] (Integer/parseInt s))

(defn calculate [expr] 
  (let [[_ first-term operation second-term] (re-find #"(\d+) (.*) (\d+)" expr)]
    ((ops operation) (stoi first-term) (stoi second-term))))


;;todo: da pra dar uma melhorada ainda
(defn evaluate
  "Evaluates a simple math problem"
  [question]
  (some->> question
    (re-find #"What is (.+)\?")
    second
    (#(if (is-number? %) (stoi %) (calculate %)))))

(and 
(= (evaluate "What is 5 minus 13?") -8)
(= (evaluate "What is 5 plus 13?") 18)
(= (evaluate "What is 5?") 5) 
(= (evaluate "What is 25 divided by 5?") 5))