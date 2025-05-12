(ns all-your-base)
(require '[clojure.math :as math])

(defn convert-decimal-to-base [base-input number]
  (if (zero? number) '(0)
      (loop [baseInput base-input
             number number
             acc '()]
        (let [result (quot number baseInput)]
          (if (zero? number) acc
              (recur baseInput
                     result
                     (conj acc (mod number baseInput))))))))

(defn has-valid-digits? [number base-input base-output]
  (and 
   (not-any? neg? number)
   (every? #(< % base-input) number)
   (not (<= base-input 1 ))
   (not (<= base-output 1))))

(defn from-base-to-decimal [base-input number]
    (loop [i (dec (count number))
            baseInput base-input
            [head & tail :as number] number
            acc 0]
       (if (empty? number) (int acc)
           (recur (dec i) baseInput tail (+ acc (* head (math/pow baseInput i)))))))
  

(defn convert [base-input number base-output]
  (when (has-valid-digits? number base-input base-output)
    (if (empty? number) '()
        (some->> number
            (from-base-to-decimal base-input)
            (convert-decimal-to-base base-output)))))