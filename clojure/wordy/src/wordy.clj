(declare calculate calculate-more evaluate-expr calculate-two-term)

(ns wordy
  (:require [clojure.string :as str]))


(declare evaluate-expr calculate)

(def invalid-syntax (IllegalArgumentException. "syntax error"))
(def invalid-operation (IllegalArgumentException. "unknown operation"))

(def ops {"minus" -
          "plus" +
          "divided by" /
          "multiplied by" *})

(defn is-number? [s] (boolean (re-matches #"\d+|\-\d+" s)))

(defn stoi [s] 
  (when (not (is-number? s))
    (throw invalid-syntax))
  (Integer/parseInt s))


(defn calculate-two-term [expr]
  (let [[_ first-term operation second-term :as expr_re] 
        (re-matches #"(\d+|\-\d+) (plus|minus|divided by|multiplied by) (\d+|\-\d+)" expr)]
    (when (not expr_re) (throw invalid-syntax))
    ((ops operation) (stoi first-term) (stoi second-term))))

(defn is-valid-operation? [expr]
  (boolean (ops (str/trim (apply str (re-seq #"\D+" expr))))))

(defn get-form-from-expression [expr]
  ;;<op> ::= <n> <plus> <n> 
  ;;<op> ::= <n> <plus> <op>
  (let [result (re-find #"(.+) (plus|minus|divided by|multiplied by) (.+)" expr)]
    (when (nil? result)
      (if (is-valid-operation? expr)
        (throw invalid-syntax)
        (throw invalid-operation)))
    (rest result)))

(defn calculate [expr]
  (let [[head & tail] (get-form-from-expression expr)]
    (if (is-number? head)
      (calculate-two-term expr)
      (evaluate-expr (str/join " " (cons (str (evaluate-expr head)) tail))))))

(defn evaluate-expr
  "Evaluates a simple expr"
  [expr]
  (if (is-number? expr)
    (stoi expr)
    (calculate expr)))

(defn evaluate
  "Evaluates a simple math problem"
  [question]
  
  (or
   (some->> question
            (re-find #"What is (.+)\?")
            second
            evaluate-expr)
   (throw invalid-syntax)))

