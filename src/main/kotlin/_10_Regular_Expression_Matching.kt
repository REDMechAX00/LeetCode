const val CHAR_POINT = '.'
const val CHAR_START = '*'

fun main() {
    val s = "aaa"
    val p = "ab*a*c*a"
    val output = isMatch(s, p)
    println("$output")
}

@Suppress("SameParameterValue", "unused")
private fun isMatch(s: String, p: String): Boolean {
    return isMatchRec(s, p)
}

@Suppress("SameParameterValue", "unused")
private fun isMatchRec(s: String, p: String): Boolean {
    if (p.isEmpty() && s.isEmpty()) {
        return true
    } else if (p.isNotEmpty()) {
        return if (p.length > 1 && p[1] == CHAR_START) {
            if (s.isNotEmpty() && (s[0] == p[0] || p[0] == CHAR_POINT)) {
                isMatchRec(s.substring(1), p) || isMatchRec(s, p.substring(2))
            } else {
                isMatchRec(s, p.substring(2))
            }
        } else if (s.isNotEmpty() && (p[0] == CHAR_POINT || s[0] == p[0])) {
            isMatchRec(s.substring(1, s.length), p.substring(1, p.length))
        } else {
            false
        }
    }
    return false
}