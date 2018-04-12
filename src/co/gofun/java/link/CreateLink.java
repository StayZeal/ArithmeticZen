package co.gofun.java.link;

/**
 * Created by Ador on 2017/11/18.
 * 创建单链表
 */
public class CreateLink {

    static SinglyNode link = null;


    public static void main(String[] args) {

        create();

        printLink(link);

    }

    public static SinglyNode create(int offset, int count) {
        return create(0, offset, count, false);
    }

    /**
     * @param start  开始位置
     * @param offset 间隔
     * @param count  个数
     * @param upper  true :逐渐增大
     * @return
     */
    public static SinglyNode create(int start, int offset, int count, boolean upper) {
        SinglyNode link = null;
        for (int i = 0; i < count; i++) {
            SinglyNode node = new SinglyNode();
            node.node = start + offset * i + "";
            node.next = link;
            link = node;
        }

        if (upper) {
            InverseLink.inverse(link);
        }

        return link;
    }


    public static SinglyNode create() {
        SinglyNode link = null;
        for (int i = 0; i < 100; i++) {
            SinglyNode node = new SinglyNode();
            node.node = i + "";
            node.next = link;
            link = node;
        }

        return link;
    }

    /**
     * 123456(4为环节点)
     *
     * @return
     */
    public static SinglyNode create1() {
        SinglyNode link = null;
        SinglyNode last = new SinglyNode(6);
        last.next = link;
        link = last;
        SinglyNode node = new SinglyNode(5);
        node.next = link;
        link = node;
        node = new SinglyNode(4);
        node.next = link;
        link = node;

        last.next = node;//构造环

        node = new SinglyNode(3);
        node.next = link;
        link = node;
        node = new SinglyNode(2);
        node.next = link;
        link = node;
        node = new SinglyNode(1);
        node.next = link;
        link = node;


        return link;
    }


    public static void printLink(SinglyNode link) {

        SinglyNode node = link;

        System.out.println("co.gofun.java.link start...");
        while (node != null) {
            System.out.print(node.node + " ");
            node = node.next;
        }
        System.out.println("");
        System.out.println("co.gofun.java.link end.");

    }


}
