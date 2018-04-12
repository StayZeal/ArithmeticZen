package co.gofun.java.link;

/**
 * 合并两个有序链表
 * <p>
 *     测试用例
 * <p>
 * co.gofun.java.link start...<p>
 * 38 36 34 32 30 28 26 24 22 20 18 16 14 12 10 8 6 4 2 0<p>
 * co.gofun.java.link end.<p>
 * co.gofun.java.link start...<p>
 * 39 37 35 33 31 29 27 25 23 21 19 17 15 13 11 9 7 5 3 1<p>
 * co.gofun.java.link end.<p>
 * co.gofun.java.link start...<p>
 * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39<p>
 * co.gofun.java.link end.<p>
 */
public class MergeLink {

    public static void main(String[] args) {
        SinglyNode one = CreateLink.create(0, 2, 20, false);
        SinglyNode two = CreateLink.create(1, 2, 20, false);

        CreateLink.printLink(one);
        CreateLink.printLink(two);

        SinglyNode oneTwo = merge(one, two);
        CreateLink.printLink(oneTwo);
    }

    public static SinglyNode merge(SinglyNode node1, SinglyNode node2) {

        SinglyNode link = null;
        while (node1 != null || node2 != null) {

            if (node1 == null) {
                return add(link, node2);

            }
            if (node2 == null) {
                return add(link, node1);
            }

            int one = Integer.valueOf(node1.node);
            int two = Integer.valueOf(node2.node);
            if (one > two) {
                SinglyNode preOne = node1.next;
                node1.next = link;
                link = node1;//增加到新链表

                node1 = preOne;//记录老链表node1
            } else {
                SinglyNode preTwo = node2.next;
                node2.next = link;
                link = node2;

                node2 = preTwo;
            }
        }
        return link;
    }

    public static SinglyNode add(SinglyNode destination, SinglyNode toAdd) {
        SinglyNode head;

        while (toAdd != null) {
            head = toAdd.next;
            toAdd.next = destination;
            destination = toAdd;
            toAdd = head;
        }


        return destination;

    }
}
