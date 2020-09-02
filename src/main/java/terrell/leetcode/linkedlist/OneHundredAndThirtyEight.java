package terrell.leetcode.linkedlist;
/**
 * @author: TerrellChen
 * @version: Created in 21:45 2020-09-01
 */

/**
 * Description: 138 Copy List with Random Pointer
 * Difficulty: Medium
 * 题目：有一个链表，每个节点包含指向链表中随机点的指针，要求返回这个链表的深拷贝
 * 解法：难点主要在拷贝队列的random如何赋值，那么在创建拷贝队列的时候和原队列关联即可。
 * 先在原队列中插入拷贝队列串联，
 * 然后设置拷贝队列的random指针，
 * 然后剔出拷贝节点即可
 */
public class OneHundredAndThirtyEight {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node iter = head, next;
        // 创造一个copy队列，插入原队列中
        // ori_1 -> copy_1 -> ori_2 -> copy_2 ......
        while (iter != null) {
            next = iter.next;
            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        // 这时原队列的random还是指向原队列，但是next就是copy了
        // 利用这点可以为copy的random赋值

        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // 这时copy的random赋值完毕，只需要剔除队列中的原node即可
        iter = head;
        Node start = new Node(0);
        Node copy, copyIter = start;

        while (iter != null) {
            next = iter.next.next;

            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            iter.next = next;
            iter = next;
        }

        return start.next;
    }
}
