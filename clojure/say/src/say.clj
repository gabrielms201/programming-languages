(ns say
  (:require [clojure.string :as str]))

(def map-units {0 "zero"
                1 "one"
                2 "two"
                3 "three"
                4 "four"
                5 "five"
                6 "six"
                7 "seven"
                8 "eight"
                9 "nine"})

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

(def negative-number-exception (IllegalArgumentException. "Input number must be positive"))

(defn break [num]
  (->>
   (str num)
   (map #(Character/digit % 10))
   (reverse)
   (partition 3 3 nil)
   (reverse)
   (map reverse)
   (map #(Integer/parseInt (apply str %)))))

(defn arrange-partition-parts
  ([num]
   (when (> (count num) 4)
     (throw (IllegalArgumentException. "Too many partitions")))
     (let [[hundred thousand million billion] (concat (reverse num) (repeat "zero"))]
       (str/join " "
          (cond-> []
            (not= "zero" billion) (conj (str billion " billion"))
            (not= "zero" million) (conj (str million " million"))
            (not= "zero" thousand) (conj (str thousand " thousand"))
            (not= "zero" hundred) (conj (str hundred)))))))

  (defn say-up-to-hundred [num]
    (let [last-digit (mod num 10)
          tens-digit (quot num 10)
          hundreds-digit (quot num 100)]
      (cond
        (< num 20) (or (map-units num) (map-teens num))
        (< num 100) (convert-tens tens-digit last-digit)
        (and (<= num 999) (zero? last-digit)) (str (map-units hundreds-digit) " hundred")
        (<= num 999) (str (map-units hundreds-digit) " hundred " (say-up-to-hundred (mod num 100)))
        :else "")))

  (defn number [num]
    (when (neg? num) (throw negative-number-exception))
    (if (zero? num) "zero"
        (some->> num
            break
            (map say-up-to-hundred)
            (arrange-partition-parts))))


