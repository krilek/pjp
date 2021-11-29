import javax.swing.JOptionPane

print getInts()

def getInts() {
    def numbers = []
    def err = false
    def input = ""
    while (input != null) {
        def promptMessage = "Podaj liczbę"
        if (err) {
            err = false
            promptMessage = "Błąd. $promptMessage"
        }

        input = JOptionPane.showInputDialog(null, promptMessage, "")
        if (input == null){
            err = true
            continue
        }
        if (input.isBigInteger())
            numbers << Integer.parseInt(input)
        else
            err = true
    }

    return numbers
}