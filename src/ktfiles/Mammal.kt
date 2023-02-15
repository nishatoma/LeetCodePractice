package ktfiles

abstract class Mammal(
    private val name: String, private val origin: String,
    private val weight: Double
) {

    abstract val maxSpeed: Double

    abstract fun run()
    abstract fun breathe()

    override fun toString(): String {
        return "Name: $name, origin: $origin, weight: $weight"
    }
}

class Human(
    name: String,
    origin: String,
    weight: Double,
    override val maxSpeed: Double
) : Mammal(name, origin, weight) {

    override fun run() {
        println("Human ran")
    }

    override fun breathe() {
        println("Human breathed")
    }

}