(ns two-fer
  (:require [clojure.string :as str])
 )

(defn two-fer
  "Return what you will say as you give away the extra cookie"
  ([] (two-fer "you"))
  ([name]
  (str "One for " name ", one for me.")
  ;; function body
  ))
