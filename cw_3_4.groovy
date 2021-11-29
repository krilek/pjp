import groovy.json.JsonSlurper

// a)
def inputText = "kjsdhsfd 0.432, ksdjhsdjf 3.14,,, kjsdkhfjskdl -6666.1234"
def realNumberRegex = /\-?[0-9]+\.[0-9]+|\-?[0-9]+/
matches = inputText =~ realNumberRegex
matches.each {
    print it + " "
}
println()
// b)

def euro = (new JsonSlurper()).parse(new URL('http://api.nbp.pl/api/exchangerates/rates/A/EUR?format=json'))["rates"][0]["mid"]
def plnToEuro = 1/euro

inputText = "TEstt 5.32 PLN testttt 111.99 PLN kldjfkj 20 EUR kjsjkshdf 4.132 EUR 111.99 PLN"
def plnPriceRegex = /($realNumberRegex)\ PLN/

def updatedPricesText = inputText.replaceAll(plnPriceRegex, {
    def price = (it[0] =~ realNumberRegex)[0] as BigDecimal
    return String.format("%.2f", price * plnToEuro) + " EUR"
})
println inputText
println updatedPricesText
