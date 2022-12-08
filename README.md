# Clojure Kata

## Function reminders

### Comparisons

| Symbol | Description                               |
|--------|-------------------------------------------|
| =      | Returns true if x equals y, false if not. |
| not=   | Checks if x and y is not equal.           |

### Sequences

| Symbol | Description                                                |
|--------|------------------------------------------------------------|
| first  | Returns the first item in the collection.                  |
| rest   | Returns a possibly empty seq of the items after the first. |

### Collections

| Symbol | Description                                                                                                                                                                      |
|--------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| count  | Returns the number of items in the collection.                                                                                                                                   |
| conj   | Returns a new collection with the added item. (Conjoin) When used with maps the behaviour is similar to `into` as it combines the given maps. For maps you can use `assoc`.      |
| into   | Returns a new coll consisting of to-coll with all of the items of from-coll conjoined.                                                                                           |
| peek   | For a list or queue, same as first, for a vector, same as, but much more efficient than, last.                                                                                   |
| pop    | For a list or queue, returns a new list/queue without the first item, for a vector, returns a new vector without the last item. If the collection is empty, throws an exception. |
| seq    | Returns a sequence for the given collection type (ISeq). Lists are sequences by default.                                                                                         |

### Lists

| Symbol | Description                                                                                                            |
|--------|------------------------------------------------------------------------------------------------------------------------|
| list   | Creates a new list containing the items.                                                                               |
| list*  | Creates a new seq containing the items prepended to the rest, the last of which will be treated as a sequence.         |
| peek   | For a list or queue, same as first.                                                                                    |
| pop    | For a list or queue, returns a new list/queue without the first item. If the collection is empty, throws an exception. |
| nth    | Returns the value at the index. get returns nil if index out of bounds.                                                |

### Vectors

| Symbol    | Description                                                                                                                                                                                                              |
|-----------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| vector    | Creates a new Vector.                                                                                                                                                                                                    |
| vector-of | Creates a new vector of a single primitive type t.                                                                                                                                                                       |
| filterv   | Returns a vector of the items in coll for which (pred item) returns logical true.                                                                                                                                        |
| rseq      | Returns a reversed sequence in constant time.                                                                                                                                                                            |
| get       | Get a vectors item, similar to nth.                                                                                                                                                                                      |
| nth       | Returns the value at the index. get returns nil if index out of bounds.                                                                                                                                                  |
| peek      | For a vector, same as, but much more efficient than, last.                                                                                                                                                               |
| pop       | For a vector, returns a new vector without the last item. If the collection is empty, throws an exception.                                                                                                               |
| subvec    | Returns a persistent vector of the items in vector from start (inclusive) to end (exclusive).                                                                                                                            |
| assoc     | When applied to a vector, returns a new vector that contains val at index. (vectors are associative, like maps.)                                                                                                         |
| contains? | Returns true if the index is present in the given collection.                                                                                                                                                            |
| assoc-in  | Associates a value in a nested associative structure, where ks is a sequence of keys and v is the new value and returns a new nested structure.                                                                          |
| update-in | 'Updates' a value in a nested associative structure, where ks is a sequence of keys and f is a function that will take the old value and any supplied args and return the new value, and returns a new nested structure. |

### Maps

| Symbol        | Description                                                                                                                                                                                                              |
|---------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| hase-map      | Returns a new hash map with supplied mappings.                                                                                                                                                                           |
| sorted-map    | Returns a new sorted map with supplied mappings.                                                                                                                                                                         |
| sorted-map-by | Returns a new sorted map with supplied mappings, using the supplied comparator.                                                                                                                                          |
| get           | Returns the value mapped to key.                                                                                                                                                                                         |
| assoc         | When applied to a map, returns a new map of the same (hashed/sorted) type, that contains the mapping of key(s) to val(s).                                                                                                |
| dissoc        | Returns a new map of the same (hashed/sorted) type, that does not contain a mapping for key(s).                                                                                                                          |
| contains?     | Returns true if key is present in the given collection, otherwise returns false.                                                                                                                                         |
| find          | Returns the map entry for key, or nil if key not present.                                                                                                                                                                |
| select-keys   | Returns a map containing only those entries in map whose key is in keys.                                                                                                                                                 |
| keys          | Returns a sequence of the map's keys, in the same order as (seq map).                                                                                                                                                    |
| vals          | Returns a sequence of the map's values, in the same order as (seq map).                                                                                                                                                  |
| key           | Returns the key of the map entry. (Useful when a map has already been converted to a sequence of map entries.)                                                                                                           |
| val           | Returns the value in the map entry. (Useful when a map has already been converted to a sequence of map entries.)                                                                                                         |
| merge         | Returns a map that consists of the rest of the maps conj-ed onto the first.  If a key occurs in more than one map, the mapping from the latter (left-to-right) will be the mapping in the result.                        |
| merge-with    | Returns a map that consists of the rest of the maps conj-ed onto the first. Will be combined with the mapping in the result by calling (f val-in-result val-in-latter).                                                  |
| assoc-in      | Associates a value in a nested associative structure, where ks is a sequence of keys and v is the new value and returns a new nested structure.                                                                          |
| update-in     | 'Updates' a value in a nested associative structure, where ks is a sequence of keys and f is a function that will take the old value and any supplied args and return the new value, and returns a new nested structure. |

### Symbols and Keywords

| Symbol    | Description                                                                        |
|-----------|------------------------------------------------------------------------------------|
| name      | Returns the name String of a string, symbol or keyword.                            |
| namespace | Returns the namespace String of a symbol or keyword, or nil if not present.        |
| quote     | Yields the unevaluated form. Use the ali as `` `symbol ``.                         |
| gensym    | Returns a new symbol with a unique name. Mainly used for code generation purposes. |

## Functional programming terms

- Predicate: Function that returns true or false.
- Comparator: A comparator is a function that takes two arguments x and y and
  returns a value indicating the relative order in which x and y should be
  sorted. It can be a 3-way comparator returning an integer, or a 2-way
  comparator returning a boolean.
