fun main() {
    val input = arrayOf("flower", "flow", "flight")
    println(longestCommonPrefix(input))
}

@Suppress("SameParameterValue", "unused")
private fun longestCommonPrefix(strs: Array<String>): String {
    //Sorting strs
    val sortedStrs = strs.toMutableList()
    sortedStrs.sortBy { it.length }

    //Generate all available the first prefixes
    val prefixes = mutableListOf<String>()
    for (i in sortedStrs[0].indices) {
        prefixes.add(sortedStrs[0].substring(0, i + 1))
    }

    return findMaxPrefix(sortedStrs, prefixes)
}

@Suppress("SameParameterValue", "unused")
private fun findMaxPrefix(strs: MutableList<String>, prefixes: MutableList<String>): String {

    prefixes.forEach { prefix ->
        strs.forEach { str ->
            if (str.substring(0, prefix.length) != prefix) {
                prefixes.removeAll { it.length >= prefix.length}
                strs.removeAll { it.length >= prefix.length }
                return findMaxPrefix(strs, prefixes)
            }
        }
    }

    if(prefixes.isNotEmpty()){
        return prefixes[prefixes.lastIndex]
    }

    return ""
}