class ListNode:
    def __init__(self, val=0, nexxt=None):
        self.val = val
        self.nexxt = nexxt


def add_two_numbers(l1: ListNode, l2: ListNode) -> ListNode:
    carrier = 0
    dump: ListNode = ListNode(0)
    curr: ListNode = dump

    while l1 is not None or l2 is not None or carrier != 0:
        x = l1.val if l1 is not None else 0
        y = l2.val if l2 is not None else 0
        total = carrier + x + y
        carrier = total // 10
        curr.nexxt = ListNode(total % 10)
        curr = curr.nexxt
        l1 = l1.nexxt if l1 is not None else None
        l2 = l2.nexxt if l2 is not None else None

    return dump.nexxt


def _create_linked_list(values):
    if not values:
        return None
    head = ListNode(values[0])
    curr = head
    for val in values[1:]:
        curr.nexxt = ListNode(val)
        curr = curr.nexxt
    return head


def _print_linked_list(node):
    i = 0
    while node is not None:
        print(f"index: {i}, val: {node.val}")
        i += 1
        node = node.nexxt
    print()


if __name__ == '__main__':
    l1 = _create_linked_list([2, 4, 3])
    l2 = _create_linked_list([5, 6, 4])
    ls12 = add_two_numbers(l1, l2)
    _print_linked_list(ls12)

    l3 = _create_linked_list([0])
    l4 = _create_linked_list([0])
    ls34 = add_two_numbers(l3, l4)
    _print_linked_list(ls34)

    l5 = _create_linked_list([0, 9, 9, 9, 9, 9, 9, 9])
    l6 = _create_linked_list([0, 9, 9, 9, 9])
    ls56 = add_two_numbers(l5, l6)
    _print_linked_list(ls56)
