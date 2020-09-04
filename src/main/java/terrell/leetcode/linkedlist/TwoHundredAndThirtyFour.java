package terrell.leetcode.linkedlist;
/**
 * @author: TerrellChen
 * @version: Created in 00:44 2020-09-05
 */

/**
 * Description: 234 Palindrome Linked List
 * Difficulty: Easy
 * 题目：判断链表是否是回文
 * 解法：通过快慢指针找到中点，找到中点的过程中将前半截链表反转。然后从中点开始比较两段链表
 */
public class TwoHundredAndThirtyFour {
    public static class ListNode {
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

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode prev = null, iter = head, mid = head;
        while (iter != null && iter.next != null) {
            iter = iter.next.next;
            ListNode next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }


        ListNode secondHalf = null;
        if (iter == null) {
            secondHalf = mid;
        } else {
            secondHalf = mid.next;
        }
        mid = prev;

        while (mid != null && secondHalf != null) {
            if (mid.val != secondHalf.val) {
                return false;
            }

            mid = mid.next;
            secondHalf = secondHalf.next;
        }

        return true;

    }

    public static void main(String[] args) {
        TwoHundredAndThirtyFour twoHundredAndThirtyFour = new TwoHundredAndThirtyFour();

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);

        System.out.println(twoHundredAndThirtyFour.isPalindrome(listNode));

        listNode = new ListNode(1);
        listNode.next = new ListNode(0);
        listNode.next.next = new ListNode(0);

        System.out.println(twoHundredAndThirtyFour.isPalindrome(listNode));

        listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);
        System.out.println(twoHundredAndThirtyFour.isPalindrome(listNode));
    }
}
