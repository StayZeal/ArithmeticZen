package co.gofun.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 约瑟夫环问题
 * 例如：n个人1-3报数，第3个人出去，从1开始。
 * Created by Ador on 2017/11/22.
 */
public class Josephus {

    public static void main(String[] args) {

        ArrayList<Integer> datas = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        hhh(2, 4, datas);


    }

    /**
     * @param start 开始的位置
     * @param key   第k个数要出去
     * @param array 数据
     */
    private static void hhh(int start, int key, ArrayList<Integer> array) {

        int count = array.size();

        while (count > 1) {

//            System.out.println("size: "+array.size());

//            int remove = (start + key - 1) % array.size();
            int remove = (start + key - 1) % count;
            int data = array.remove(remove);
            System.out.print(data+" ");
//            System.out.println(data);
            start = remove;
            count--;
        }

        System.out.println(array.get(0));

    }

}
