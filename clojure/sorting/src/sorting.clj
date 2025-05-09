(ns sorting)


(defn qs-partition-aux
  [[x & xs :as lst] pivot low high]
  (if (empty? lst) 
    [low pivot high]
    (if (> x pivot)
      (recur xs pivot low (cons x high))
      (recur xs pivot (cons x low ) high))))

(sorting/qs-partition-aux [3 2 1] 0 '() '())



(defn sorting
  [])
