package link;

/**
 * 把单链表逆转
 * Created by Ador on 2017/11/18.
 */
public class InverseLink {

    //psvm快捷键
    public static void main(String[] args) {

        SinglyNode mLink = CreateLink.create();

        inverse(mLink);

        recursive(mLink);
    }

    /**
     * 非递归方法
     * 把链表存入一个新的链表
     *
     * @param link
     */
    public static void inverse(SinglyNode mLink) {

//        SinglyNode mLink = link;

        /**
         * 新链表
         */
        SinglyNode newLink = null;
        /**
         * link 剩下的链表
         */
        SinglyNode leftLink;

        while (mLink != null) {
            leftLink = mLink.next;
            mLink.next = newLink;
            newLink = mLink;
            mLink = leftLink;
        }

        CreateLink.printLink(newLink);

    }

    /**
     * 逆置单链表
     * 递归方法
     *
     * @param link
     */
    public static SinglyNode recursive(SinglyNode link) {

        if (link == null) {
            throw new RuntimeException("parameter can not be null");
        }
        if (link.next == null) {//找到最后一个Node
            return link;
        }

        SinglyNode lastNode = getLastNode(link);
        lastNode.next = link;
        return lastNode;
    }

    private static SinglyNode getLastNode(SinglyNode link) {

        return link;
    }


}
