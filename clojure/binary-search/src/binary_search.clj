(ns binary-search)

(defn search-for
  "Returns the index of num in coll, or -1 if num is not found."
  [num coll]
  (loop [low 0
         high (- (count coll) 1)] 
  (let [pivot (+ low (quot (- high low) 2)) 
        element (get coll pivot)]
    (cond 
      (= element num) pivot
      (>= low high) -1
      (<= element num) (recur (inc pivot) high)
      :else (recur low (dec pivot))))))
