(ns raindrops
  (:require [clojure.string :as str]))

(defn is-divisible-by? [n number]
  (zero? (mod number n)))

(defn convert
  "Converts a number to its corresponding string of raindrop sounds."
  [number]
  (let [result (str
        (when (is-divisible-by? 3 number) "Pling")
        (when (is-divisible-by? 5 number) "Plang")
        (when (is-divisible-by? 7 number) "Plong"))]
  (if (str/blank? result)
       (str number)
       result)))
