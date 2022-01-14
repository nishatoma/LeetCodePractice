package recursion

import java.lang.StringBuilder

fun main() {

    var str = "About that because we got busted"

    str = removeChar(str, 'b', StringBuilder(), 0)
    println(str)
    str = "About that because we got busted"
    str = removeChar(str, 'b', 0)
    println(str)
    str = "About that because we got busted"
    str = removeSubstringFromString(str, "apple", StringBuilder(), 0)
    println(str)
    str = "AbAppleout tApplehat, waPPlee gAppleot busted"
    str = removeSubstringFromString(str, "apple", StringBuilder(), 0)
    println(str)
    str = "AbAppleout tApplehat, waPPlee gAppleot busted"
    str = removeSubstringFromString(str, "apple", 0)
    println(str)
}

fun removeChar(str: String, char: Char, builder: StringBuilder, i: Int): String {
    if (i >= str.length){
        return ""
    }

    if (str[i] != char){
        builder.append(str[i])
    }

    removeChar(str, char, builder, i + 1)
    return builder.toString()
}

fun removeChar(str: String, char: Char, i: Int): String {
    if (i >= str.length) {
        return ""
    }

    var builder = StringBuilder()

    if (str[i] != char) {
        builder.append(str[i])
    }

    return builder.append(removeChar(str, char, i + 1)).toString()
}

fun removeSubstringFromString(str: String, str2: String, builder: StringBuilder, i: Int): String {
    if (i >= str.length){
        return ""
    }

    if (!str.startsWith(str2, i, true)){
        builder.append(str[i])
        removeSubstringFromString(str, str2, builder, i + 1)
    } else {
        removeSubstringFromString(str, str2, builder, i + str2.length)
    }

    return builder.toString();
}

fun removeSubstringFromString(str: String, str2: String, i: Int): String {
    if (i >= str.length){
        return ""
    }

    val builder = StringBuilder()

    val result: String = if (!str.startsWith(str2, i, true)){
        builder.append(str[i])
        builder.append((removeSubstringFromString(str, str2, i + 1))).toString()
    } else {
        removeSubstringFromString(str, str2, i + str2.length)
    }

    return result
}

