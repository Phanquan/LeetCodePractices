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


def create_linked_list(values):
    if not values:
        return None
    head = ListNode(values[0])
    current = head
    for val in values[1:]:
        current.nexxt = ListNode(val)
        current = current.nexxt
    return head


def print_linked_list(node):
    while node is not None:
        print(f"val: {node.val}")
        node = node.nexxt
    print()


if __name__ == '__main__':
    l1 = create_linked_list([2, 4, 3])
    l2 = create_linked_list([5, 6, 4])
    ls12 = add_two_numbers(l1, l2)
    print_linked_list(ls12)

    l3 = create_linked_list([0])
    l4 = create_linked_list([0])
    ls34 = add_two_numbers(l3, l4)
    print_linked_list(ls34)

    l5 = create_linked_list([0, 9, 9, 9, 9, 9, 9, 9])
    l6 = create_linked_list([0, 9, 9, 9, 9])
    ls56 = add_two_numbers(l5, l6)
    print_linked_list(ls56)
