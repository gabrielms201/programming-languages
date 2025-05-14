(ns reverse-string)

(defn reverse-string
  "Reverses the given string"
  [s]
  (apply str (reduce #(conj %1 %2) '() s)))
