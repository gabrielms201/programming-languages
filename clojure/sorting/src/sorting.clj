(ns sorting)

(defn partition-aux
  [[x & xs :as v] pivot low high]
  (if (empty? v)
    [low pivot high]
    (if (> x pivot)
      (recur xs pivot low (cons x high))
      (recur xs pivot (cons x low) high))))

(defn partition-middle [coll]
  (when (empty? coll)
    (throw (IllegalArgumentException. "coll must not be empty")))
    (let [pivot_idx (quot (count coll) 2)
          coll_without_pivot (concat (take pivot_idx coll) (drop (inc pivot_idx) coll))
          pivot (nth coll pivot_idx)]
      (partition-aux coll_without_pivot pivot '() '())))

(defn quick-sort [vec]
  (if (empty? vec) []   
    (let [[left middle right] (partition-middle vec)]
      (concat (quick-sort left) [middle] (quick-sort right)))))