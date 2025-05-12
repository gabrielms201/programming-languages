(ns protein-translation)

(def translate
  {"AUG" "Methionine"
   "UUU" "Phenylalanine"
   "UUC" "Phenylalanine"
   "UUA" "Leucine"
   "UUG" "Leucine"
   "UCU" "Serine"
   "UCC" "Serine"
   "UCA" "Serine"
   "UCG" "Serine"
   "UAU" "Tyrosine"
   "UAC" "Tyrosine"
   "UGU" "Cysteine"
   "UGC" "Cysteine"
   "UGG" "Tryptophan"
   "UAA" "STOP"
   "UAG" "STOP"
   "UGA" "STOP"})

(def invalid-codon
  (IllegalArgumentException. "Invalid codon"))

(defn invalid-protein? [protein]
  (seq (filter nil? protein)))

(defn translate-rna
  " Translates an RNA string into amino acids. "
  [rna]
  (let [protein (->> rna
      (partition 3 3 ">")
      (map (partial apply str))
      (map #(get translate %))
      (take-while (partial not= "STOP")))]
    (when (invalid-protein? protein) (throw invalid-codon))
    protein))

