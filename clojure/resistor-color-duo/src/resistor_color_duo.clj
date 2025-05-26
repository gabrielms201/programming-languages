(ns resistor-color-duo)

(def colors
  ["black" "brown" "red" "orange" "yellow" "green" "blue" "violet" "grey" "white"])

(def colors-map (zipmap colors (range 0 10)))

(defn resistor-value
  "Returns the resistor value based on the given colors"
  [colors]
  (let [xform (comp (take 2) (map colors-map) )]
    (->> colors
         (transduce xform str "") 
         (read-string))))
