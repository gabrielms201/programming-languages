(ns squeaky-clean
  (:require [clojure.string :as str]))

(defn clean-iso-control [s] (apply str (map #(if (Character/isISOControl %) "CTRL" (str %)) s)))

(defn clean-not-letters [s] (apply str (map #(if (or (Character/isLetter %) (= % \_)) % "") s)))

(defn is-greek-letter [c]
  (let [charAsInt (int c)]
    (and (>= charAsInt 945) (<= charAsInt 969))))

(defn clean-greek-letter [s] (apply str (map #(if (is-greek-letter %) "" (str %)) s)))

(defn convert-kebab-to-camel
  [s]
  (if (str/includes? s "-")
    (let [[head & tail] (str/split s #"-")]
      (->
       (cons head (map #(str (str/upper-case (subs % 0 1)) (subs % 1)) tail))
       (str/join)))
    s))
  
(defn clean
  "TODO: add docstring"
  [s]
  (-> s
      (str/replace #" |\r|\t" "_")
      (clean-iso-control)
      (convert-kebab-to-camel)
      (clean-not-letters)
      (clean-greek-letter)
  ))
