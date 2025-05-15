(ns say)

(def map-units {0 "zero"
                  1 "one"
                  2 "two"
                  3 "three"
                  4 "four"
                  5 "five"
                  6 "six"
                  7 "seven"
                  8 "eight"
                  9 "nine"} )

(def map-teens {10 "ten"
              11 "eleven"
              12 "twelve"
              13 "thirteen"
              14 "fourteen"
              15 "fifteen"
              16 "sixteen"
              17 "seventeen"
              18 "eighteen"
              19 "nineteen"})

(def map-tens {2 "twenty"
               3 "thirty"
               4 "forty"
               5 "fifty"
               6 "sixty"
               7 "seventy"
               8 "eighty"
               9 "ninety"})

(defn convert-tens [tens-digit last-digit]
  (if (zero? last-digit)
    (map-tens tens-digit) 
    (str (map-tens tens-digit) "-" (map-units last-digit))))

(def negative-number-exception
  (IllegalArgumentException. "Input number must be positive"))


(defn break [num]
  (->>
   (str num)
   (map #(Character/digit % 10))
   (reverse)
   (partition  3 3 nil)
   (reverse)
   (map reverse)
   (map #(Integer/parseInt (apply str %)))))

(defn number [num]
  (when (neg? num) (throw negative-number-exception))
  (let [last-digit (mod num 10)
        tens-digit (quot num 10)]
    (cond 
      (< num 20) (or (map-units num) (map-teens num))
      (< num 100) (convert-tens tens-digit last-digit))))