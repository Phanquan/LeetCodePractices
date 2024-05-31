package practices;

public class AddTwoNumbers {
    public static ListNode add(ListNode l1, ListNode l2) {
        int carrier = 0;
        ListNode dump = new ListNode(0);
        ListNode curr = dump;

        while (l1!=null || l2!=null || carrier!=0) {
            int x = (l1!=null) ? l1.val:0;
            int y = (l2!=null) ? l2.val:0;
            int sum = carrier + x + y;
            carrier = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1!=null) {
                l1 = l1.next;
            }

            if (l2!=null) {
                l2 = l2.next;
            }
        }

        return dump.next;
    }

    private static ListNode createLinkedList(int... values) {
        if (values==null || values.length==0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode curr = head;
        for (int v : values) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return head;
    }

    private static void printLinkedList(ListNode node) {
        int i = 0;
        while (node!=null) {
            System.out.println("index: " + i + ", val: " + node.val);
            i++;
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = createLinkedList(2, 4, 3);
        ListNode l2 = createLinkedList(5, 6, 4);
        ListNode ls12 = add(l1, l2);
        printLinkedList(ls12);

        ListNode l3 = createLinkedList(0);
        ListNode l4 = createLinkedList(0);
        ListNode l34 = add(l3, l4);
        printLinkedList(l34);

        ListNode l5 = createLinkedList(0, 9, 9, 9, 9, 9, 9, 9);
        ListNode l6 = createLinkedList(0, 9, 9, 9, 9);
        ListNode ls56 = add(l5, l6);
        printLinkedList(ls56);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
