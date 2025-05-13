(ns space-age)

(def planet-scale {:Mercury 0.2408467
                  :Venus 0.61519726
                  :Earth 1.0
                  :Mars 1.8808158
                  :Jupiter 11.862615
                  :Saturn 29.447498
                  :Uranus 84.016846
                  :Neptune 164.79132})

(defn parse [seconds, planet]
  (->> (/ seconds (*  31557600M (planet-scale planet)))
       (with-precision 4 :rounding CEILING)
       (double)))

(defn on-mercury
  "Returns someone's age on Mercury based on the given age in seconds"
  [seconds]
  (parse seconds :Mercury))

(defn on-venus
  "Returns someone's age on Venus based on the given age in seconds"
  [seconds]
  (parse seconds :Venus))

(defn on-earth
  "Returns someone's age on Earth based on the given age in seconds"
  [seconds]
  (parse seconds :Earth))

(defn on-mars
  "Returns someone's age on Mars based on the given age in seconds"
  [seconds]
  (parse seconds :Mars))

(defn on-jupiter
  "Returns someone's age on Jupiter based on the given age in seconds"
  [seconds]
  (parse seconds :Jupiter))

(defn on-saturn
  "Returns someone's age on Saturn based on the given age in seconds"
  [seconds]
  (parse seconds :Saturn))

(defn on-uranus
  "Returns someone's age on Uranus based on the given age in seconds"
  [seconds]
  (parse seconds :Uranus))

(defn on-neptune
  "Returns someone's age on Neptune based on the given age in seconds"
  [seconds]
  (parse seconds :Neptune))



