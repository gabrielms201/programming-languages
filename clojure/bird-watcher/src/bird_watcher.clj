(ns bird-watcher)

(def last-week [0 2 5 3 7 8 4])

(defn today [birds] (peek birds))

(defn inc-bird [birds] (update birds (- (count birds) 1) inc))

(defn day-without-birds? [birds]
  (cond 
    (empty? birds ) false
    (= 0 (first birds)) true
    :else (recur (rest birds))))

(defn n-days-count [birds n]
  (cond
    (empty? birds) 0
    (<= n 1) (first birds)
    :else (+ (first birds) (n-days-count (rest birds) (- n 1)))
  ))

(defn busy-days [birds]
    (cond 
      (empty? birds) 0 
      (>= (first birds) 5) (+ (busy-days (rest birds )) 1)
      :else (busy-days (rest birds))
    ))

(defn aux? [birds n]
  (cond 
    (empty? birds) true    
    (= (first birds) n) false
    :else (aux? (rest birds) (first birds))
  )
)

(defn odd-week? [birds] (aux? (rest birds) (first birds)))
