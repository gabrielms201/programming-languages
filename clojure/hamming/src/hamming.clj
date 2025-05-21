(ns hamming)

(defn distance-loop
  "Returns the hamming distance between two DNA strands."
  [strand1 strand2]
  (when (not= (count strand1) (count strand2))
    (throw (IllegalArgumentException. "strands must be of equal length")) )
  (loop [distance 0
         [head1 & tail1] strand1
         [head2 & tail2] strand2]
    (if (nil? head1)
      distance
      (let [newDistance (if (not= head1 head2) 
                          (inc distance) 
                          distance)]
      (recur newDistance tail1 tail2)))))

(defn distance-reduce
  "Returns the hamming distance between two DNA strands."
  [strand1 strand2]
  (when (not= (count strand1) (count strand2))
    (throw (IllegalArgumentException. "strands must be of equal length")))
  (->> (map vector strand1 strand2)
       (reduce
        (fn [acc [a b]] (if (not= a b) (inc acc) acc))
        0)))

(defn distance
  "Returns the hamming distance between two DNA strands."
  [strand1 strand2]
  (when (not= (count strand1) (count strand2))
    (throw (IllegalArgumentException. "strands must be of equal length")))
  (->> (map = strand1 strand2)
       (filter false?)
       count))
