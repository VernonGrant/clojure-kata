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
;; - Instead of sorting the arguments, I could have used the min and max.
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

;; Find the odd int
;; -----------------------------------------------------------------------------
;;
;; Description:
;;
;; Given an array of integers, find the one that appears an odd number of times.
;; There will always be only one integer that appears an odd number of times.
;;
;; [7] should return 7, because it occurs 1 time (which is odd).
;; [0] should return 0, because it occurs 1 time (which is odd).
;; [1,1,2] should return 2, because it occurs 1 time (which is odd).
;; [0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
;; [1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which is odd).
;;
;; My Solution:
;;
;; - Group the provided vector numbers by their types as a map.
;; - Map the inputs into a new vector pair of number, occurrence count.
;; - Use list comprehension to only get the odd pair.
;;
;; Notes:
;;
;; Wasn't sure how to solve this the Clojure way, but did what I knew at this
;; time. Here's some other cleaver solutions I found online.
;;
;; (defn find-odd [xs] (reduce bit-xor xs))
;; (defn find-odd [v] (ffirst (filter #(odd? (second %)) (frequencies v))))

(defn find-odd [xs]
  (let [nums (group-by identity xs)
        occurs (map (fn [m] [(key m) (count (val m))]) nums)
        odd-pair (for [x occurs :when (odd? (get x 1))] x)
        odd-pair-v (into [] (flatten odd-pair))]
    (get odd-pair-v 0)))

(find-odd [1,2,2,3,3,3,4,3,3,3,2,2,1])