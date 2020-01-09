package co.gofun.java.thread;

/**
 * 两个线程交替执行
 * Created by Ador on 2017/11/22.
 */
public class TwoThreadAlternate {


    public static void main(String[] args) {

        final TwoThreadAlternate twoThreadAlternate = new TwoThreadAlternate();


        new Thread(new Runnable() {
            @Override
            public void run() {
                twoThreadAlternate.print("A");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                twoThreadAlternate.print("B");
            }
        }).start();

    }

    public synchronized void print(String str) {
        int count =0;
        while (count<100) {
            count++;
            System.out.println(str);
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

}
