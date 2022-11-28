fun main() {
    val input: IntArray = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    println("${maxArea(input)}")
}

@Suppress("SameParameterValue", "unused")
private fun maxArea(height: IntArray): Int {
    var l = 0
    var r = height.size - 1
    var area = 0

    while (r > l) {
        val w = r - l
        val lH = height[l]
        val rH = height[r]
        val minH = lH.coerceAtMost(rH)
        area = area.coerceAtLeast(w * minH)

        if (lH < rH) {
            l++
        } else if (lH > rH) {
            r--
        } else {
            l++
            r--
        }
    }

    return area
}