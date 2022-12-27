package ktfiles

fun main() {
    var car = Car()
    println(car.myBrand)
    car.maxSpeed = 270
    println(car.maxSpeed)
}

class Car {

    lateinit var owner: String

    val myBrand: String = "BMW"
        // custom getter
    get() {
        return field.lowercase()
    }

    var maxSpeed: Int = 250
        set(value) {
            field = if (value > 0) value else throw IllegalArgumentException("Max speed must be greater than zero.")
        }

    var model: String = "M5"
        private set

    init {
        owner = "frank"
    }
}