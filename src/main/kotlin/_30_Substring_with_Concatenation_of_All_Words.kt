fun main() {
    val s = "aaa"
    val words = arrayOf("a", "a")
    println(findSubstring(s, words).toString())
}

fun findSubstring(s: String, words: Array<String>): List<Int> {
    val indexes = arrayListOf<Int>()
    val l = words[0].length

    if (s.length < words.size * l) return indexes

    //If s is identical
    if (s.replace(s.substring(0, l), "", true) == "") {
        //If all words == s
        if (words.none { it != s.substring(0, l) }) {
            if (s.length == words.size * l) {
                indexes.add(0)
            } else {
                for (i in 0 until l) {
                    cutS(s.substring(i), l, words, l + i, arrayListOf(), indexes)
                }
            }
        }
    } else {
        for (i in 0 until l) {
            cutS(s.substring(i), l, words, l + i, arrayListOf(), indexes)
        }
    }

    return indexes
}

private fun cutS(
    s: String,
    l: Int,
    words: Array<String>,
    cutCount: Int,
    ignoreList: ArrayList<Int>,
    indexes: ArrayList<Int>
) {
    if (s.length < l) return

    val part = s.substring(0, l)

    for (i in words.indices) {
        if (ignoreList.indexOf(i) == -1 && part == words[i]) {
            ignoreList.add(i)
            //If combination is complete
            if (ignoreList.size == words.size) {
                //Add first letter index to list
                indexes.add(cutCount - l * words.size)
                //Delete first ignore index
                ignoreList.removeAt(0)
                //Start cutS again
                cutS(s.substring(l), l, words, cutCount + l, ignoreList, indexes)
            }
            //If combination is not complete then continue
            else {
                cutS(s.substring(l), l, words, cutCount + l, ignoreList, indexes)
            }
            return
        }
    }

    println("next")
    //If combination is broken then go to first same part of new part
    if (ignoreList.isNotEmpty()) {
        for (i in ignoreList.indices) {
            if (words[ignoreList[i]] == part) {
                //Add new part index to the end
                ignoreList.add(ignoreList[i])
                //Move start to first same part of new part
                for (del in 0..i) ignoreList.removeAt(0)
                //Continue
                cutS(s.substring(l), l, words, cutCount + l, ignoreList, indexes)
                return
            }
        }
        cutS(s.substring(l), l, words, cutCount + l, arrayListOf(), indexes)
    }

    //If the word is not finds then refresh and continue
    else cutS(s.substring(l), l, words, cutCount + l, arrayListOf(), indexes)
}