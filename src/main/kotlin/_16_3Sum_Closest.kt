import kotlin.math.abs

fun main() {
    val nums = intArrayOf(-1, 2, 1, -4)
    val target = 1
    println(threeSumClosest(nums, target).toString())
}

@Suppress("SameParameterValue", "unused")
private fun threeSumClosest(nums: IntArray, target: Int): Int {
    var result: Int? = null
    if (nums.size < 3) {
        nums.forEach { result = (result ?: 0) + it }
        return result ?: 0
    }

    nums.sort()

    for (f in 0 until nums.size - 2) {
        val first = nums[f]
        var min = f + 1
        var max = nums.size - 1
        while (min < max) {
            val sum = first + nums[min] + nums[max]
            val delta = abs(target - sum)

            result = if (result != null) {
                if (delta < abs(target - result!!)) {
                    sum
                } else {
                    result
                }
            } else sum

            when {
                sum < target -> min++
                sum > target -> max--
                else -> return result ?: 0
            }
        }
    }

    return result ?: 0
}