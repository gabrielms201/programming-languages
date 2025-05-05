(ns difference-of-squares
  (:require [clojure.math :as math]))

(defn square [n] (math/pow n 2))
(defn take-first [n] (range 1 (inc n)))

(defn square-of-sum
  "Returns the square of the sum of the numbers up to the given number"
  [n]
  ;; function body
  (->> (take-first n)
       (apply +)
       (square)
       (int)))
  
(defn sum-of-squares
  "Returns the sum of the squares of the numbers up to the given number"
  [n]
  ;; function body
  (->> (take-first n)
       (map square)
       (apply +)
       (int)))

(defn difference
  "Returns the difference between the square of the sum of numbers up to a given number and the sum of the squares of those numbers"
  [n]
  ;; function body
  (- (square-of-sum n) (sum-of-squares n)))

(square-of-sum 1)