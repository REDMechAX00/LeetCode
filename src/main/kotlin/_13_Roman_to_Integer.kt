fun main() {
    val input = "MCMXCIV"
    println(romanToInt(input))
}

@Suppress("SameParameterValue", "unused")
private fun romanToInt(s: String): Int {

    val rI = mapOf(
        9 to "IX",
        8 to "VIII",
        7 to "VII",
        6 to "VI",
        4 to "IV",
        5 to "V",
        3 to "III",
        2 to "II",
        1 to "I"
    )

    val rX = mapOf(
        90 to "XC",
        80 to "LXXX",
        70 to "LXX",
        60 to "LX",
        40 to "XL",
        50 to "L",
        30 to "XXX",
        20 to "XX",
        10 to "X"
    )

    val rC = mapOf(
        900 to "CM",
        800 to "DCCC",
        700 to "DCC",
        600 to "DC",
        400 to "CD",
        500 to "D",
        300 to "CCC",
        200 to "CC",
        100 to "C"
    )

    val rM = mapOf(3000 to "MMM", 2000 to "MM", 1000 to "M")

    var newS = s

    val numI = getNumFromRoman(newS, rI)
    newS = newS.substring(0, newS.length - (rI[numI]?.length ?: 0))
    val numX = getNumFromRoman(newS, rX)
    newS = newS.substring(0, newS.length - (rX[numX]?.length ?: 0))
    val numC = getNumFromRoman(newS, rC)
    newS = newS.substring(0, newS.length - (rC[numC]?.length ?: 0))
    val numM = getNumFromRoman(newS, rM)

    return numI + numX + numC + numM
}

@Suppress("SameParameterValue", "unused")
private fun getNumFromRoman(s: String, map: Map<Int, String>): Int {
    map.forEach { (t, u) ->
        val num = s.indexOf(u)
        if (num != -1) {
            return t
        }
    }
    return 0
}