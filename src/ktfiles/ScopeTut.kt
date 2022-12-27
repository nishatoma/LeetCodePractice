package ktfiles

var b = 8
fun main() {
    myFun(6)
    b = 0
}

class ScopeTut {

}

// this is a param
fun myFun(a: Int) {
    // a is a variable
    b = a
    println("$b")
}