def maximum(elements) {
    return new Tuple(elements.max(), elements.indexed().findAll { i, v -> v == elements.max()}.collect { i, v -> i })
}

(maxVal, indList) = maximum( [5, 3, 5, 5, 1, 5] )
println "Maximum: $maxVal"
println "Indexes: $indList"

(maxVal, indList) = maximum(['a', 'c', 'c', 'c', 'b'])
println "Maximum: $maxVal"
println "Indexes: $indList"