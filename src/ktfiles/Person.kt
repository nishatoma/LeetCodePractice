package ktfiles

fun main() {
    var p = Person("first", "last", 31)
    p.hobby = "Skateboard"
    p.stateHobby()
    p.age = 32

    var p2 = Person()

    MobilePhone("Samsung", "Galaxy s20 Ultra", "Android")
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

class MobilePhone(val brand: String, val model: String, val osName: String) {

//
//    init {
//        println("Our lastest phone from $brand is the all new $model running on $osName")
//    }
}