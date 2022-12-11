fun main() {
    val head = createLinkedList(listOf(1, 2, 3, 4, 5))
    printlnListNode(swapPairs(head))
}

@Suppress("SameParameterValue", "unused")
private fun swapPairs(_head: ListNode?): ListNode? {
    val head = ListNode(0)
    head.next = _head

    var slider: ListNode? = head

    while (slider?.next != null) {
        val first = slider.next
        val second = first?.next
        val third = second?.next

        if(second!=null) slider.next = second
        else slider.next = first

        second?.next = first
        first?.next = third

        slider = first
    }

    return head.next
}