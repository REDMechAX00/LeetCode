fun main() {
    val s = "babbad"
    println(longestPalindrome(s))
}

@Suppress("SameParameterValue")
private fun longestPalindrome(s: String): String {
    if (s.isEmpty()) {
        return ""
    }

    var start = 0
    var end = 0

    for (i in s.indices) {
        val oddRange = findLongestPalindromeRange(s, i, i)
        val evenRange = findLongestPalindromeRange(s, i, i + 1)

        val range = oddRange.coerceAtLeast(evenRange)

        if (range > end - start) {
            start = i - (range - 1) / 2
            end = i + range / 2
        }

    }

    return s.substring(start, end + 1)
}

private fun findLongestPalindromeRange(s: String, left: Int, right: Int): Int {
    var l = left
    var r = right

    while (l >= 0 && r < s.length && s[l] == s[r]) {
        l--
        r++
    }

    return r - l - 1
}