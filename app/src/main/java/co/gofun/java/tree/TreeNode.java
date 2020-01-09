package co.gofun.java.tree;

/**
 * Created by Ador on 2017/11/19.
 */
public class TreeNode<T> {

    public T data;
    public T parent;


    public TreeNode(T data, T parent) {
        this.data = data;
        this.parent = parent;
    }
}
