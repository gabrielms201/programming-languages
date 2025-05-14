(ns high-scores)

(defn scores
  "Returns all scores"
  [scores] (identity scores))

(defn latest
  "Returns the latest score"
  [scores]
  (last scores))

(defn personal-best
  "Returns the top (highest) score"
  [scores]
  (first (sort > scores)))

(defn personal-top-three
  "Returns the top three scores"
  [scores]
  (take 3 (sort > scores)))
