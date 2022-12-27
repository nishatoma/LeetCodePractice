package ktfiles

fun main() {
    var p = Person("first", "last")
    var p2 = Person("first", "last", 23)

    MobilePhone("Samsung", "Galaxy s20 Ultra", "Android")
}

class Person (first: String, last: String) {

    var first: String
    var last: String
    var age: Byte = 1

    init {
        this.first = first
        this.last = last
    }

    constructor(first: String, last: String, age: Byte): this(first, last) {
        this.age = age
    }
}

class MobilePhone(val brand: String, val model: String, val osName: String) {


    init {
        println("Our lastest phone from $brand is the all new $model running on $osName")
    }
}