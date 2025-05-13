(ns pig-latin
  (:require [clojure.string :as str]
            [clojure.string :as string]))

(defn is-vowel? [c] (contains? #{\a \e \i \o \u} c))

(defn is-consonant? [c]
  (and (not (is-vowel? c))
       (Character/isLetter c)))

(defn rule-one? [[head & _ :as s]]
  (or
   (is-vowel? head)
   (some (partial string/starts-with? s) #{"xr" "yt"})))

(defn rule-two? [s] (is-consonant? (first s)))

(defn rule-three [s] (re-matches #"^([^aeiou]*)(qu).*" s))
(defn rule-four [s] (re-matches #"^([^aeiou]+)(y).*" s))

(defn handle-rule-two [s]
  (let [prefix (apply str (take-while is-consonant? s))]
    (-> 
     (subs s (count prefix)) 
     (str prefix "ay"))))

(defn handle-rule-three [s]
  (let [[_ a b] (rule-three s)
        prefix (str a b)]
    (->
     (subs s (count prefix))
    (str prefix "ay")
     )))

(defn handle-rule-four [s] 
  (let [[_ prefix _] (rule-four s)]
    (->
     (subs s (count prefix))
     (str prefix "ay"))))

(defn translate-word [word]
  (cond
     (boolean (rule-four word)) (handle-rule-four word)
     (boolean (rule-three word)) (handle-rule-three word)
     (rule-one? word) (str word "ay")
     (rule-two? word) (handle-rule-two word)))

(defn translate
  "Translates phrase from English to Pig Latin"
  [phrase]
  (->> (str/split phrase #" ") 
       (map translate-word) 
       (str/join " ")))
  

 (= "ellowyay" (pig-latin/translate "yellow"))
(pig-latin/translate "yellow")