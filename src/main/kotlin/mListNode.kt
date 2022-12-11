class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun createLinkedList(input: List<Int>): ListNode? {
    if(input.isEmpty()) return null
    val head = ListNode(input[0])
    var currentNode = head
    for (i in 1 until input.size) {
        val newNode = ListNode(input[i])
        currentNode.next = newNode
        currentNode = newNode
    }
    return head
}

@Suppress("SameParameterValue", "unused")
fun printlnListNode(head: ListNode?) {
    println(head?.`val`)
    if (head?.next != null) {
        printlnListNode(head.next!!)
    }
}