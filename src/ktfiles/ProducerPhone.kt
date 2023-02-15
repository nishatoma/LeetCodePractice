package ktfiles

class ProducerPhone<out T: Phone>(val phone: T) {

    fun get(): T {
        return phone
    }
}