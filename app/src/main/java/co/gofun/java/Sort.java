package co.gofun.java;

/**
 * Created by Ador on 2017/11/22.
 */
public class Sort {

    public static int[] datas = {1, 8, 5, 0, 0, 3, 1, 8, 6, 3, 1};

    public static void print() {

        for (int i = 0; i < datas.length; i++) {
            System.out.print(datas[i] + " ");
        }

        System.out.println("");
    }


    public static void print(int index) {

        System.out.print("第" + index + ": ");

        for (int i = 0; i < datas.length; i++) {
            System.out.print(datas[i] + " ");
        }

        System.out.println("");
    }
}
