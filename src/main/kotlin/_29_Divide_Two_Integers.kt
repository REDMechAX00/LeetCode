fun main() {
    val a = -2147483648
    val b = -2147483648
    println(divide(a, b).toString())
}

@Suppress("SameParameterValue", "unused")
private fun divide(dividend: Int, divisor: Int): Int {
    var variable = dividend

    val positiveA = variable >= 0
    val positiveB = divisor >= 0

    var count = -1

    if (dividend == divisor) return 1
    else if(positiveA!=positiveB && dividend == -divisor) return -1

    if (divisor == 1 || divisor == -1) return if (positiveB) dividend else {
        if (dividend == Int.MIN_VALUE) Int.MAX_VALUE
        else -dividend
    }

    while ((variable >= 0 == positiveA) || variable == 0) {
        if ((positiveA && positiveB) || (!positiveA && !positiveB)) variable -= divisor
        else variable += divisor
        if (count < Int.MAX_VALUE) count++
    }

    return if (positiveA != positiveB) -count
    else count
}