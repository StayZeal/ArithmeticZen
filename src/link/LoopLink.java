package link;


import co.gofun.java.Util;

/**
 * 单链表求环以及链表相交问题
 * Created by Ador on 2017/11/19.
 */
public class LoopLink {


    public static void main(String[] args) {

        SinglyNode link = CreateLink.create1();
//        CreateLink.printLink(link);


        System.out.println(getLoopNode(link).node);
    }

    /**
     * 两个指针fast,slow
     * fast每次移动两个指针.slow每次移动一个指针
     * 如果fast和slow不相遇说明没有环，否则含环
     * 相遇之后，fast指向头指针，slow不动;
     * fast和slow继续移动，每次都移动一个指针，第一次相遇的节点即为入环节点。
     * @param head
     * @return
     */
    public static SinglyNode getLoopNode(SinglyNode head) {

        Util.checkNull(head);
        if (head.next == null || head.next.next == null) {
            return null;
        }

        SinglyNode slow, fast;
        slow = head.next;
        fast = head.next.next;

        while (slow != fast) {

            if (slow.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
