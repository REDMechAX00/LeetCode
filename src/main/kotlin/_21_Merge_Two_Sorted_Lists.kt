fun main() {
    val list1 = createLinkedList(listOf(1, 2, 4, 5))
    val list2 = createLinkedList(listOf(1, 3, 4, 6))
    printlnListNode(mergeTwoLists(list1, list2))
}

@Suppress("SameParameterValue", "unused")
private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var l1: ListNode? = list1
    var l2: ListNode? = list2

    val head = ListNode(0)
    var current = head

    while (l1 != null || l2 != null) {
        val val1 = l1?.`val`
        val val2 = l2?.`val`
        if (val1 != null && val2 != null) {
            if (val1 < val2) {
                current.next = ListNode(val1)
                current = current.next!!
                l1 = l1?.next
            } else if (val1 > val2) {
                current.next = ListNode(val2)
                current = current.next!!
                l2 = l2?.next
            } else {
                current.next = ListNode(val1)
                current = current.next!!
                current.next = ListNode(val2)
                current = current.next!!
                l1 = l1?.next
                l2 = l2?.next
            }
        } else if (val1 != null) {
            current.next = ListNode(val1)
            current = current.next!!
            l1 = l1?.next
        } else if (val2 != null) {
            current.next = ListNode(val2)
            current = current.next!!
            l2 = l2?.next
        }
    }

    return head.next
}