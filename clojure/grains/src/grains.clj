(ns grains)

;;--- O(N) 
(defn power-of-two-optimized [n]
  (reduce * (repeat n 2N)))

(defn square-non-optimized
  "Returns the number of grains on the n-th chessboard square."
  [n]
  (power-of-two-optimized (- n 1))) 

(defn total-non-optimized
  "Returns the total number of grains on the chessboard."
  []
  (let [xform (map square-non-optimized)]
    (transduce xform + 0 (range 1 65))))

(comment total-non-optimized)

;;--- O(1)

(defn power-of-two [n]
  (.shiftLeft BigInteger/ONE n))

(defn square
  "Returns the number of grains on the n-th chessboard square."
  [n]
  (power-of-two (- n 1)))

(defn total
  "Returns the total number of grains on the chessboard."
  []
  (dec (power-of-two 64)))
  
