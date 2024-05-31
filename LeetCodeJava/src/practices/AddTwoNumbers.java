package practices;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p></p>
 * Example:
 * l1: 2 -> 4 -> 3
 * l2: 5 -> 6 -> 4
 * ls: 7 -> 0 -> 8
 * From l1 and l2, create new linked list, each element equals to the sum of elements of same index from l1, l2.
 * if sum is gt 10, take the digit and move the carry to next index.
 * 4 + 6 = 10 => result = 0 and take carry = 1 to 3 + 4 + carry = 8
 *
 * <p></p>
 * Example:
 * l1: 0
 * l2: 0
 * ls: 0
 *
 * <p></p>
 * Example:
 * l1: 9 -> 9 -> 9 -> 9 -> 9 -> 9 -> 9
 * l2: 9 -> 9 -> 9 -> 9
 * ls: 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1
 * Like above, the carry applied to null value and create new value = carry in the end of ls.
 */
public class AddTwoNumbers {
    public static ListNode solution(ListNode l1, ListNode l2) {
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

        ListNode ls1 = solution(l11, l21);
        int i1 = 0;
        while (ls1!=null) {
            System.out.println("Index: " + i1 + " result val: " + ls1.val);
            i1++;
            ls1 = ls1.next;
        }

        System.out.println();
        ListNode l12 = new ListNode(0);
        ListNode l22 = new ListNode(0);

        ListNode ls2 = solution(l12, l22);
        int i2 = 0;
        while (ls2!=null) {
            System.out.println("Index: " + i2 + " result val: " + ls2.val);
            i2++;
            ls2 = ls2.next;
        }

        System.out.println();
        ListNode l13 = new ListNode(0);
        l13.next = new ListNode(9);
        l13.next.next = new ListNode(9);
        l13.next.next.next = new ListNode(9);
        l13.next.next.next.next = new ListNode(9);
        l13.next.next.next.next.next = new ListNode(9);
        l13.next.next.next.next.next.next = new ListNode(9);
        l13.next.next.next.next.next.next.next = new ListNode(9);
        ListNode l23 = new ListNode(0);
        l23.next = new ListNode(9);
        l23.next.next = new ListNode(9);
        l23.next.next.next = new ListNode(9);
        l23.next.next.next.next = new ListNode(9);

        ListNode ls3 = solution(l13, l23);
        int i3 = 0;
        while (ls3!=null) {
            System.out.println("Index: " + i3 + " result val: " + ls3.val);
            i3++;
            ls3 =  ls3.next;
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
