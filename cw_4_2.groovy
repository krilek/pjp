import groovy.json.JsonSlurper

def euro = (new JsonSlurper()).parse(new URL('http://api.nbp.pl/api/exchangerates/rates/A/EUR?format=json'))["rates"][0]["mid"]
def plnToEuro = 1/euro

def realNumberRegex = /(\-?[0-9]+\.[0-9]+|\-?[0-9]+)/

def menuPl = new File("MenuPl.txt")

def menuEuText = menuPl.text.replaceAll(realNumberRegex, {
    def price = it[0] as BigDecimal
    return String.format("%.2f", price * plnToEuro)
})
println menuPl.text
println menuEuText

new File("MenuEur.txt").write(menuEuText)
