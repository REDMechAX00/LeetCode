fun main() {
    val nums = intArrayOf(1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 6, 7, 8, 9, 9, 9, 9)
    println(removeDuplicates(nums).toString())
}

@Suppress("SameParameterValue", "unused")
private fun removeDuplicates(nums: IntArray): Int {
    var counter = 0
    for (i in 1 until nums.size) {
        if (nums[i] != nums[counter] && counter < nums.size - 1) {
            counter++
            nums[counter] = nums[i]
        }
    }
    return counter + 1
}

@Suppress("SameParameterValue", "unused")
private fun removeDuplicatesSecond(nums: IntArray): Int {
    var countDoubles = 0

    for (i in 1 until nums.size) {
        if (nums[i - 1] == nums[i]) {
            nums[i - 1] = Integer.MAX_VALUE
            countDoubles++
        }
    }

    nums.sort()

    return nums.size - countDoubles
}