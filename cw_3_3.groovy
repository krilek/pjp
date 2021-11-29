import java.text.ParseException
import java.text.SimpleDateFormat

def input = "skdhfkjsdhjk 2017-07-29 jlksdjfkls ljksd1999-35-01kjfdshkfsk1991-17-33 aslkhdkjahskd kjahsdkjahksd 3000-01-01"

def matches = input =~ /[0-9]{4}-[0-9]{2}-[0-9]{2}/
println matches.findAll({
    def valid = true

    try {
        def dateFormat = new SimpleDateFormat("yyyy-MM-dd")
        dateFormat.setLenient(false)
        dateFormat.parse(it)
    } catch(ParseException e) {
        valid = false
    }

    return valid
})
