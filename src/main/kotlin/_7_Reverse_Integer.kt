import kotlin.math.abs
import kotlin.math.pow

fun main() {
    val x = -15342
    val result = reverse(x)

    println("$result")
}

fun reverse(x: Int): Int {
    if (x >= (-2.0).pow(31) && x <= (2.0).pow(31) - 1) {
        var input = abs(x)
        var reverse = 0L

        while (input > 0) {
            val digit = input % 10
            reverse = reverse * 10 + digit
            input /= 10

            if (reverse > (2.0).pow(31) - 1) {
                return 0
            }
        }

        if (x < 0) {
            reverse *= -1
        }

        return reverse.toInt()

    } else {
        return 0
    }
}