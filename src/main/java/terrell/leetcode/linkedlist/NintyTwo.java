package terrell.leetcode.linkedlist;
/**
 * @author: TerrellChen
 * @version: Created in 22:10 2020-08-27
 */

/**
 * Description: 92 Reverse Linked List II
 * Difficulty: Medium
 * 题目：给出一个链表和两个数，将索引在这两个数之间的部分反转
 * 解法：找到截出这一段数据，反转，再拼进去
 */
public class NintyTwo {
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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode start = new ListNode();
        start.next = head;
        head = start;
        while (m > 1) {
            m--;
            n--;
            head = head.next;
        }
        if (head == null || head.next == null) {
            return start.next;
        }
        ListNode firstEnd = head;
        ListNode secondEnd = head.next;
        head = secondEnd;
        if (head == null || head.next == null) {
            return start.next;
        }
        ListNode thirdStart = head.next.next;
        ListNode secondStart = head.next;
        if (n > 1) {
            while (n > 1) {
                n--;
                secondStart.next = head;
                head = secondStart;
                if (n == 1) {
                    break;
                }
                secondStart = thirdStart;
                thirdStart = thirdStart.next;
            }

            firstEnd.next = secondStart;
            secondEnd.next = thirdStart;
        }
        return start.next;
    }

    public void print(ListNode listNode) {
        do {
            System.out.print(listNode.val);
            System.out.print(" -> ");
            listNode = listNode.next;
        } while (listNode != null);
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode listNode = null;
        int n = 0, m = 0;
        listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        m = 2;
        n = 4;
        NintyTwo nintyTwo = new NintyTwo();
        ListNode result = null;

//        result = nintyTwo.reverseBetween(listNode, m, n);
//        nintyTwo.print(result);

        listNode = new ListNode(3);
        listNode.next = new ListNode(5);
        m=1;n=1;
        result = nintyTwo.reverseBetween(listNode,m,n);
        nintyTwo.print(result);

    }
}

