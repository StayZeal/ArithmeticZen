package co.gofun.java.link;

/**
 * 把单链表逆转
 * 提示：单链表添加节点是加入到头部
 */
public class InverseLink {

    //psvm快捷键
    public static void main(String[] args) {

        SinglyNode mLink = CreateLink.create();
        CreateLink.printLink(mLink);

//        inverse(mLink);

        CreateLink.printLink(recursive(mLink, null));
    }

    /**
     * 非递归方法
     * 把链表存入一个新的链表
     */
    public static void inverse(SinglyNode mLink) {

//        SinglyNode mLink = co.gofun.java.link;

        /**
         * 新链表
         */
        SinglyNode newLink = null;
        /**
         * co.gofun.java.link 剩下的链表
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
     * 递归反转单链表
     *
     * @param remain
     * @param newLink
     * @return
     */
    public static SinglyNode recursive(SinglyNode remain, SinglyNode newLink) {


//        head.next = remain.next;
        if (remain == null) {
            return newLink;
        }

        SinglyNode head = remain.next;//记录剩下的链表
        remain.next = newLink;//remain和剩下的链表断开，next指向新的链表
//        newLink =remain;
        return recursive(head, remain);
    }


}
