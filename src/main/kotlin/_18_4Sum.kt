fun main() {
    val nums = intArrayOf(1000000000, 1000000000, 1000000000, 1000000000)
    val target = -294967296
    println(fourSum(nums, target))
}

@Suppress("SameParameterValue", "unused")
private fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    val results = HashSet<List<Int>>()
    if (nums.size < 4) {
        return results.toList()
    }

    nums.sort()
    for (f in 0 until nums.size - 2) {

        //To skip duplicates
        if (f > 0 && nums[f] == nums[f - 1]) continue

        val first = nums[f]

        for (s in f + 1 until nums.size) {

            //To skip duplicates
            if (s > f + 1 && nums[s] == nums[s - 1]) continue

            val second = nums[s]
            val couple = target - first - second
            var min = s + 1
            var max = nums.size - 1

            while (min < max) {
                val sum = nums[min] + nums[max]

                when {
                    sum < couple -> min++
                    sum > couple -> max--
                    else -> {
                        if (first.toLong() + second.toLong() + nums[min].toLong() + nums[max].toLong() == target.toLong()) {
                            results.add(listOf(first, second, nums[min], nums[max]))
                        }
                        min++
                        max--
                    }
                }
            }
        }
    }

    return results.toMutableList()
}