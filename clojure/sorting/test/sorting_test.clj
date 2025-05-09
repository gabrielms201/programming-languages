(ns sorting-test
  (:require [clojure.test :refer [deftest testing is]]
            sorting))

(deftest evaluate_test_1
  (testing "simple partition"
    (is (= ['(1 2) 2 '(3)] (sorting/qs-partition-aux [3 2 1] 2 [] [])))))


(deftest evaluate_test_2
  (testing "empty list"
    (is (= ['() 2 '()] (sorting/qs-partition-aux [] 2 [] [])))))

(deftest evaluate_test_3
  (testing "pivot is smallest element"
    (is (= ['(1) 1 '(2 3)] (sorting/qs-partition-aux [3 2 1] 1 [] [])))))

(deftest evaluate_test_4
  (testing "pivot is largest element"
    (is (= '((3 2 1) 3 ()) (sorting/qs-partition-aux [1 2 3] 3 [] [])))))

(deftest evaluate_test_5
  (testing "pivot in middle"
    (is (= ['(1 2 3) 3 '(4 5)] (sorting/qs-partition-aux [5 4 3 2 1] 3 [] [])))))

(deftest evaluate_test_6
  (testing "only one element"
    (is (= ['(1) 1 '()] (sorting/qs-partition-aux [1] 1 [] [])))))

(deftest evaluate_test_7
  (testing "pivot is negative"
    (is (= ['(-1) -1 '(0 1 2)] (sorting/qs-partition-aux [2 1 0 -1] -1 [] [])))))

(deftest evaluate_test_8
  (testing "all elements greater than pivot"
    (is (= ['(0) 0 '(1 2 3)] (sorting/qs-partition-aux [0 3 2 1] 0 [] [])))))

(deftest evaluate_test_9
  (testing "all elements less than pivot"
    (is (= ['(5 4 3 2 1) 5 '()] (sorting/qs-partition-aux [1 2 3 4 5] 5 [] [])))))

(deftest evaluate_test_10
  (testing "pivot equal to all elements"
    (is (= ['(2 2 2) 2 '()] (sorting/qs-partition-aux [2 2 2] 2 [] [])))))

(deftest evaluate_test_11
  (testing "even number of elements"
    (is (= ['(1 2 3) 3 '(4 5)] (sorting/qs-partition-aux [5 4 3 2 1] 3 [] [])))))

(deftest evaluate_test_12
  (testing "odd number of elements"
    (is (= ['(1 2 3 4) 4 '(5 6)] (sorting/qs-partition-aux [6 5 4 3 2 1] 4 [] [])))))

(deftest evaluate_test_13
  (testing "negative numbers"
    (is (= ['(-1 -2 -3) -1 '()] (sorting/qs-partition-aux [-3 -2 -1] -1 [] [])))))

(deftest evaluate_test_14
  (testing "positive and negative numbers"
    (is (= ['(-2 -1 0) 0 '(2 1)] (sorting/qs-partition-aux [1 2 0 -1 -2] 0 [] [])))))

(deftest evaluate_test_15
  (testing "reverse sorted input"
    (is (= ['(1 2 3 4 5) 5 '()] (sorting/qs-partition-aux [5 4 3 2 1] 5 [] [])))))