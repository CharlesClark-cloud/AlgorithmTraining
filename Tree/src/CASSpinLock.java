/**
 * ClassName: CASSpinLock
 * Package: PACKAGE_NAME
 */
import java.util.concurrent.atomic.AtomicBoolean;

public class CASSpinLock {
    public  static  final  Object lock = new Object();
    public  static volatile int number = 0;
     static class ThreadOdd extends Thread{
        @Override
        public void run() {
            while(true){
                if(number%2==1&&number<=100){
                    synchronized (lock){
                        if(number<=100){
                            System.out.println("线程1输出： "+number);
                            number++;
                        }

                    }
                }
            }
        }
    }
    static class ThreadEven extends Thread {
        @Override
        public void run() {
            while(true){
                if(number%2==0&&number<=100){
                    synchronized (lock){
                        if(number<=100){
                            System.out.println("线程2输出： "+number);
                            number++;
                        }

                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Thread threadOdd = new Thread(new Runnable(){
            @Override
            public void  run(){
                while(true){
                    if(number%2==1&&number<=100){
                        synchronized (lock){
                            if(number<=100){
                                System.out.println("奇数-线程输出： "+number);
                                number++;
                            }

                        }
                    }else if(number>100) {
                        break;
                    }
                }
            }
        });
        Thread threadEven = new Thread(new Runnable(){
            @Override
            public void  run(){
                while(true){
                    if(number%2==0&&number<=100){
                        synchronized (lock){
                            if(number<=100){
                                System.out.println("偶数-线程输出： "+number);
                                number++;
                                lock.notify();
                            }else {
                                try {
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }

                        }
                    }else  if(number>100){
                        break;
                    }
                }
            }
        });


    threadOdd.start();
    threadEven.start();

    }
}
