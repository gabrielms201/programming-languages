(ns eliuds-eggs)

(defn decimal-to-little-endian-bin-idiomatic [num]
  (->> num
    (iterate #(quot % 2))
    (take-while pos?)
    (map #(mod % 2))))

(defn decimal-to-little-endian-bin [num]
  (loop [q num
         acc []]
    (if (pos? q)
      (recur (quot q 2) (conj acc (mod q 2)))
      acc)))

(defn egg-count
  "Returns the number of 1 bits in the binary representation of the given number."
  [number]
  (let [bin-number-as-little-endian (decimal-to-little-endian-bin-idiomatic number)
        reduction-function #(if (= 1 %2) (inc %1) %1)
        egg-quantity (reduce reduction-function 0 bin-number-as-little-endian)]
    egg-quantity))