package terrell.leetcode.linkedlist;
/**
 * @author: TerrellChen
 * @version: Created in 23:31 2020-08-25
 */

/**
 * Description: 86 Partition List
 * Difficulty: Medium
 * 题目：给出一个链表和一个值x，将链表里小于x的放在大于或等于x的前面，保持原有顺序
 * 解法：两个指针，一个指到首个大于x的前面，一个从这里往后搜索小于x的，挖出来，放前面
 */
public class EightySix {

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

    public ListNode partition(ListNode head, int x) {
        ListNode start = new ListNode();
        start.next = head;
        if (head == null) {
            return start.next;
        }
        head = start;
        while (head.next != null && head.next.val < x) {
            head = head.next;
        }
        if (head.next == null) {
            return start.next;
        }

        ListNode lastSmallThan = head;
        ListNode pointer = head;
        while (pointer != null) {
            while (pointer.next != null && pointer.next.val >= x) {
                pointer = pointer.next;
            }
            if (pointer.next != null) {
                insertNext(lastSmallThan, digNext(pointer));
                lastSmallThan = lastSmallThan.next;
            } else {
                pointer = pointer.next;
            }
        }
        return start.next;
    }

    public ListNode digNext(ListNode cur) {
        ListNode tmp = cur.next;
        cur.next = cur.next.next;
        return tmp;
    }

    public void insertNext(ListNode cur, ListNode inserted) {
        ListNode tmp = cur.next;
        cur.next = inserted;
        inserted.next = tmp;
    }

    public static void main(String[] args) {
        EightySix eightySix = new EightySix();
        ListNode result;
        ListNode listNode;
        listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(2);

        result = eightySix.partition(listNode, 3);
        System.out.println(result.val);

        listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        result = eightySix.partition(listNode, 0);
        System.out.println(result.val);

        listNode = new ListNode(2);
        listNode.next = new ListNode(1);
        result = eightySix.partition(listNode, 2);
        System.out.println(result.val);

        listNode = new ListNode(3);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        result = eightySix.partition(listNode, 3);
        System.out.println(result.val);
    }
}
