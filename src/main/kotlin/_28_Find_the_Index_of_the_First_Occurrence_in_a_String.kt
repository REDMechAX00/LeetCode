fun main() {
    val h = "1"
    val n = ""
    println(strStr(h, n).toString())
}

@Suppress("SameParameterValue", "unused")
private fun strStr(haystack: String, needle: String): Int {

    if(needle.isEmpty()) return -1

    for (h in haystack.indices) {
        if (haystack[h] == needle[0]) {
            for (n in needle.indices) {
                if (h + n > haystack.length - 1) return -1
                if (haystack[h + n] != needle[n]) {
                    break
                } else if (n == needle.length - 1) {
                    return h
                }
            }
        }
    }

    return -1
}