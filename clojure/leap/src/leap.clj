(ns leap)
(defn is-number-divisible-by? [by number]
  (= (mod number by) 0))
(defn leap-year?
  "Determine if a year is a leap year"
  [year]
  ;; function body
  (and
   (is-number-divisible-by? 4 year)
   (or 
    (not (is-number-divisible-by? 100 year))
    (is-number-divisible-by? 400 year))
   )
  )
