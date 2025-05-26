(ns strain)

(defn my-non-lazy-sequence
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
   (my-non-lazy-sequence (retain pred) coll)))

(defn discard
  "Removes the items in coll for which (pred item) returns true."
  ([pred]
    (retain (complement pred)))
   ([pred coll]
    (my-non-lazy-sequence (discard pred) coll)))
