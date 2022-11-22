fun main() {
    val data = IntArray(21)
    for (i in data.indices) {
        when (i) {
            3 -> data[i] = 0
            4 -> data[i] = 0
            5 -> data[i] = 0
            8 -> data[i] = 0
            14 -> data[i] = 0
            15 -> data[i] = 0
            17 -> data[i] = 0
            18 -> data[i] = 0
            else -> data[i] = i
        }
    }

    printArray(goZeroesToBottom(data, 0))

}

private fun goZeroesToBottom(data: IntArray, i: Int): IntArray {
    val current = data[i]
    if (i != data.size - 1) {
        return when (current) {
            0 -> {
                var j = i + 1
                var next = data[j]
                while (next == 0 && j<data.size-1) {
                    j++
                    next = data[j]
                }
                data[i] = next
                data[j] = 0
                goZeroesToBottom(data, i + 1)
            }

            else -> {
                goZeroesToBottom(data, i + 1)
            }
        }
    } else {
        return data
    }
}

private fun printArray(data: IntArray) {
    data.forEach {
        println(it)
    }
}