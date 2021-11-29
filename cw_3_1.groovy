def list1 = [ 'a', 'b', 'c']
def list2 = [ 1, 8, 23 ]

def printer = {
    print(it)
    print(" ")
}

print("list1: ")
list1.each(printer)
println()
print("list2: ")
list2.each(printer)
println()




def l1Doubled = []
list1.each {
    l1Doubled.push(it + it)
}
println(l1Doubled)

def l2doubled = []
list2.each {
    l2doubled.push(it + it)
}
println(l2doubled)