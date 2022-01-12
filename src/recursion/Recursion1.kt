package recursion

import java.lang.Math.pow
import java.math.BigInteger
import kotlin.math.exp
import kotlin.math.floor
import kotlin.math.log
import kotlin.math.pow


fun main() {

    println(factorial(30))
    println(sumOneToN(100))
    println(sumDigits(1342))
    println(productOfDigits(1342))
    // print 2431
    println(reverseNum(1342))
    println(reverseNum(5060))
    println(checkPalindrome(1303031)) // Returns true
    println(checkPalindrome(1332)) // Returns false
    println(checkPalindrome(9009)) // Returns true
    println(countZeros(2002000200))
}



fun factorial(n: Long): BigInteger {
    if (n == 1L) {
        return BigInteger.ONE
    }

    return BigInteger.valueOf(n) * factorial(n - 1)
}

fun sumOneToN(n: Int): Int {
    if (n == 0) {
        return n
    }
    return n + sumOneToN(n - 1)
}

fun sumDigits(n: Int): Int {
    if (n == 0){
        return 0
    }

    val rem = n % 10
    return rem + sumDigits(n / 10)
}

fun productOfDigits(n: Int): Int {
    if (n == 1){
        return 1
    }

    val rem = n % 10

    return rem * productOfDigits(n / 10)
}


fun reverseNum(n: Int): Int {

    val len = floor(log(n / 1.0, 10.0)) + 1
    val mult = 10.0.pow(len - 1).toInt()

    if (n == 0){
        return 0
    }

    val rem = n % 10

    return (rem * mult) + reverseNum(n / 10)
}

fun checkPalindrome(n: Int): Boolean {
    return n == reverseNum(n)
}

fun countZeros(n: Int): Int {
    var count = 0;
    if (n == 0){
        return 0
    }

    val rem = n % 10
    if (rem == 0){
        count++
    }
    return count + countZeros(n / 10)
}