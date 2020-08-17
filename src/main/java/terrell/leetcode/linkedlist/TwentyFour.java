package terrell.leetcode.linkedlist;
/**
 * @author: TerrellChen
 * @version: Created in 22:19 2020-08-17
 */

/**
 * Description: 41 Swap Nodes in Pairs
 * Difficulty: Medium
 * 题目：交换临近两个节点
 * 解法：暴力。。
 */
public class TwentyFour {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode start = prev;
        while (head != null && head.next != null) {
            ListNode nextnext = head.next.next;
            // prev -> head -> head.next -> nextnext
            // ->
            // prev -> head.next -> nextnext
            prev.next = head.next;
            // prev -> head.next -> nextnext
            // ->
            // prev -> head.next -> head
            head.next.next = head;
            // prev -> head.next -> head -> nextnext
            head.next = nextnext;
            // prev =head
            prev = head;
            // head = nextnext
            head = nextnext;

        }

        return start.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        TwentyFour twentyFour = new TwentyFour();
        twentyFour.swapPairs(head);

        System.out.print("");
    }
}
