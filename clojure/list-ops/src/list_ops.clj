(ns list-ops)
(defn foldl
  "Given a function, a vector, and initial accumulator, it folds (reduces) each item into the accumulator from the left"
  [f coll acc]
  (loop [f f
         coll coll
         acc acc]
    (let [[head & tail] coll]
      (if (empty? coll) acc
          (recur f tail (f acc head))))))

(defn foldr
  "Given a function, a vector, and an initial accumulator, it folds (reduces) each item into the accumulator from the right"
  [f coll acc]
  (loop [f f
         coll coll
         acc acc]
    (let [head (butlast coll)
          tail (last coll)]
      (if (empty? coll) acc
          (recur f head (f acc tail))))))

(defn append
  "Given two vectors, it adds all the items in the second vector to the end of the first vector"
  [coll1 coll2] 
  (foldl #(conj %1 %2) coll2 coll1))

(defn concatenate
  "Given a vector of vectors, it combines all the vectors into one flattened vector"
  [colls]
  (foldl #(append %1 %2) colls []))

(defn select-if
  "Given a predicate and a vector, it returns the vector of all items for which predicate(item) is true"
  [pred coll]
  (foldl (fn [acc cur] (if (pred cur) (conj acc cur) acc)) coll []))

(defn length
  "Given a vector, it returns the number of items within it"
  [coll]
  (foldr (fn [acc _ ] (inc acc)) coll 0))

(defn apply-to-each
  "Given a function and a vector, it returns the vector of the results of applying function(item) on all items"
  [f coll]
  (foldl #(conj %1 (f %2)) coll []))

(defn reverse-order
  "Given a vector, it returns a vector with all the original items, but in reverse order"
  [coll]
  (foldr #(conj %1 %2) coll []))

(list-ops/concatenate [[1 2] [3] [] [4 5 6]])