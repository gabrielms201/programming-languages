(ns anagram 
  (:require [clojure.string :as str]))


(defn build-counter [word]
  (reduce #(update %1 (str/upper-case %2) (fnil inc 0)) {} word))

(defn is-anagram-for? [word input]
  (let [word-upper (str/upper-case input) input-upper (str/upper-case word)]
  (and (not (= word-upper input-upper))
       (= (build-counter word) (build-counter input)))))

(defn anagrams-for [word prospect-list]
  (filter #(is-anagram-for? word %) prospect-list))
