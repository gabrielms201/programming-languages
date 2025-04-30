(ns robot-simulator)


(def directions [:north
                 :east
                 :south
                 :west])
(defn robot
  "Creates a robot at the given coordinates, facing the given direction."
  [coordinates bearing] {:coordinates coordinates :bearing bearing})


(defn turn-left [{:keys [coordinates bearing]}]
  (let [new-direction
        (or (some->> bearing
              (.indexOf directions)
              dec
              (get directions)) :west)]
    (robot coordinates new-direction)))

(defn turn-right [{:keys [coordinates bearing]}]
  (let [new-direction
        (or (some->> bearing
              (.indexOf directions)
              inc
              (get directions)) :north)]
    (robot coordinates new-direction)))


(defn advance [robot] 
  (case (:bearing robot)
    :north (update-in robot [:coordinates :y] inc)
    :south (update-in robot [:coordinates :y] dec)
    :east (update-in robot [:coordinates :x] inc)
    :west (update-in robot [:coordinates :x] dec)))

(defn move [robot-state instruction]
  (case instruction
    \R (turn-right robot-state)
    \L (turn-left robot-state)
    \A (advance robot-state)))

(defn simulate
  "Simulates the robot's movements based on the given instructions
  and updates its state."
  [instructions robot-state] (reduce move robot-state instructions))
