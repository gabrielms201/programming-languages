(ns card-games)

 (defn rounds
   "Takes the current round number and returns 
   a `list` with that round and the _next two_."
   [n]
   (list n (+ n 1) (+ n 2)))

 (defn concat-rounds
   "Takes two lists and returns a single `list` 
   consisting of all the rounds in the first `list`, 
   followed by all the rounds in the second `list`"
   [l1 l2]
   (concat l1 l2))

 (defn contains-round?
   "Takes a list of rounds played and a round number.
   Returns `true` if the round is in the list, `false` if not."
   [l n] 
   (boolean (some #(= % n) l)))

 (defn card-average
   "Returns the average value of a hand"
   [hand]
     (if (empty? hand)
       0.00
       (double (/ (apply + hand) (count hand)))))
   

 (defn approx-average?
   "Returns `true` if average is equal to either one of:
  - Take the average of the _first_ and _last_ number in the hand.
  - Using the median (middle card) of the hand."
   [hand]
   (let [first (double (/ (+ (first hand) (last hand)) 2))
         second (double (nth hand (int (/ (count hand) 2))))
         actual-average (card-average hand)]
     (or
      (= first actual-average)
      (= second actual-average))))

 (defn average-even-odd?
   "Returns true if the average of the cards at even indexes 
   is the same as the average of the cards at odd indexes."
   [hand]
   (let [indexes (take (count hand) (range))
         oddsIndexes (filter odd? indexes)
         evenIndexes (filter even? indexes)]
     (=
      (card-average (map #(nth hand %) oddsIndexes))
      (card-average (map #(nth hand %) evenIndexes)))))

 (defn isJack? [n] (= n 11))
 (defn maybe-double-last
   "If the last card is a Jack (11), doubles its value
   before returning the hand."
   [hand] 
   (if (isJack? (last hand))
      (concat (butlast hand) (list (* (last hand) 2)))
      hand))
