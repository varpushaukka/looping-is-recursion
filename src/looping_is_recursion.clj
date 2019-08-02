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
         n (first a-seq)
         list a-seq]
    (cond
      (empty? list) nil
      (pred n) acc
      :else (recur (inc acc) (second list) (rest list))))
    )
  

(defn avg [a-seq]
  (loop [acc 0 l a-seq]
    (if (empty? l) 
      (/ acc (count a-seq))
      (recur (+ acc (first l)) (rest l))
  )))

 
(defn parity [a-seq]
  (loop [a-set (set a-seq)
         result []
         n (first a-set)]
    (cond
      (empty? a-set) result
      (odd? (count (filter #(= n %) a-seq))) (recur (rest a-set) (conj result n) (second a-set))
      :else (recur (rest a-set) result (second a-set))))
  )

(defn fast-fibo [n]
  (loop [i 1
         i1 0
         m n]
    (if (zero? m)
      i1
      (recur (+ i i1) i (dec m)))))

(defn cut-at-repetition [a-seq]
  (loop [a-set (set a-seq)
         n (first a-set)
         i 0]
    (if
      (empty? a-set) (take i a-seq)
      (recur (rest a-set) (second a-set) (inc i)))))



