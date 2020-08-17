package terrell.leetcode.linkedlist;
/**
 * @author: TerrellChen
 * @version: Created in 22:03 2020-08-17
 */

/**
 * Description: 21 Merge Two Sorted Lists
 * Difficulty: easy
 * 题目：合并两个有序链表
 * 解法：暴力。。
 */
public class TwentyOne {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode root = result;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                result.next = l2;
                break;
            } else if (l2 == null) {
                result.next = l1;
                break;
            }

            if (l1.val > l2.val) {
                result.next = l2;
                l2 = l2.next;
            } else {
                result.next = l1;
                l1 = l1.next;
            }
            result = result.next;
        }
        return root.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        TwentyOne twentyOne = new TwentyOne();
        twentyOne.mergeTwoLists(l1, l2);
        System.out.print("");

    }
}
