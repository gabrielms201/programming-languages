(ns nth-prime)

(defn is-prime? [n]
  (cond
    (= n 2) true 
    (or (<= n 1) (even? n)) false
    :else (->> (inc (Math/sqrt n))
            (range 2)
            (not-any? #(zero? (mod n %))))))

(def take-primes (filter is-prime? (range)))

(defn nth-prime 
  "Returns the nth prime number."
  [n]
  (nth take-primes (dec n)))