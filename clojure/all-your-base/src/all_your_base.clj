(ns all-your-base)
(require '[clojure.math :as math])

(defn convert-decimal-to-base [base-input digits]
  (if (zero? digits) '(0)
      (loop [baseInput base-input
             digits digits
             acc '()]
        (let [result (quot digits baseInput)]
          (if (zero? digits) acc
              (recur baseInput
                     result
                     (conj acc (mod digits baseInput))))))))

(defn is-valid-input? [digits base-input base-output]
  (and 
   (not-any? neg? digits)
   (every? #(< % base-input) digits)
   (not (<= base-input 1 ))
   (not (<= base-output 1))))

(defn from-base-to-decimal [base-input digits]
    (loop [i (dec (count digits))
            baseInput base-input
            [head & tail :as digits] digits
            acc 0]
       (if (empty? digits) (int acc)
           (recur (dec i) baseInput tail (+ acc (* head (math/pow baseInput i)))))))
  

(defn convert [base-input digits base-output]
  (when (is-valid-input? digits base-input base-output)
    (if (empty? digits) '()
        (some->> digits
            (from-base-to-decimal base-input)
            (convert-decimal-to-base base-output)))))