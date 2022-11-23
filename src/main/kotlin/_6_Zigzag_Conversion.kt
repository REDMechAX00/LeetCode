fun main() {
    val s = "PAYPALISHIRING"
    val numRows = 3
    val result = convert(s, numRows)

    println(result)
}

@Suppress("SameParameterValue")
private fun convert(s: String, numRows: Int): String {

    var row = 0
    val map: MutableMap<Int, String> = mutableMapOf()

    for (i in s.indices) {
        var step = 0
        if (numRows != 1) {
            step = i / (numRows - 1) % 2 * -2 + 1
        }

        map[row] = map.getOrDefault(row, "") + s[i].toString()
        row += step
    }

    var result = ""

    map.forEach { (_, u) ->
        result += u
    }

    return result
}
