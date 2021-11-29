// Napisać pogram przekształcający liczby na ich słowne odpowiedniki.
//        Np. po wprowadzeniu liczby 147 winniśmy uzyskać jeden - cztery - siedem. (5)
package cw1
def words = "zero jeden dwa trzy cztery pięć sześć siedem osiem dziewięć".tokenize()
def input = System.console().readLine "Podaj liczbę"
println input.collect { words[it.toInteger()] }.join(" - ")
