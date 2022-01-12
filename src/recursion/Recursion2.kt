package recursion


fun main() {

    var arr = arrayOf(1, 2, 3, 3, 4, 5, 7)
    println(isArraySorted(arr, 0))
    println(returnTargetElement(arr, 3, 0))
    println(returnTargetElement(arr, 8, 0))
    println(returnMultipleIndicesOfTarget(arr, 3, 0, ArrayList()))
    println(returnMultipleIndicesOfTarget(arr, 8, 0, ArrayList()))
    println(returnMultipleIndicesOfTarget(arr, 1, 0, ArrayList()))
    println(returnMultipleIndicesOfTarget(arr, 20, 0, ArrayList()))
    println(returnMultipleIndicesOfTargetWithoutListParameter(arr, 3, 0))
    println(returnMultipleIndicesOfTargetWithoutListParameter(arr, 8, 0))
    arr = arrayOf(4, 5, 7, 1, 2, 3, 3)
    println(binarySearchRotatedArray(arr, 7, 0, arr.size - 1))
    printTriangle(4)
    printTriangleMethod2(4, 0)
}

fun isArraySorted(arr: Array<Int>, n: Int): Boolean {
    if (n == arr.size - 1) {
        return arr[arr.size - 1] >= arr[arr.size - 2]
    }

    val result = arr[n] <= arr[n + 1]

    return result && isArraySorted(arr, n + 1)
}

fun returnTargetElement(arr: Array<Int>, target: Int, i: Int): Int {
    if (i == arr.size) {
        return -1
    }

    return if (arr[i] == target) {
        i
    } else {
        returnTargetElement(arr, target, i + 1)
    }
}

fun returnMultipleIndicesOfTarget(arr: Array<Int>, target: Int, i: Int, res: MutableList<Int>): List<Int> {
    if (i == arr.size) {
        return if (res.isEmpty()) listOf(-1) else res
    }

    if (arr[i] == target) {
        res.add(i)
    }

    return returnMultipleIndicesOfTarget(arr, target, i + 1, res)
}

fun returnMultipleIndicesOfTargetWithoutListParameter(arr: Array<Int>, target: Int, i: Int): ArrayList<Int> {
    if (i == arr.size) {
        return arrayListOf(-1)
    }

    val res = ArrayList<Int>()

    if (arr[i] == target) {
        res.add(i)
        val nextList = returnMultipleIndicesOfTargetWithoutListParameter(arr, target, i + 1)
        res.add(nextList[0])
        return res
    }

    return returnMultipleIndicesOfTargetWithoutListParameter(arr, target, i + 1)
}

fun binarySearchRotatedArray(arr: Array<Int>, target: Int, lo: Int, hi: Int): Int {
    if (lo > hi) {
        return -1
    }

    val mid = lo + (hi - lo)

    if (arr[mid] == target) {
        return mid
    }

    if (arr[lo] <= arr[mid]) {
        return if (arr[lo] <= target && target < arr[mid]) {
            binarySearchRotatedArray(arr, target, lo, mid - 1)
        } else {
            binarySearchRotatedArray(arr, target, mid + 1, hi)
        }
    }

    return if (arr[mid] <= target && target <= arr[hi]) {
        binarySearchRotatedArray(arr, target, mid + 1, hi)
    } else {
        binarySearchRotatedArray(arr, target, lo, mid - 1)
    }
}

fun printTriangle(n: Int){
    if (n == 1){
        println("*")
        return
    }

    for (i in 1..n){
        print("*")
    }
    println()
    printTriangle(n - 1)
}

fun printTriangleMethod2(r: Int, c: Int){
    if (r == 0){
        return
    }

    if (c < r){
        print("*")
        printTriangleMethod2(r, c + 1)
    } else {
        println()
        printTriangleMethod2(r - 1, 0)
    }
}