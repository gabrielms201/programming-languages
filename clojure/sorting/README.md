# Introduction

Você deverá criar três principais funções:

## partition-aux
This function should, given a vector and a pivot, separate the elements less than or equal to the pivot on one side, and the elements greater than the pivot on the other side.
The return should be an array in the following format: [(smaller side) pivot (greater side)]

Example:
```
> (sorting/partition-aux [3 2 1] 2 [] []) 
    ['(1 2) 2 '(3)]
```


# partition-middle

This function will have almost the same purpose as partition-aux. The main difference is that it receives only a vector, and from it returns an array in the same format mentioned earlier, but without passing the smaller and greater side vectors as arguments. It uses the middle element as the default pivot.

Examples:
```
> (sorting/partition-middle [5 4 3 1])
    ['(1) 3 '(4 5)]
> (sorting/partition-middle [6 5 4 3 2 ])
    ['(2 3) 4 '(5 6)]
```

# quick-sort
Based on your previous knowledge, implement the [quicksort](https://www.ci.inf.usi.ch/wp-content/uploads/2020/12/quicksort.pdf) algorithm.

