// 5.    Napisy wprowadzane w kolejnych dialogach mają formę:  pozycja = koszt.
//         Zsumuj wszystkie koszty dla tych samych pozycji (np. mleko, chleb). (5)
def input;
def produkty = [];
while (input != "exit")
{
    input = System.console().readLine "Podaj produkty w formacie produkt = cena"
    if (input != "exit") {
        produkty << input
    }
}
if (!produkty.isEmpty()) {
    print produkty.collect { it -> it.split('=').collect(x -> x.trim()) }
                  .collect { it -> [it[0], it[1].toInteger()]}
                  .groupBy { p -> p[0]}
                  .collect { k, v -> [k, v.collect(p -> p[1]).sum()]}
}
 