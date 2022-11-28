fun main() {
    val input = 1994
    println(intToRoman(input))
}

@Suppress("SameParameterValue", "unused")
private fun intToRoman(num: Int): String {
    var roman = ""
    if (num in 1..3999) {

        //>=1000
        if ((num / 1000) % 10 > 0) {
            for (i in 0 until (num / 1000) % 10) {
                roman += "M"
            }
        }

        //100-900
        if ((num / 100) % 10 > 0) {
            when ((num / 100) % 10) {
                9 -> {
                    roman += "CM"
                }

                in 5..8 -> {
                    roman += "D"
                    for (i in 6..(num / 100) % 10) {
                        roman += "C"
                    }
                }

                4 -> {
                    roman += "CD"
                }

                in 1..3 -> {
                    for (i in 1..(num / 100) % 10) {
                        roman += "C"
                    }
                }
            }
        }

        //10-90
        if ((num / 10) % 10 > 0) {
            when ((num / 10) % 10) {
                9 -> {
                    roman += "XC"
                }

                in 5..8 -> {
                    roman += "L"
                    for (i in 6..(num / 10) % 10) {
                        roman += "X"
                    }
                }

                4 -> {
                    roman += "XL"
                }

                in 1..3 -> {
                    for (i in 1..(num / 10) % 10) {
                        roman += "X"
                    }
                }
            }
        }

        //1-9
        if ((num / 1) % 10 > 0) {
            when ((num / 1) % 10) {
                9 -> {
                    roman += "IX"
                }

                in 5..8 -> {
                    roman += "V"
                    for (i in 6..(num / 1) % 10) {
                        roman += "I"
                    }
                }

                4 -> {
                    roman += "IV"
                }

                in 1..3 -> {
                    for (i in 1..(num / 1) % 10) {
                        roman += "I"
                    }
                }
            }
        }
    }
    return roman
}