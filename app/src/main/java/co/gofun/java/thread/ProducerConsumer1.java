package co.gofun.java.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Ador on 2017/11/22.
 */
public class ProducerConsumer1 {

    public static final int MAX = 10;
    public Queue<Product> products = new LinkedList<>();

    public static void main(String[] args) {
        new ProducerConsumer1().test();
    }

    public void test() {
        ProducerConsumer1 producerConsumer = new ProducerConsumer1();
        Consumer consumer = new Consumer(producerConsumer.products, MAX);
        Consumer consumer2 = new Consumer(producerConsumer.products, MAX);
        Producer producer = new Producer(producerConsumer.products, MAX);
        Producer producer2 = new Producer(producerConsumer.products, MAX);
        producer.start();
        consumer.start();
//        consumer2.start();
//        producer2.start();
    }


    public class Product {
        String name;
        String num;

        public Product() {
        }

        public Product(String name, String num) {
            this.name = name;
            this.num = num;
        }

        @Override
        public String toString() {
            return name + " : " + num;
        }
    }

    public class Producer extends Thread {

        private final Queue<Product> products;
        private int maxSize;

        public Producer(Queue<Product> products, int maxSize) {
            this.products = products;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {

            while (true) {
                synchronized (products) {
                    if (products.size() >= maxSize) {
                        System.out.println("product pool is full,Producer sleep...");
                        products.notifyAll();
                        try {
                            products.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        produce();
                        products.notifyAll();
                       /* try {
                            products.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/
                    }

                }
            }

        }

        private void produce() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Random random = new Random();
            int num = random.nextInt();

            Product product = new Product("apple", num + "");
            products.add(product);
            System.out.println("Producer" + Thread.currentThread().getName()
                    + " produce a product:" + product.toString());
        }
    }

    public class Consumer extends Thread {

        private final Queue<Product> products;
        private int maxSize;

        public Consumer(Queue<Product> products, int maxSize) {
            this.products = products;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (products) {
                    if (products.size() == 0) {
                        System.out.println("product pool is empty,Consumer sleep...");
                        products.notifyAll();
                        try {
                            products.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        consume();
                        products.notifyAll();
                        /*try {
                            products.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/
                    }

                }
            }
        }

        private void consume() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Product product = products.remove();
            System.out.println("Consumer" + Thread.currentThread().getName()
                    + " consume a product: " + product.toString());
        }
    }
}
