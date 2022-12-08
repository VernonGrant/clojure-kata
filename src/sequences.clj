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
;;

(let [numbers (into [] (range 13))
      half (int (/ (count numbers) 2))
      part-a (subvec numbers 0 half)
      part-b (subvec numbers half (count numbers))]
  [part-a part-b])

;; Sum of Numbers
;; -----------------------------------------------------------------------------
;;
;; Description:
;;
;; Given two integers a and b, which can be positive or negative, find the sum
;; of all the integers between and including them and return it. If the two
;; numbers are equal return a or b.
;;
;; My Solution:
;;
;; - Check if a and b is equal, if so just return a.
;; - Get a sequence of numbers in respects to a and b using the range function.
;; - Sum up all the numbers using reduce.
;;
;; In Hindsight:
;;
;; - Instead of sorting the arguments, I could have used the min and max functions.
;; - I also could have made two ranges and just added up their individual sums.

(defn get-sum [a b]
  (if (= a b)
    a
    (let [[start end] (sort [a b])
          numbers-range (range start (inc end))]
      (reduce + numbers-range))))

(get-sum 5 1)

;; Highest and Lowest
;; -----------------------------------------------------------------------------
;;
;; Description:
;;
;; In this little assignment you are given a string of space separated numbers,
;; and have to return the highest and lowest number as a string.
;;
;; My Solution:
;; - Split string into individual pieces.
;; - Use map to convert each string to an int.
;; - Return the min and max as a string.
;;
;; Notes:
;;
;; Could not make use of parse-long, not available in some version of Clojure.

(defn high-and-low [s]
  (let [numbers (->> (clojure.string/split s #"\s")
                     (map #(Integer/parseInt %)))
        min (apply min numbers)
        max (apply max numbers)]
    (str max " " min)))

(high-and-low "8 3 -5 42 -1 0 0 -9 4 7 4 -4")