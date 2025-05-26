(ns strain)

(defn my-non-lazy-seq
  [xform coll]
  (loop [[head & tail] coll 
         acc []]
    (if (nil? head)
      acc
      (recur tail ((xform conj) acc head)))))

(defn retain
  "Keeps the items in coll for which (pred item) returns true."
  ([pred]
   (fn [rf]
     (fn
       ([] (rf))
       ([acc] (rf acc))
       ([acc input]
        (if (pred input)
          (rf acc input)
          acc)))))
  ([pred coll]
   (my-non-lazy-seq (retain pred) coll)))

(defn discard
  "Removes the items in coll for which (pred item) returns true."
  ([pred]
    (fn [rf]
      (fn
        ([] (rf))
        ([acc] (rf acc))
        ([acc input]
         (if (pred input)
           acc
           (rf acc input))))))
   ([pred coll]
    (my-non-lazy-seq (discard pred) coll)))
