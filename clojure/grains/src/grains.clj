(ns grains)

(defn power-of-two [n]
  (reduce * (repeat n 2N)))

(defn square
  "Returns the number of grains on the n-th chessboard square."
  [n]
  (power-of-two (- n 1)))

(defn total
  "Returns the total number of grains on the chessboard."
  []
  (let [xform (map square)]
    (transduce xform + 0 (range 1 65))))
  
