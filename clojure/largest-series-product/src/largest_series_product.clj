(ns largest-series-product)

(defn take-first-n-adjacent-number [s span]
  (apply str (take span s)))

(defn take-series [span s acc]
  (if (>= (count s) span)
    (recur span
      (rest s)
      (conj acc (take-first-n-adjacent-number s span)))
    acc))

(defn product-of-digits [n]
    (->> n
         (map #(Integer/parseInt (str %)))
         (reduce *)))

(defn is-span-greater-than-string? [span s] 
  (> span (count s) ))

(defn contains-only-digits? [s]
  (every? Character/isDigit s))

(defn validate-input [span s]
  (when (is-span-greater-than-string? span s)
    (throw (IllegalArgumentException. "span must not exceed string length")))
  (when (not (contains-only-digits? s))
    (throw (IllegalArgumentException. "digits input must only contain digits")))
  (when (not (pos? span))
    (throw (IllegalArgumentException. "span must not be negative"))))

(defn largest-product
  "Returns the largest product of any consecutive digits of length span in the string s."
  [span s]
  (validate-input span s)
  (some->>
   (take-series span s [])
   (map product-of-digits)
   (reduce max)
   (int)))



