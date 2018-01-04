package co.gofun.java.thread;

/**
 * 两个线程交替执行
 * Created by Ador on 2017/11/20.
 */
public class ThreadAB2 {
    private static Object LOCK = new Object();
    private static boolean flag = false;

    public static void main(String[] args) {
        Thread A = new Thread() {
            public void run() {
                for (int i = 1; i < 100; i += 2) {
                    synchronized (LOCK) {
                        System.out.println("A " + i);
                        if (!flag) {
                            flag = true;
                            LOCK.notify();// 在这里虽然唤醒了另一个线程b，但锁并没有释放
                            if (i < 100) {
                                try {
                                    LOCK.wait();// 在wait后的瞬间线程b得到锁
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        };

        Thread B = new Thread() {
            public void run() {
                for (int i = 2; i <= 100; i += 2) {
                    synchronized (LOCK) {
                        System.out.println("B " + i);
                        if (flag) {
                            flag = false;
                            LOCK.notify();
                            if (i < 100) {
                                try {
                                    LOCK.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        };

        A.start();
        B.start();
    }
}