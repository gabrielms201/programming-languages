(ns sorting)


(defn qs-partition-aux
  [[x & xs :as vec] pivot low high]
  (if (empty? vec)
    [low pivot high]
    (if (> x pivot)
      (recur xs pivot low (cons x high))
      (recur xs pivot (cons x low) high))))

(defn partition-middle [vec]
  (when (empty? vec)
    (throw (IllegalArgumentException. "array must not be empty")))
    (let [pivot_idx (quot (count vec) 2)
          vec_without_pivot (concat (subvec vec 0 pivot_idx) (subvec vec (inc pivot_idx)))
          pivot (nth vec pivot_idx)]
      (qs-partition-aux vec_without_pivot pivot '() '())))



(sorting/partition-middle [1])







