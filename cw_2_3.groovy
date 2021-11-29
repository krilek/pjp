def apply(List l, Closure c) {
    l.collect(c)
}

println apply([1, 2, 3, 4], {
    it ** 2
})

println apply([2, 3, 4, 5], {
    it.toString() + ".00"
})
