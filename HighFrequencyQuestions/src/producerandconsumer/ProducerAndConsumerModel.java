package producerandconsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 程大昂
 * @ClassName: ProducerAndConsumerModel
 * @Description:
 * @date: 2024/12/24
 */
public class ProducerAndConsumerModel {
    private static final int MAX_SIZE = 5; // 队列最大容量
    private final Queue<Integer> queue = new LinkedList<>(); // 共享资源
    private final Object lock = new Object(); // 锁对象

    // 生产者方法
    public void produce() {
        int value = 0;
        while (true) {
            synchronized (lock) {
                // 如果队列已满，等待
                while (queue.size() == MAX_SIZE) {
                    try {
                        System.out.println("Producer waiting, queue is full.");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 添加资源到队列
                queue.offer(value);
                System.out.println("Produced: " + value);
                value++;
                // 唤醒消费者
                lock.notify();
            }
        }
    }

    // 消费者方法
    public void consume() {
        while (true) {
            synchronized (lock) {
                // 如果队列为空，等待
                while (queue.isEmpty()) {
                    try {
                        System.out.println("Consumer waiting, queue is empty.");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 从队列中消费资源
                int value = queue.poll();
                System.out.println("Consumed: " + value);
                // 唤醒生产者
                lock.notify();
            }
        }
    }
    public static void main(String[] args) {
        ProducerAndConsumerModel pc = new ProducerAndConsumerModel();
        Thread producer = new Thread(() -> pc.produce());//lamda表达式写法
        //等价于 Thread producer = new Thread(new Runnable() {
        // @Override
        // public void run(){
        //    pc.produce();
        // }
        // });

        Thread consumer = new Thread(() -> pc.consume());

        producer.start();
        consumer.start();
    }




}
