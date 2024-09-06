/**
 * ClassName: TwoThreadPrintOddAndEven
 * Package: PACKAGE_NAME
 */
public class TwoThreadPrintOddAndEven {
    private static  int number = 1;
    private final Object lock = new Object();
    public  void myPrint(){
        Thread oddPrint = new Thread(new Runnable() {
            @Override
            public void run() {
                while (number<100){
                    synchronized (lock){
                        if(number%2==1){
                            System.out.println(number);
                            number++;
                            lock.notify();
                        }else {
                            try {
                                lock.wait();  // 等待偶数线程完成
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }
        });
        Thread evenPrint = new Thread(new Runnable() {
            @Override
            public void run() {
                while (number<100){
                    synchronized (lock){
                        if(number%2==0){
                            System.out.println(number);
                            number++;
                            lock.notify();
                        }else {
                            try {
                                lock.wait();  // 等待奇数线程完成
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }
        });
        oddPrint.start();
        evenPrint.start();



    }

    public static void main(String[] args) {
        new  TwoThreadPrintOddAndEven().myPrint();
    }
}
