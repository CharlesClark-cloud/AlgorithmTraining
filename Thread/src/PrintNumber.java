/**
 * ClassName: PrintNumber
 * Package: PACKAGE_NAME
 */
public class PrintNumber {
    private  final  Object lock = new Object();
    public  static   int number = 0;
    public  void myPrint(){
        Thread oddPrint = new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized(lock){
                    while (number<100){
                        if(number%2==1){
                            System.out.println("Odd"+number);
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
                }

            }
        });
        Thread  evenPrint  = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(lock){
                    while(number<100){
                        if(number%2==0){
                            System.out.println("Even"+number);
                            number++;
                            lock.notify();
                        }else {
                            try {
                                lock.wait();
                            }catch(Exception e){
                                throw new RuntimeException();
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
        new PrintNumber().myPrint();

    }
}
