fun main() {
    val array: Array<ListNode?> =
        arrayOf(
            createLinkedList(listOf(1, 2, 3, 4)),
            createLinkedList(listOf(11)),
            createLinkedList(listOf(10, 20, 30))
        )

    printlnListNode(mergeKLists(array))
}

@Suppress("SameParameterValue", "unused")
private fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val head = ListNode(0)
    var current = head

    if(isAllNull(lists)) return null

    while (true) {
        var step = 0
        var min = lists[step]?.`val` ?: Integer.MAX_VALUE
        for (i in 0 until lists.size - 1) {
            val value = lists[i + 1]?.`val` ?: Integer.MAX_VALUE
            if (value != Integer.MAX_VALUE) {
                if (value < min) {
                    min = value
                    step = i + 1
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            return head.next
        }

        lists[step] = lists[step]?.next
        current.next = ListNode(min)
        current = current.next!!
    }
}

@Suppress("SameParameterValue", "unused")
private fun isAllNull(list: Array<ListNode?>): Boolean {
    for (node in list) {
        if (node != null) return false
    }
    return true
}