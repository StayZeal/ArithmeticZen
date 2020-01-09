package co.gofun.java.sort;

import co.gofun.java.Sort;

public class MaoPaoSort extends Sort {

    public static void main(String[] args) {

        sort();
    }


    public static void sort() {

        int count = datas.length;

        // 是否发生了数据交换
        boolean flag = false;

        for (int i = 0; i < count - 1; i++) {
            System.out.println("第" + (i + 1) + "轮");
            flag = false;
            for (int j = 0; j < count - 1 - i; j++) {
                if (datas[j] > datas[j + 1]) {
                    int temp = datas[j];
                    datas[j] = datas[j + 1];
                    datas[j + 1] = temp;

                    flag = true;
                }

                print(j + 1);
            }

            if (!flag) {
                return;
            }


        }
    }

}
