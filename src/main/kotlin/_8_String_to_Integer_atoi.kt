fun main() {
    val input = "21474836460"
    val result = myAtoi(input)

    println("$result")
}

@Suppress("SameParameterValue")
private fun myAtoi(s: String): Int {

    var number: Long? = null
    var positivity: Int? = null

    for (i in s.indices) {
        val char = s.substring(i, i + 1)

        if (number == null) {
            when (char) {
                " " -> {
                    if (positivity != null) {
                        return 0
                    }
                }

                "-" -> {
                    if (positivity == null) {
                        positivity = -1
                    } else {
                        return 0
                    }
                }

                "+" -> {
                    if (positivity == null) {
                        positivity = 1
                    } else {
                        return 0
                    }
                }

                "." -> {
                    return 0
                }

                else -> {
                    if (char.toIntOrNull() != null) {
                        number = char.toLong()
                    } else {
                        return 0
                    }
                }
            }
        } else {
            when (char) {
                " " -> {
                    return number.toInt() * (positivity ?: 1)
                }

                "-" -> {
                    return number.toInt() * (positivity ?: 1)
                }

                "+" -> {
                    return number.toInt() * (positivity ?: 1)
                }

                "." -> {
                    return number.toInt() * (positivity ?: 1)
                }

                else -> {
                    if (char.toIntOrNull() != null) {
                        number = number * 10 + char.toInt()
                        if (number * (positivity ?: 1) > Integer.MAX_VALUE) {
                            return Int.MAX_VALUE
                        }
                        if (number * (positivity ?: 1) < Integer.MIN_VALUE) {
                            return Int.MIN_VALUE
                        }
                    } else {
                        return number.toInt() * (positivity ?: 1)
                    }
                }
            }
        }
    }

    val result = number?.toInt() ?: 0

    return result * (positivity ?: 1)
}