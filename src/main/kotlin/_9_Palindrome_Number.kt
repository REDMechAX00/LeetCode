fun main() {
    val input = 1000110001
    val output = isPalindromeFirst(input)

    println("$output")
}

@Suppress("SameParameterValue", "unused")
private fun isPalindromeFirst(x: Int): Boolean {
    val s = x.toString()

    //odd
    if (s.length % 2 == 0) {
        for (i in 0 until s.length / 2) {
            val left = s.substring(s.length / 2 - 1 - i, s.length / 2 - i)
            val right = s.substring(s.length / 2 + i, s.length / 2 + 1 + i)

            if (left != right) {
                return false
            }
        }
    }

    //even
    if (s.length % 2 == 1) {
        for (i in 0..s.length / 2) {
            val left = s.substring(s.length / 2 - i, s.length / 2 + 1 - i)
            val right = s.substring(s.length / 2 + i, s.length / 2 + 1 + i)

            if (left != right) {
                return false
            }
        }
    }

    return true
}

@Suppress("SameParameterValue", "unused")
private fun isPalindromeSecond(x: Int): Boolean {
    val s = x.toString()
    var result = ""

    for (i in s.length - 1 downTo 0) {
        result += s.substring(i, i + 1)
    }

    return s == result
}

@Suppress("SameParameterValue", "unused")
private fun isPalindromeThird(x: Int): Boolean {
    return x.toString() == x.toString().reversed()
}