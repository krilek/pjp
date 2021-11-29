def pmap = [ Groovy: [ 'Asia', 'Jan' ],
             Grails: [ 'Asia', 'Jan', 'Stefan', 'Mirek' ],
             Java: [ 'Asia', 'Stefan', 'Mirek' ],
             JEE: [ 'Slawek', 'Stefan', 'Janusz' ]
]

// a)
println pmap.collect { it.key + ": " + it.value.size() }

// b)
println pmap.findAll { it.value.size() > 2 }

// c)
def findProjects =  { x ->
    pmap.findAll({ it.value.contains(x) }).collect { el -> el.key }
}

println pmap.values().flatten().unique().collectEntries { [it, findProjects(it)] }