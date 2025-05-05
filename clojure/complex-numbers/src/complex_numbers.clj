(ns complex-numbers
  (:require [clojure.math :as math]))

(defn square [n] (math/pow n 2))

(defn real [[a _]]  
  a)

(defn imaginary [[_ b]] 
  b)

(defn abs [[a b]] 
  (math/sqrt
   (+ (square a)
      (square b))))

(defn conjugate [[a b]] 
  [a (- b)]
)

(defn add [[a b] [c d]] 
  [(+ a c) (+ b d)])

(defn sub [[a b] [c d]] 
  [(- a c) (- b d)])

(defn mul [[a b] [c d]] 
  (let [mult1 (- (* a c) (* b d))
        mult2 (+ (* b c) (* a d))]
    [mult1 mult2])
  )

(defn div [[a b] [c d]] 
  (let [div1 (/ (+ (* a c) (* b d)) 
                (+ (square c) (square d)))
        div2 (/ (- (* b c) (* a d))
                (+ (square c) (square d)))]
   [div1 div2])
  )
