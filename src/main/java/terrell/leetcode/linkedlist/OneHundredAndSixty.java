package terrell.leetcode.linkedlist;
/**
 * @author: TerrellChen
 * @version: Created in 00:16 2020-09-05
 */

/**
 * Description: 160 Intersection of Two Linked Lists
 * Difficulty: Easy
 * 题目：找到两个链表起始的交界点
 * 解法：因为共同串的长度是一定的，链接两个串形成AB及BA，两个指针在上面分别前进1位，最终会遇见，遇见的点就是共同串的开始点
 */
public class OneHundredAndSixty {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode iterA = headA;
        ListNode iterB = headB;
        while (iterA != iterB) {
            iterA = iterA == null ? headB : iterA.next;
            iterB = iterB == null ? headA : iterB.next;
        }
        return iterA;
    }
}
