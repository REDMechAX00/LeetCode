fun main() {
    val input = ")"
    println(isValid(input).toString())
}

@Suppress("SameParameterValue", "unused")
fun isValid(s: String): Boolean {
    val validChars = listOf('(', ')', '[', ']', '{', '}')
    var result = s

    var i = 0
    while (i in result.indices && result.length > 1) {
        if (result[i] == '(' || result[i] == '{' || result[i] == '[') {
            if (i < result.length - 1 && validChars.indexOf(result[i]) == validChars.indexOf(result[i + 1]) - 1) {
                result = result.substring(0, i) + result.substring(i + 2)
                println(result)
                if (i > 0) i--
            } else {
                i++
            }
        } else {
            i++
        }
    }

    return result.isEmpty()
}