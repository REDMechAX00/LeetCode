fun main() {
    val head = createLinkedList(listOf(1, 2, 3, 4, 5))
    val n = 2
    printlnListNode(removeNthFromEnd(head, n))
}

@Suppress("SameParameterValue", "unused")
private fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val first = ListNode(0)
    first.next = head

    var next = first.next
    var listSize = 0
    while (next != null) {
        listSize++
        next = next.next
    }

    val deletedPosition = listSize - n
    next = first

    for (i in 0 until deletedPosition) {
        next = next?.next
    }

    next?.next = next?.next?.next

    return first.next
}