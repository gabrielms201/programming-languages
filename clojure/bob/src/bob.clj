(ns bob
  (:require [clojure.string :as str]))

(def is-silence str/blank?)

(defn is-question? [s]
  (= (last (str/trim s)) \?))

(defn is-yelling? [s]
  (boolean 
   (some->>
    (seq (filter #(Character/isLetter %) s))
    (every? #(Character/isUpperCase %)))))

(def is-yelling-a-question? (every-pred is-question? is-yelling?))

(defn response-for [s] ;; <- arglist goes here
  ;; your code goes here
  (cond
    (is-silence s) "Fine. Be that way!"
    (is-yelling-a-question? s) "Calm down, I know what I'm doing!"
    (is-question? s) "Sure."
    (is-yelling? s) "Whoa, chill out!" 
    :else "Whatever."))
