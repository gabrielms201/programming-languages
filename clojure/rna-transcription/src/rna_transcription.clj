(ns rna-transcription)

(def dna-to-rna
  { \G \C
    \C \G
    \T \A
    \A \U})

(defn to-rna
  "Returns the RNA complement of the given DNA string sequence."
  [dna] 
  (let [rna (map #(dna-to-rna %1) dna) ]
    (when (some nil? rna)
      (throw (ex-info "Invalid nucleotide in DNA Sequence" {:dna dna}) ))
    (apply str rna)))
  
  
