package co.gofun.java.link;

/**
 * 单链表节点
 */
public class SinglyNode {
    public String node;
    public SinglyNode next;

    public SinglyNode() {

    }

    public SinglyNode(String node) {
        this.node = node;
    }

    public SinglyNode(int node) {
        this.node = node + "";
    }
}
