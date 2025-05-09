(ns sorting-test
  (:require [clojure.test :refer [deftest testing is]]
            sorting))

(deftest evaluate_test_1
  (testing "simple partition"
    (is (= ['(1 2) 2 '(3)] (sorting/partition-aux [3 2 1] 2 [] [])))))

(deftest evaluate_test_2
  (testing "empty list"
    (is (= ['() 2 '()] (sorting/partition-aux [] 2 [] [])))))

(deftest evaluate_test_3
  (testing "pivot is smallest element"
    (is (= ['(1) 1 '(2 3)] (sorting/partition-aux [3 2 1] 1 [] [])))))

(deftest evaluate_test_4
  (testing "pivot is largest element"
    (is (= '((3 2 1) 3 ()) (sorting/partition-aux [1 2 3] 3 [] [])))))

(deftest evaluate_test_5
  (testing "pivot in middle"
    (is (= ['(1 2 3) 3 '(4 5)] (sorting/partition-aux [5 4 3 2 1] 3 [] [])))))

(deftest evaluate_test_6
  (testing "only one element"
    (is (= ['(1) 1 '()] (sorting/partition-aux [1] 1 [] [])))))

(deftest evaluate_test_7
  (testing "pivot is negative"
    (is (= ['(-1) -1 '(0 1 2)] (sorting/partition-aux [2 1 0 -1] -1 [] [])))))

(deftest evaluate_test_8
  (testing "all elements greater than pivot"
    (is (= ['(0) 0 '(1 2 3)] (sorting/partition-aux [0 3 2 1] 0 [] [])))))

(deftest evaluate_test_9
  (testing "all elements less than pivot"
    (is (= ['(5 4 3 2 1) 5 '()] (sorting/partition-aux [1 2 3 4 5] 5 [] [])))))

(deftest evaluate_test_10
  (testing "pivot equal to all elements"
    (is (= ['(2 2 2) 2 '()] (sorting/partition-aux [2 2 2] 2 [] [])))))

(deftest evaluate_test_11
  (testing "even number of elements"
    (is (= ['(2 3) 3 '(4 5)] (sorting/partition-aux [5 4 3 2] 3 [] [])))))

(deftest evaluate_test_12
  (testing "odd number of elements"
    (is (= ['(2 3 4) 4 '(5 6)] (sorting/partition-aux [6 5 4 3 2] 4 [] [])))))

(deftest evaluate_test_13
  (testing "negative numbers"
    (is (= ['(-1 -2 -3) -1 '()] (sorting/partition-aux [-3 -2 -1] -1 [] [])))))

(deftest evaluate_test_14
  (testing "positive and negative numbers"
    (is (= ['(-2 -1 0) 0 '(2 1)] (sorting/partition-aux [1 2 0 -1 -2] 0 [] [])))))

(deftest evaluate_test_15
  (testing "reverse sorted input"
    (is (= ['(1 2 3 4 5) 5 '()] (sorting/partition-aux [5 4 3 2 1] 5 [] [])))))


;;

(deftest evaluate_test_16
  (testing "simple half partition"
    (is (= ['(1) 2 '(3)] (sorting/partition-middle [3 2 1])))))


(deftest evaluate_test_17
  (testing "reject empty list half"
    (is (thrown-with-msg? IllegalArgumentException #"^coll must not be empty$" (sorting/partition-middle [])))))

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

(deftest evaluate_test_31
  (testing "simple sorted"
    (is (= '(1 2 3 4 5) (sorting/quick-sort [1 2 5 4 3])))))

(deftest evaluate_test_32
  (testing "simple sorted using list"
    (is (= '(1 2 3 4 5) (sorting/quick-sort '(1 2 5 4 3))))))

(deftest evaluate_test_31
  (testing "simple sorted"
    (is (= '(1 2 3 4 5) (sorting/quick-sort [1 2 3 4 5])))))

(deftest evaluate_test_32
  (testing "reverse sorted"
    (is (= '(1 2 3 4 5) (sorting/quick-sort [5 4 3 2 1])))))

(deftest evaluate_test_33
  (testing "random order"
    (is (= '(1 2 3 4 5) (sorting/quick-sort [1 2 5 4 3])))))

(deftest evaluate_test_34
  (testing "all equal elements"
    (is (= '(1 1 1 1) (sorting/quick-sort [1 1 1 1])))))

(deftest evaluate_test_35
  (testing "two elements"
    (is (= '(1 2) (sorting/quick-sort [2 1])))))

(deftest evaluate_test_36
  (testing "single element"
    (is (= '(42) (sorting/quick-sort [42])))))

(deftest evaluate_test_37
  (testing "empty list"
    (is (= '() (sorting/quick-sort [])))))

(deftest evaluate_test_38
  (testing "negative numbers"
    (is (= '(-5 -3 -1 0 2 4) (sorting/quick-sort [0 -1 4 -3 2 -5])))))

(deftest evaluate_test_39
  (testing "duplicates mixed"
    (is (= '(1 2 2 3 4 4 5) (sorting/quick-sort [4 2 5 2 1 4 3])))))

(deftest evaluate_test_40
  (testing "large numbers"
    (is (= '(10 100 1000 10000) (sorting/quick-sort [1000 10 100 10000])))))

(deftest evaluate_test_41
  (testing "floats and ints"
    (is (= '(-1.5 0 1 2.3 3.14) (sorting/quick-sort [1 2.3 3.14 -1.5 0])))))

(deftest evaluate_test_42
  (testing "already sorted negative"
    (is (= '(-10 -9 -8 -7) (sorting/quick-sort [-10 -9 -8 -7])))))

(deftest evaluate_test_43
  (testing "reverse negative"
    (is (= '(-10 -9 -8 -7) (sorting/quick-sort [-7 -8 -9 -10])))))

(deftest evaluate_test_44
  (testing "longer list"
    (is (= (range 1 11) (sorting/quick-sort [10 9 8 7 6 5 4 3 2 1])))))

(deftest evaluate_test_45
  (testing "mix positive and negative"
    (is (= '(-3 -2 -1 0 1 2 3) (sorting/quick-sort [0 -1 1 -2 2 -3 3])))))