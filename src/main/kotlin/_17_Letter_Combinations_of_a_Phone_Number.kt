fun main() {
    val input = "234"
    println(letterCombinations(input))
}

@Suppress("SameParameterValue", "unused")
fun letterCombinations(digits: String): List<String> {
    val combs = arrayListOf<String>()

    val lettersMap: HashMap<Char, String> = hashMapOf()
    lettersMap['2'] = "abc"
    lettersMap['3'] = "def"
    lettersMap['4'] = "ghi"
    lettersMap['5'] = "jkl"
    lettersMap['6'] = "mno"
    lettersMap['7'] = "pqrs"
    lettersMap['8'] = "tuv"
    lettersMap['9'] = "wxyz"

    digits.forEach { num ->
        combs.addAll(makeCombination(combs, lettersMap[num] ?: ""))
    }

    return combs.filter { it.length == digits.length }
}

@Suppress("SameParameterValue", "unused")
fun makeCombination(combs: ArrayList<String>, letters: String): List<String> {
    val newCombs = arrayListOf<String>()

    if (combs.isEmpty()) {
        letters.forEach { letter ->
            combs.add(letter.toString())
        }
    } else {
        combs.forEach { comb ->
            letters.forEach { letter ->
                newCombs.add(comb + letter)
            }
        }
    }

    return newCombs
}