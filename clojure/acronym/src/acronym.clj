(ns acronym
  (:require [clojure.string :as str]))

(defn acronym
  "Converts phrase to its acronym."
  [phrase]
  (-> phrase
      str/upper-case
      (str/split #" |-|_")
      (->> (map first) (apply str))))