fun main() {
    val s = "abcabcbbbb"
    println(lengthOfLongestSubstring(s).toString())
}

@Suppress("SameParameterValue")
private fun lengthOfLongestSubstring(s: String): Int {

    var result = 0

    if (s.isNotEmpty()) {
        var start = 0
        for (end in s.indices) {
            var sub = s.substring(start, end + 1)
            val charEnd = sub.substring(sub.length - 1)

            if (sub.substring(0, sub.length - 1).indexOf(charEnd) != -1) {
                start += sub.substring(0, sub.length - 1).indexOf(charEnd) + 1
                sub = s.substring(start, end + 1)
            }

            val subLength = sub.length
            result = result.coerceAtLeast(subLength)
        }
    }

    return result
}