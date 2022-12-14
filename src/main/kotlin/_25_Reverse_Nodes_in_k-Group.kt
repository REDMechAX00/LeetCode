fun main() {
    val head = createLinkedList(listOf(1, 2))
    val k = 2
    printlnListNode(reverseKGroup(head, k))
}

@Suppress("SameParameterValue", "unused")
private fun reverseKGroup(_head: ListNode?, k: Int): ListNode? {
    if (_head == null) return null
    if (k == 1) return _head

    val head = ListNode(0)
    head.next = _head

    var nextPart: ListNode? = head.next
    var slider: ListNode? = head
    var start = head.next

    while (nextPart != null) {
        for (i in 0 until k) {
            nextPart = nextPart?.next
            if (i != k - 1 && nextPart == null) return head.next
        }

        slider?.next = recursion(start, start?.next, k, 0)

        start?.next = nextPart
        slider = start

        start = nextPart
    }

    return head.next
}

@Suppress("SameParameterValue", "unused")
private fun recursion(start: ListNode?, end: ListNode?, k: Int, i: Int): ListNode? {
    if (i == k - 1) return start
    val next = end?.next
    end?.next = start
    return recursion(end, next, k, i + 1)
}


//Second variant
@Suppress("SameParameterValue", "unused")
private fun reverseKGroupSecond(_head: ListNode?, k: Int): ListNode? {
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