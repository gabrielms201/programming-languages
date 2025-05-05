(ns collatz-conjecture)
(defn acc
  "Returns the number of steps it takes to reach 1 according
    to the rules of the Collatz Conjecture."
  [num step]
  (cond 
    (= num 1) step
    (even? num) (recur (/ num 2) (inc step))
    :else (recur (inc (* num 3)) (inc step))))

(defn collatz [num]
  (acc num 0))


