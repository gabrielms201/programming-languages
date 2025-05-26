(ns strain-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.string :as str]
            strain))

(deftest retain_test_1
  (testing "keep on empty vector returns empty vector"
    (is (= []
           (strain/retain (fn [_] true)
                          [])))))

(deftest retain_test_2
  (testing "keeps everything"
    (is (= [1 3 5]
           (strain/retain (fn [_] true)
                          [1 3 5])))))

(deftest retain_test_3
  (testing "keeps nothing"
    (is (= []
           (strain/retain (fn [_] false)
                          [1 3 5])))))

(deftest retain_test_4
  (testing "keeps first and last"
    (is (= [1 3]
           (strain/retain odd?
                          [1 2 3])))))

(deftest retain_test_5
  (testing "keeps neither first nor last"
    (is (= [2]
           (strain/retain even?
                          [1 2 3])))))

(deftest retain_test_6
  (testing "keeps strings"
    (is (= ["zebra" "zombies" "zealot"]
           (strain/retain (fn [x] (str/starts-with? x "z"))
                          ["apple" "zebra" "banana" "zombies" "cherimoya" "zealot"])))))

(deftest retain_test_7
  (testing "keeps vectors"
    (is (= [[5 5 5] [5 1 2] [1 5 2] [1 2 5]]
           (strain/retain (fn [x] (boolean (some #{5} x)))
                          [[1 2 3] [5 5 5] [5 1 2] [2 1 2] [1 5 2] [2 2 1] [1 2 5]])))))

(deftest retain_test_8
  (testing "should be able to call arity 0 for conj reduce function"
    (is (= [] (((strain/retain odd?) conj))))))

(deftest retain_test_9
  (testing "should be able to call arity 1 for conj reduce function"
    (is (= [1 2 3] (((strain/retain odd?) conj) [1 2 3])))))

(deftest retain_test_10
  (testing "should be able to call arity 2 for conj reduce function"
    (is (= [1 2 3 4] (((strain/retain pos?) conj) [1 2 3] 4)))))

(deftest retain_test_11
  (testing "should be able to call arity 0 for - reduce function"
    (is (thrown? clojure.lang.ArityException (((strain/retain odd?) -))))))

(deftest retain_test_12
  (testing "should be able to call arity 1 for - reduce function"
    (is (= -10 (((strain/retain odd?) -) 10)))))

(deftest retain_test_12
  (testing "should be able to call arity 2 for - reduce function"
    (is (= 9 (((strain/retain pos?) -) 10 1)))))

(deftest discard_test_1
  (testing "discard on empty vector returns empty vector"
    (is (= []
           (strain/discard (fn [_] true)
                           [])))))

(deftest discard_test_2
  (testing "discards everything"
    (is (= []
           (strain/discard (fn [_] true)
                           [1 3 5])))))

(deftest discard_test_3
  (testing "discards nothing"
    (is (= [1 3 5]
           (strain/discard (fn [_] false)
                           [1 3 5])))))

(deftest discard_test_4
  (testing "discards first and last"
    (is (= [2]
           (strain/discard odd?
                           [1 2 3])))))

(deftest discard_test_5
  (testing "discards neither first nor last"
    (is (= [1 3]
           (strain/discard even?
                           [1 2 3])))))

(deftest discard_test_6
  (testing "discards strings"
    (is (= ["apple" "banana" "cherimoya"]
           (strain/discard (fn [x] (str/starts-with? x "z"))
                           ["apple" "zebra" "banana" "zombies" "cherimoya" "zealot"])))))

(deftest discard_test_7
  (testing "discards vectors"
    (is (= [[1 2 3] [2 1 2] [2 2 1]]
           (strain/discard (fn [x] (boolean (some #{5} x)))
                           [[1 2 3] [5 5 5] [5 1 2] [2 1 2] [1 5 2] [2 2 1] [1 2 5]])))))

(deftest discard_test_8
  (testing "should be able to call arity 0 for conj reduce function"
    (is (= [] (((strain/discard odd?) conj))))))

(deftest discard_test_9
  (testing "should be able to call arity 1 for conj reduce function"
    (is (= [1 2 3] (((strain/discard odd?) conj) [1 2 3])))))

(deftest discard_test_10
  (testing "should be able to call arity 2 for conj reduce function"
    (is (= [1 2 3 4] (((strain/discard neg?) conj) [1 2 3] 4)))))

(deftest discard_test_11
  (testing "should be able to call arity 0 for - reduce function"
    (is (thrown? clojure.lang.ArityException (((strain/discard odd?) -))))))

(deftest discard_test_12
  (testing "should be able to call arity 1 for - reduce function"
    (is (= -10 (((strain/discard odd?) -) 10)))))

(deftest discard_test_12
  (testing "should be able to call arity 2 for - reduce function"
    (is (= 9 (((strain/discard neg?) -) 10 1)))))
