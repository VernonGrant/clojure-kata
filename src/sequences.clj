(ns sequences)

;; Splitting a vector into two parts.
;; -----------------------------------------------------------------------------
;;
;; Description:
;;
;; Given an equally lengthened vector, split it into its two equal parts and
;; return a new vector containing these parts.
;;
;; My Solution:
;;
;; - Calculate the vectors half.
;; - Use subvec to take each half.

(def numbers (into [] (range 13)))

;; First solution.
;;
;; Notes: I was thinking of using the partition function, but that will return a
;; sequence. I'm still trying to comprehend when and how to use sequences with
;; collections interchangeably.
(let [half (int (/ (count numbers) 2))
      part-a (subvec numbers 0 half)
      part-b (subvec numbers half (count numbers))]
  [part-a part-b])