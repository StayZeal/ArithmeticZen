//package co.gofun.java.thread;
//
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//import java.util.Random;
//
///**
// * Created by Ador on 2017/11/22.
// */
//public class ProducerConsumer {
//
//    public Queue<Product> products = new LinkedList<>();
//
//    public static void main(String[] args) {
//
//
//        ProducerConsumer producerConsumer = new ProducerConsumer();
//        producerConsumer.products = null;
//        Consumer consumer = new  Consumer(producerConsumer.products,100);
//
////        Producer producer = new Producer(producerConsumer.products, 100);
//
//
//    }
//
//
//
//    public class Product {
//        String name;
//        String num;
//
//        public Product() {
//        }
//
//        public Product(String name, String num) {
//            this.name = name;
//            this.num = num;
//        }
//
//        @Override
//        public String toString() {
//            return name + " : " + num;
//        }
//    }
//
//    public  class Producer extends Thread {
//
//        private Queue<Product> products;
//        private int maxSize;
//
//        public Producer(Queue<Product> products, int maxSize) {
//            this.products = products;
//            this.maxSize = maxSize;
//        }
//
//        @Override
//        public void run() {
//
//            while (true) {
//                synchronized (products) {
//                    if (products.size() == maxSize) {
//                        System.out.println("product pool is full,Producer sleep...");
//                        products.notify();
//                        try {
//                            products.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    Product product = produce();
//                    products.add(product);
//                    System.out.println("Producer produce a product:" + product.toString());
//                }
//            }
//
//        }
//
//        public Product produce() {
//
//            Random random = new Random();
//            int num = random.nextInt();
//            return new Product("apple", num + "");
//
//        }
//
//
//    }
//
//    public class Consumer extends Thread {
//
//
//        private Queue<Product> products;
//        private int maxSize;
//
//        public Consumer(Queue<Product> products, int maxSize) {
//            this.products = products;
//            this.maxSize = maxSize;
//        }
//
//        @Override
//        public void run() {
//            while (true) {
//                synchronized (products) {
//                    if (products.size() == 0) {
//
//                        System.out.println("product pool is empty,Consumer sleep...");
//                        products.notify();
//                        try {
//                            products.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//
//                        consume();
//                    }
//                }
//            }
//        }
//
//        public void consume() {
//
//            Product product = products.remove();
//
//            System.out.println("Consumer consume a product: " + product.toString());
//        }
//    }
//}
