package ktfiles

fun main() {
    var p = Person("first", "last", 31)
    p.hobby = "Skateboard"
    p.stateHobby()
    p.age = 32

    var p2 = Person()
}

class Person (first: String = "John", last: String = "Doe") {

    var age: Byte? = null
    var hobby: String = "Watch Netflix"
    var firstName: String? = null

    init {
        println("First Name: $first, Last Name: $last")
        this.firstName = first
    }

    // Secondary constructor
    constructor(first: String, last: String, age: Byte): this(first, last) {
        this.age = age
    }

    // Member functions - Methods
    fun stateHobby() {
        println("My hobby is $hobby")
    }
}
interface Testing {
    fun test()
}

interface Debuggable {
    fun debug()
}