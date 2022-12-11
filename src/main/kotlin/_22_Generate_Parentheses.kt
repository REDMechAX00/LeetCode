fun main() {
    val n = 4
    println(generateParenthesis(n).toString())
}

@Suppress("SameParameterValue", "unused")
private fun generateParenthesis(n: Int): List<String> {
    val list: MutableList<String> = mutableListOf()
    generateCombination(n, 0, 0, "", list)
    return list
}

@Suppress("SameParameterValue", "unused")
private fun generateCombination(n: Int, open: Int, close: Int, comb: String, list: MutableList<String>) {
    if (comb.length == n * 2){
        list.add(comb)
        return
    }

    if (open < n) {
        generateCombination(n, open + 1, close, "$comb(", list)
    }
    if (open > close) {
        generateCombination(n, open, close + 1, "$comb)", list)
    }
}