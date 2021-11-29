import groovy.io.FileType

def list = []

def dir = new File("C:\\Users\\KarolGzik\\Documents\\PJP")
dir.eachFileRecurse (FileType.FILES) { file ->
  list << file
}

list.withIndex().each { println(it[1] + " " + it[0].toString()) }