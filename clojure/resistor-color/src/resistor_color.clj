(ns resistor-color)

 (def colors-map
   (array-map
    "black" 0
    "brown" 1
    "red" 2
    "orange" 3
    "yellow" 4
    "green" 5
    "blue" 6
    "violet" 7
    "grey" 8
    "white" 9))
 
 (def colors (keys colors-map))

 (defn color-code
   "Returns the numerical value associated with the given color"
   [color] 
   (colors-map color))
