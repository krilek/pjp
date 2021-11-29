
def projectsSourceFile = new File("Projekty.txt")

def pmap = projectsSourceFile.collect { line -> line.split("\t") }.collectEntries { [it[0], it.drop(1)]}

File file = new File("ProjektyDuze.txt")
file.write pmap.findAll { it.value.size() > 3 }.toString()

File file2 = new File("Programisci.txt")
def findProjects =  { x ->
    pmap.findAll({ it.value.contains(x) }).collect { el -> el.key }
}

pmap.values().flatten().unique().collectEntries { [it, findProjects(it)] }.collect { it.key+" "+it.value.join("\t")}.each {
    file2 << it + "\n"
}
// .each {
//     file.write it+"\n"
// }
// def programmerProjects = [:]
// projectsSourceFile.each {
//     if (it.size() == 0)
//         return

//     def rawValues = it.split("\t")

//     def projectName = rawValues[0]
//     def programmers = rawValues.drop(1)

//     if (programmers.size() > 3) {
//         def bigProjectsFile = new File("ProjektyDuze.txt")
//         bigProjectsFile.text = ""
//         programmers.each { bigProjectsFile.text += it + "\n" }
//     }

//     programmers.each {
//         if (!programmerProjects.containsKey(it))
//             programmerProjects.put(it, [projectName])
//         else {
//             def projects = programmerProjects.get(it)
//             projects.push(projectName)
//         }
//     }
// }

// def prorammerProjectsFile = new File("Programisci.txt")
// prorammerProjectsFile.text = ""
// programmerProjects.each {
//     def projectsAsText = ""
//     it.value.each { projectsAsText += "\t" + it }
//     prorammerProjectsFile.text += it.key + projectsAsText + "\n"
// }