(ns interest-is-interesting)
(require '[clojure.math :as math])


(defn interest-rate
  "Returns the interest rate based on the specified balance."
  [balance]
  (cond
    (< balance 0) -3.213
    (>= balance 5000) 2.475
    (>= balance 1000) 1.621
    :else 0.5)
  )

(defn annual-balance-update
  "Returns the annual balance update, taking into account the interest rate."
  [balance]
  (+ balance (* balance (bigdec (/ (abs (interest-rate balance)) 100M))))
  )


(def balance 550.5M)
(def tax-free-percentage 2.5)

(defn amount-to-donate
  "Returns how much money to donate based on the balance and the tax-free percentage."
  [balance tax-free-percentage]
  (cond
    (>= balance 0) (int  (* balance (/ tax-free-percentage 100) 2))
    :else 0)
)
  