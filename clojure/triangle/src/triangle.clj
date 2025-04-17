(ns triangle)
(defn is-triangle?
  [a b c]
  (and
   (every? #(> % 0) [a b c])
   (>= (+ a, b) c)
   (>= (+ b, c) a)
   (>= (+ a, c) b)
   ))

(defn equilateral?
  "Returns true if the triangle with sides a, b, and c is equilateral; otherwise, returns false"
  [a b c]
  (and 
   (is-triangle? a b c)
   (= a b c)
   )
  ;; function body
  )

(defn isosceles?
  "Returns true if the triangle with sides a, b, and c is isosceles; otherwise, returns false"
  [a b c]
  ;; function body
  (and
   (is-triangle? a b c)
   (or
    (= a b)
    (= b c)
    (= a c))))

(defn scalene?
  "Returns true if the triangle with sides a, b, and c is scalene; otherwise, returns false"
  [a b c]
  (and 
   (is-triangle? a b c)
   (= (count (set [a b c])) 3)))
