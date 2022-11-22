import java.io.File

fun main() {
    val bufferedReader = File("input.txt").bufferedReader()
    val lineList = mutableListOf<String>()
    bufferedReader.useLines { lines -> lines.forEach { lineList.add(it) } }

    val input = lineList[0].replace("],", "\n")
        .replace("[", "")
        .replace("]", "")
        .replace("l1 = ", "")
        .replace(" l2 = ", "")
        .replace(",", " ")

    val inputList = input.split("\n")
    val inputL1 = inputList[0].split(" ")
    val inputL2 = inputList[1].split(" ")

    val l1 = ListNode(inputL1[0].toInt())
    if (inputL1.size > 1) {
        addAll(l1, inputL1, 1)
    }

    val l2 = ListNode(inputL2[0].toInt())
    if (inputL2.size > 1) {
        addAll(l2, inputL2, 1)
    }

    printlnListNode(addTwoNumbers(l1, l2)!!)

    File("output.txt").printWriter().use { out ->
        out.println()
    }
}

fun addTwoNumbers(_l1: ListNode?, _l2: ListNode?): ListNode? {
    var l1 = _l1
    var l2 = _l2
    val dummyHead = ListNode(0)
    var curr: ListNode? = dummyHead
    var carry = 0
    while (l1 != null || l2 != null || carry != 0) {
        val val1 = l1?.`val` ?: 0
        val val2 = l2?.`val` ?: 0

        var sum = val1 + val2 + carry
        carry = 0
        if (sum > 9) {
            sum %= 10
            carry = 1
        }

        curr!!.next = ListNode(sum)
        curr = curr.next
        if (l1 != null) l1 = l1.next
        if (l2 != null) l2 = l2.next
    }
    return dummyHead.next
}

//Recursion
@Suppress("unused")
fun addNumbers(_l1: ListNode?, _l2: ListNode?, _curr: ListNode?, _carry: Int) {
    var l1 = _l1
    var l2 = _l2
    var carry = _carry
    var curr = _curr
    val val1 = l1?.`val` ?: 0
    val val2 = l2?.`val` ?: 0

    var sum = val1 + val2 + carry
    carry = 0
    if (sum > 9) {
        sum %= 10
        carry = 1
    }

    curr?.next = ListNode(sum)
    curr = curr?.next!!
    if (l1 != null) l1 = l1.next
    if (l2 != null) l2 = l2.next

    if (l1 != null || l2 != null || carry != 0) {
        addNumbers(l1, l2, curr, carry)
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

//My function for create l1 & l2
fun printlnListNode(ln: ListNode) {
    println(ln.`val`)
    if (ln.next != null) {
        printlnListNode(ln.next!!)
    }
}

fun addAll(ln: ListNode, items: List<String>, count: Int) {
    val newNode = ListNode(items[count].toInt())
    ln.next = newNode
    if (count + 1 < items.size) {
        addAll(ln.next!!, items, count + 1)
    }
}