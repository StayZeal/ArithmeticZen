package co.gofun.java.thread;

/**
 * 两个线程交替执行
 * Created by Ador on 2017/11/20.
 */
public class ThreadAB1 {
    Thread A = new Thread(new Runnable() {
        public void run() {
            for (int i = 1; i < 100; i += 2) {
                print("A " + i);
            }
        }
    });
    Thread B = new Thread(new Runnable() {
        public void run() {
            for (int i = 2; i <= 100; i += 2) {
                print("B " + i);
            }
        }
    });

//    Thread C = new Thread(new Runnable() {
//        @Override
//        public void run() {
//           while (true){
//               print("C");
//           }
//        }
//    });

    private synchronized void print(String str) {
        notify();
        System.out.println(str);
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadAB1 instance = new ThreadAB1();
        instance.A.start();
        instance.B.start();
//        instance.C.start();
    }
}
