fun main() {
    val head = createLinkedList(listOf(1, 2, 3, 4, 5))
    val k = 2
    printlnListNode(reverseKGroup(head, k))
}

@Suppress("SameParameterValue", "unused")
private fun reverseKGroup(_head: ListNode?, k: Int): ListNode? {
    if (_head == null) return null
    if (k == 1) return _head

    val head = ListNode(0)
    head.next = _head

    var slider: ListNode? = head

    val reversePart = mutableListOf<ListNode?>()

    while (true) {
        val cacheSlider = slider
        //Create list with nodes in current part for reverse
        for (i in 0..k) {
            //If part longer than k then return
            if (i in 1 until k && slider?.next == null) return head.next
            else {
                reversePart.add(slider?.next)
                slider = slider?.next
            }
        }
        //Restore slider
        slider = cacheSlider

        //Reverse part
        for (i in 1 until reversePart.size - 1) {
            reversePart[i]?.next = reversePart[i - 1]
        }

        //Connect ends of nodes to chain
        reversePart[0]?.next = reversePart[k]
        slider?.next = reversePart[k - 1]

        //Prepare next step
        slider = reversePart[0]
        reversePart.clear()
    }
}