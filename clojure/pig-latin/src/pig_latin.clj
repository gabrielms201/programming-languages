(ns pig-latin
  (:require [clojure.string :as str]))

(defn is-vowel? [c] (contains? #{\a \e \i \o \u} c))

(defn vowels [[head :as s]]
   (when (is-vowel? head) (str s "ay")))

(defn xr-yt [s]
  (when (or (str/starts-with? s "xr") (str/starts-with? s "yt"))
    (str s "ay")))

(defn rule-three-regex [s] (re-matches #"^([^aeiou]*)(qu).*" s))
(defn rule-four-regex [s] (re-matches #"^([^aeiou]+)y.*" s))
(defn rule-two-regex [s] (re-matches #"^([^aeiou]+).*" s))

(defn consonants [s]
  (let [[_ a b :as match] (or (rule-four-regex s) (rule-three-regex s) (rule-two-regex s))
        sufix (str a b)
        prefix (subs s (count sufix))]
    (when match
      (-> prefix 
          (str sufix "ay")))))

(defn translate-word [word]
  (or (vowels word)
      (xr-yt word)
      (consonants word)))

(defn translate
  "Translates phrase from English to Pig Latin"
  [phrase]
  (->> (str/split phrase #" ") 
       (map translate-word) 
       (str/join " ")))