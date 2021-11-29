
def list = (1..40)

eachTuple(list) { e1, e2, e3, e4 ->
    println "$e1 $e2 $e3 $e4"
}

def s = 'asia ma kota i psa'

def out = new StringBuffer()
eachTuple(s) { a,b ->
    out << b << a
}
println out


def eachTuple(list, closure) {
    def n = closure.maximumNumberOfParameters
    if (list.size() % n != 0)
        throw new Exception("Closure has invalid amount of arguments")
    
    list.toList().collate(n).each(closure)
}