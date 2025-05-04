(declare calculate calculate-more evaluate-expr calculate-two-term)

(ns wordy
  (:require [clojure.string :as str]))


(declare evaluate-expr calculate)


(def ops {"minus" -
          "plus" +
          "divided by" /
          "multiplied by" *})

(defn is-number? [s] (boolean (re-matches #"\d+|\-\d+" s)))
(defn stoi [s] (Integer/parseInt s))


(defn calculate-two-term [expr]
  (let [[_ first-term operation second-term] (re-find #"(\d+|\-\d+) (.*) (\d+|\-\d+)" expr)]
    ((ops operation) (stoi first-term) (stoi second-term))))

(defn calculate [expr]
  (let [[head & tail]  (rest (re-find #"(.+) (plus|minus|divided by|multiplied by) (.+)" expr))]
    (if (re-matches #"(\d+|\-\d+) (plus|minus|divided by|multiplied by) (\d+|\-\d+)" head)
      (calculate (str/join " " (cons (str (calculate-two-term head)) tail)))
      (calculate-two-term expr) 
      )))

(defn evaluate-expr
  "Evaluates a simple expr"
  [expr]
  (if (is-number? expr)
    (stoi expr)
    (calculate expr)))




  ;;todo: da pra dar uma melhorada ainda


  (defn evaluate
    "Evaluates a simple math problem"
    [question]
    (some->> question
             (re-find #"What is (.+)\?")
             second
             evaluate-expr))


  (str
   (= (evaluate "What is 5 minus 13?") -8) "--"
   (= (evaluate "What is 5 plus 13?") 18) "--"
   (= (evaluate "What is 5?") 5) "--"
   (= (evaluate "What is 25 divided by 5?") 5) "--"
   (= (evaluate "What is 5 plus 13 plus 6?") 24) "---")
