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
    (is (= ['(2 3) 3 '(4 5)] (sorting/qs-partition-aux [5 4 3 2] 3 [] [])))))

(deftest evaluate_test_12
  (testing "odd number of elements"
    (is (= ['(2 3 4) 4 '(5 6)] (sorting/qs-partition-aux [6 5 4 3 2] 4 [] [])))))

(deftest evaluate_test_13
  (testing "negative numbers"
    (is (= ['(-1 -2 -3) -1 '()] (sorting/qs-partition-aux [-3 -2 -1] -1 [] [])))))

(deftest evaluate_test_14
  (testing "positive and negative numbers"
    (is (= ['(-2 -1 0) 0 '(2 1)] (sorting/qs-partition-aux [1 2 0 -1 -2] 0 [] [])))))

(deftest evaluate_test_15
  (testing "reverse sorted input"
    (is (= ['(1 2 3 4 5) 5 '()] (sorting/qs-partition-aux [5 4 3 2 1] 5 [] [])))))


;;

(deftest evaluate_test_16
  (testing "simple half partition"
    (is (= ['(1) 2 '(3)] (sorting/partition-middle [3 2 1])))))


(deftest evaluate_test_17
  (testing "reject empty list half"
    (is (thrown-with-msg? IllegalArgumentException #"^array must not be empty$" (sorting/partition-middle [])))))

(deftest evaluate_test_18
  (testing "pivot is smallest element middle"
    (is (= ['() 1 '(2 3)] (sorting/partition-middle [3 1 2])))))

(deftest evaluate_test_19
  (testing "pivot is largest element middle"
    (is (= '((3 1) 5 ()) (sorting/partition-middle [1 5 3])))))

(deftest evaluate_test_20
  (testing "pivot in middle ordered middle"
    (is (= ['(1 2) 3 '(4 5)] (sorting/partition-middle [5 4 3 2 1])))))

(deftest evaluate_test_21
  (testing "only one element middle"
    (is (= ['() 1 '()] (sorting/partition-middle [1])))))

(deftest evaluate_test_22
  (testing "pivot is negative middle"
    (is (= ['(-3) -1 '(1 0 2)] (sorting/partition-middle [-3 2 -1 0 1])))))

(deftest evaluate_test_23
  (testing "all elements greater than pivot middle"
    (is (= ['() 0 '(1 2 3)] (sorting/partition-middle [3 2 0 1])))))

(deftest evaluate_test_24
  (testing "all elements less than pivot middle"
    (is (= ['(3 4 2 1) 5 '()] (sorting/partition-middle [1 2 5 4 3])))))

(deftest evaluate_test_25
  (testing "pivot equal to all elements middle"
    (is (= ['(2 2) 2 '()] (sorting/partition-middle [2 2 2])))))

(deftest evaluate_test_26
  (testing "even number of elements middle"
    (is (= ['(1) 3 '(4 5)] (sorting/partition-middle [5 4 3 1])))))

(deftest evaluate_test_27
  (testing "odd number of elements middle"
    (is (= ['(2 3) 4 '(5 6)] (sorting/partition-middle [6 5 4 3 2 ])))))

(deftest evaluate_test_28
  (testing "negative numbers middle"
    (is (= ['(-3) -2 '(-1)] (sorting/partition-middle [-3 -2 -1])))))

(deftest evaluate_test_29
  (testing "positive and negative numbers middle"
    (is (= ['(-2 -1) 0 '(2 1)] (sorting/partition-middle [1 2 0 -1 -2])))))

(deftest evaluate_test_30
  (testing "reverse sorted input middle"
    (is (= ['(1 2) 3 '(4 5)] (sorting/partition-middle [5 4 3 2 1])))))