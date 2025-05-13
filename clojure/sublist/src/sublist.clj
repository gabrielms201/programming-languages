(ns sublist)

(defn sublist? [coll1 coll2]
  (let [windows (partition (count coll1) 1 coll2)]
    (some (partial = coll1) windows)))

(defn classify
  [coll1 coll2]
  (cond 
    (= coll1 coll2) :equal
    (sublist? coll1 coll2) :sublist
    (sublist? coll2 coll1) :superlist
    :else :unequal))