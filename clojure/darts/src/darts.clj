(ns darts)

(defn score
  "Calculates the score of a dart throw"
  [x y]
  (let [distance (Math/sqrt (+ (* x x) (* y y)))]
    (cond
      (<= 0 distance 1) 10
      (and (< 1 distance) (<= distance 5)) 5
      (and (< 5 distance) (<= distance 10)) 1
      :else 0)))