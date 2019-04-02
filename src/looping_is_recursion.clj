(ns looping-is-recursion)

(defn power [base exp]
  (if (zero? exp)
    1
    (* base (power base (dec exp)))))

(defn last-element [a-seq]
 (if (empty? a-seq)
   nil
   (if (== 1 (count a-seq))
     (first a-seq)
     (last-element (rest a-seq)))))

(defn seq= [seq1 seq2]
  (if (and (empty? seq1) (empty? seq2))
    true
    (if (or (empty? seq1) (empty? seq2))
      false
      (if (== (first seq1) (first seq2))
       (seq= (rest seq1) (rest seq2))
       false
      ))))

(defn find-first-index [pred a-seq]
    (loop [acc 0 
           n a-seq]
      (if (empty? a-seq)
        nil
        (if (= pred (first n))
          acc
          (recur (inc acc) (rest a-seq))))))

(defn avg [a-seq]
  -1)

(defn parity [a-seq]
  ":(")

(defn fast-fibo [n]
  ":(")

(defn cut-at-repetition [a-seq]
  [":("])

