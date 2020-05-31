package hw2020;

import java.util.ArrayList;
import java.util.List;

public class ez_listMerge {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static List show(ListNode l) {
        ArrayList ret = new ArrayList();
        while (l != null) {
            ret.add(l.val);
            l = l.next;
        }
        return ret;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else if (l1.val >= l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        return null;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(show(new ez_listMerge().mergeTwoLists(l1, l2)));
    }

}
