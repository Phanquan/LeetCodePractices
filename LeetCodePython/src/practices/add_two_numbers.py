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


if __name__ == '__main__':
    l11: ListNode = ListNode(2)
    l11.nexxt = ListNode(4)
    l11.nexxt.nexxt = ListNode(3)

    l12: ListNode = ListNode(5)
    l12.nexxt = ListNode(6)
    l12.nexxt.nexxt = ListNode(4)

    ls1: ListNode = add_two_numbers(l11, l12)
    while ls1 is not None:
        print(f"val: {ls1.val}")
        ls1 = ls1.nexxt

    print()

    l21: ListNode = ListNode(0)
    l22: ListNode = ListNode(0)

    ls2: ListNode = add_two_numbers(l21, l22)
    while ls2 is not None:
        print(f"val: {ls2.val}")
        ls2 = ls2.nexxt

    print()

    l31: ListNode = ListNode(0)
    l31.nexxt = ListNode(9)
    l31.nexxt.nexxt = ListNode(9)
    l31.nexxt.nexxt.nexxt = ListNode(9)
    l31.nexxt.nexxt.nexxt.nexxt = ListNode(9)
    l31.nexxt.nexxt.nexxt.nexxt = ListNode(9)
    l31.nexxt.nexxt.nexxt.nexxt.nexxt = ListNode(9)
    l31.nexxt.nexxt.nexxt.nexxt.nexxt.nexxt = ListNode(9)

    l32: ListNode = ListNode(0)
    l32.nexxt = ListNode(9)
    l32.nexxt.nexxt = ListNode(9)
    l32.nexxt.nexxt.nexxt = ListNode(9)
    l32.nexxt.nexxt.nexxt.nexxt = ListNode(9)

    ls3: ListNode = add_two_numbers(l31, l32)
    while ls3 is not None:
        print(f"val: {ls3.val}")
        ls3 = ls3.nexxt
