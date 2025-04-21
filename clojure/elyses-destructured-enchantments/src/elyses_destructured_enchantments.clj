(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [[first-elm & _]]
  first-elm)

(defn second-card
  "Returns the second card from deck."
  [[_ second-elm & _]]
  second-elm)

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [[first-elm second-elm & tail]]
  (into [second-elm first-elm] tail))


(defn discard-top-card
  "Returns a sequence containing the first card and
   a sequence of the remaining cards in the deck."
  [[first-elm & tail]]
  (if (empty? tail)
    [first-elm nil]
    [first-elm (vec tail)]
    )
  
  )

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
   [[first-elm & tail :as deck] ]
  (if (empty? deck)
    face-cards
    (vec (concat [first-elm] face-cards tail))) )
