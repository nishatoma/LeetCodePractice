package ktfiles

data class User(val id: Long, val name: String) {
    override fun toString(): String {
        return "[Id = $id, Name = $name]\n"
    }
}

fun main() {
    val user = User(1, "Denis")

    val user2 = user.copy(id = 2)

    val name = user.name
    println(user)
    println(user2)
}
