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


    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        l11.next = new ListNode(4);
        l11.next.next = new ListNode(3);

        ListNode l21 = new ListNode(5);
        l21.next = new ListNode(6);
        l21.next.next = new ListNode(4);

        ListNode ls1 = add(l11, l21);
        int i1 = 0;
        while (ls1!=null) {
            System.out.println("Index: " + i1 + " result val: " + ls1.val);
            i1++;
            ls1 = ls1.next;
        }

        System.out.println();
        ListNode l12 = new ListNode(0);
        ListNode l22 = new ListNode(0);

        ListNode ls2 = add(l12, l22);
        int i2 = 0;
        while (ls2!=null) {
            System.out.println("Index: " + i2 + " result val: " + ls2.val);
            i2++;
            ls2 = ls2.next;
        }

        System.out.println();
        ListNode l31 = new ListNode(0);
        l31.next = new ListNode(9);
        l31.next.next = new ListNode(9);
        l31.next.next.next = new ListNode(9);
        l31.next.next.next.next = new ListNode(9);
        l31.next.next.next.next.next = new ListNode(9);
        l31.next.next.next.next.next.next = new ListNode(9);
        l31.next.next.next.next.next.next.next = new ListNode(9);
        ListNode l32 = new ListNode(0);
        l32.next = new ListNode(9);
        l32.next.next = new ListNode(9);
        l32.next.next.next = new ListNode(9);
        l32.next.next.next.next = new ListNode(9);

        ListNode ls3 = add(l31, l32);
        int i3 = 0;
        while (ls3!=null) {
            System.out.println("Index: " + i3 + " result val: " + ls3.val);
            i3++;
            ls3 = ls3.next;
        }
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
