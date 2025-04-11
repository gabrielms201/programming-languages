(ns cars-assemble)

(defn production-rate [n]
  (let [prod 221]
    (cond
    (= n 10) (* 0.77 prod n)
    (= n 9) (* 0.80 prod n)
    (>= n 5) (* 0.90 prod n)
    (>= n 1) (* prod n)
    :else 0)))

(defn working-items [n]
  (int (/ (production-rate n) 60)))