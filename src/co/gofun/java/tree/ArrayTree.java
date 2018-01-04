package co.gofun.java.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 用数组存储Tree
 * Created by Ador on 2017/11/19.
 */
public class ArrayTree<T> {

    private static int DEFAULT_SIZE = 100;

    Node<T>[] tree;

    private int treeSize;

    private int index = 0;

    /**
     * 指定根节点
     *
     * @param data
     */
    public ArrayTree(T data) {

        treeSize = DEFAULT_SIZE;
        tree = new Node[treeSize];

        tree[0] = new Node(data, -1);
        index++;
    }

    public List<Node<T>> getChildren(T parent) {

        List<Node<T>> children = new ArrayList<>();

        for (int i = 0; i < index; i++) {

            if (tree[i].data.equals(parent)) {
                children.add(tree[i]);
            }

        }

        return children;
    }


    public void addNode(T data, Node parent) {

        for (int i = 0; i < treeSize; i++) {

            if (tree[i] != null) {
                tree[i] = new Node<T>(data, getParentIndex(parent));
                index++;
                return;
            }
        }

        throw new RuntimeException("co.gofun.java.tree 已经满了，无法再放置节点");
    }

    /**
     * -1代表未找到父节点
     *
     * @param parent
     * @return
     */
    private int getParentIndex(Node parent) {

        for (int i = 0; i < index; i++) {
            if (tree[i].data.equals(parent.data)) {
                return i;
            }
        }

        return -1;
    }


    public static ArrayTree getArrayTree() {


        return null;
    }


    public static class Node<T> {
        T data;
        /**
         * 记录父节点在数组中的位置
         */
        int parent;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, int parent) {
            this.data = data;
            this.parent = parent;
        }
    }

}
