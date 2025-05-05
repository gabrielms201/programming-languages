(ns armstrong-numbers)

(defn int-pow [base exp] (reduce *' (repeat exp base)))

(defn armstrong?
  "Returns true if the given number is an Armstrong number; otherwise, returns false"
  [num]
  (let [length (count (str num))]
   (= (->> num
      (str)
      (map str)
      (map bigint)
      (map #(int-pow % length))
      (apply +)
         )
    num)))
  
  
