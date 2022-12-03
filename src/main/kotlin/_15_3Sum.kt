fun main() {
    val input = intArrayOf(2, 0, -2, -5, -5, -3, 2, -4)
    println("${threeSum(input)}")
}

@Suppress("SameParameterValue", "unused")
private fun threeSum(nums: IntArray): List<List<Int>> {

    val results = HashSet<List<Int>>()
    if (nums.size < 3) {
        return results.toList()
    }

    nums.sort()
    for (f in 0 until nums.size - 2) {
        val first = nums[f]
        var min = f + 1
        var max = nums.size - 1

        while (min < max) {
            val sum = first + nums[min] + nums[max]
            when {
                sum == 0 -> {
                    results.add(listOf(first, nums[min], nums[max]))
                    min++
                    max--
                }
                sum < 0 -> min++
                else -> max--
            }
        }
    }

    return results.toMutableList()
}




/*--------------------------------------------------------------------*/

@Suppress("SameParameterValue", "unused")
private fun findNumByVeryLongLineCoder(nums: IntArray, listResults: MutableList<List<Int>>): MutableList<List<Int>> {
    var countAnswers = 0

    //if [0,0,0,...)
    if (nums.distinct().size == 1 && nums[0] == 0) {
        return mutableListOf(listOf(0, 0, 0))
    }

    //if [n1, n2, n3]
    if (nums.size == 3 && nums[0] + nums[1] == -nums[2]) {
        return mutableListOf(listOf(nums[0], nums[1], nums[2]))
    }

    //find first
    for (f in 0 until nums.size - 2) {

        if (f < nums.size - 3 && nums[f] == nums[f + 1] && nums[f] == nums[f + 2] && nums[f] != nums[f + 3]) {
            val first = nums[f]
            val second = nums[f + 1]
            val third = nums[f + 2]

            if (first + second == -third) {
                countAnswers++
                listResults.add(listOf(first, second, third))
            }

        }

        if (nums[f] == nums[f + 1] && nums[f] != nums[f + 2]) {
            val first = nums[f]
            val second = nums[f + 1]
            for (t in f + 2 until nums.size) {
                if (t < nums.size - 1 && nums[t] == nums[t + 1]) continue
                val third = nums[t]

                if (first + second == -third) {
                    countAnswers++
                    listResults.add(listOf(first, second, third))
                }
            }
            continue
        } else if (nums[f] == nums[f + 1]) continue

        val first = nums[f]

        //if last num is repeated
        if (nums[nums.size - 2] == nums[nums.size - 1]) {
            val second = nums[nums.size - 2]
            val third = nums[nums.size - 1]

            if (first + second == -third) {
                countAnswers++
                listResults.add(listOf(first, second, third))
            }
        }

        //find second
        for (s in f + 1 until nums.size - 1) {

            if (s < nums.size - 2 && nums[s] == nums[s + 1] && nums[s] != nums[s + 2]) {
                val second = nums[s]
                val third = nums[s + 1]

                if (first + second == -third) {
                    countAnswers++
                    listResults.add(listOf(first, second, third))
                }
            }
            if (nums[s] == nums[s + 1]) continue
            val second = nums[s]

            //find third
            for (t in s + 1 until nums.size) {
                if (t < nums.size - 1 && nums[t] == nums[t + 1]) continue
                val third = nums[t]

                if (first + second == -third) {
                    countAnswers++
                    listResults.add(listOf(first, second, third))
                }
            }
        }
    }

    return if (countAnswers >= 1) {
        listResults.distinct().toMutableList()
    } else {
        mutableListOf()
    }
}