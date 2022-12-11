fun main() {
    val nums = intArrayOf(1, 0, 10, 15, 2, 4, 2, 10)
    val value = 2
    println(removeElement(nums, value).toString())
}

@Suppress("SameParameterValue", "unused")
private fun removeElement(nums: IntArray, `val`: Int): Int {
    var vacancy = 0
    nums.forEach {
        if (it != `val`) nums[vacancy++] = it
    }
    return vacancy
}