println getData(Integer) { it > 0 }
println getData() { it.size() > 3 }
println getData()
println getData(BigDecimal)

def getData(arg1 = null, arg2 = null) {
    def values = []
    def err = false
    while (true) {
        def promptMessage = "Podaj wartość"
        if (err) {
            err = false
            promptMessage = "Błąd. $promptMessage"
        }

        println promptMessage
        def input = System.in.newReader().readLine()
        if (input == null || input == "")
            break
        
        if (arg1 instanceof Class) {
            try {
                input = input.asType(arg1)
                if (arg2 instanceof Closure && !arg2(input)) {
                    err = true
                    continue
                }
            }
            catch (ex) {
                err = true
                continue
            }
        }
        
        if (arg1 instanceof Closure && !arg1(input)) {
            err = true
            continue
        }
        
        values.push input
    }

    return values
}
