# Elyses Destructured Enchantments

Welcome to Elyses Destructured Enchantments on Exercism's Clojure Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

Clojure's sequential destructuring syntax is a concise way to extract values from a vector and assign them to distinct variables.

In this example, each value in the `number-of-moons` vector is assigned to its corresponding planet:

```clojure
(def number-of-moons [0 2 14])

(let [[venus mars neptune] number-of-moons]
  neptune)

;=> 14
```

## Instructions

Elyse, magician-to-be, continues her training. She has a deck of cards she wants to manipulate.

To make things easier, she usually only starts with cards numbered 1 to 10, although some of the tricks may involve additional cards.

## 1. Get the first card

Elyse will summon the first card in the deck, without using its index or `first`. It's just like magic.

```clojure
(def deck [5 9 7 1 8])

(first-card deck)
;=> 5
```

## 2. Get the second card

Elyse performs sleight of hand, and summons the second card in the deck, without using its index or `second`.

```clojure
(def deck [3 2 10 6 7])

(second-card deck)
;=> 2
```

## 3. Swap the first two cards

Elyse will make the top two cards of the deck switch places.

```clojure
(def deck [10 7 3 8 5])

(swap-top-two-cards deck)
;=> [7 10 3 8 5]
```

## 4. Discard the top card

Elyse will separate the deck into two piles. The first pile will contain only the top card of the original deck, while the second pile will contain all the other cards.

```clojure
(def deck [2 5 4 9 3])

(discard-top-card deck)
;=> [2 [5 4 9 3]]
```

## 5. Insert face cards

Elyse will insert a set of face cards (i.e. jack, queen, and king) into her deck such that they become the second, third, and fourth cards respectively.

```clojure
(def deck [5 4 7 10])

(insert-face-cards deck)
;=> [5 "jack" "queen" "king" 4 7 10]
```

## Source

### Created by

- @bobbicodes