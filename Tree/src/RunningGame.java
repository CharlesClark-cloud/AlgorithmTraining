import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;
import java.util.concurrent.*;

/**
 * ClassName: RunningGame
 * Package: PACKAGE_NAME
 */
public class RunningGame {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        FutureTask<Integer> runer1 = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random =new Random();
                int speed = random.nextInt(10)+1;//随机速度
                double length = 100D;
                double finshed = 0D;
                while(finshed<length){
                    finshed+=speed*1.0;
                }
                Thread.sleep((10-speed)*500);
                //完成比赛
                return speed;
            }
        });
        FutureTask<Integer> runer2 = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random =new Random();
                int speed = random.nextInt(1,10)+1;//随机速度
                double length = 100D;
                double finshed = 0D;
                while(finshed<length){
                    finshed+=speed*1.0;
                }
                Thread.sleep((10-speed)*500);
                //完成比赛
                return speed;
            }
        });
        FutureTask<Integer> runer3 = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random =new Random();
                int speed = random.nextInt(1,10)+1;//随机速度
                double length = 100D;
                double finshed = 0D;
                while(finshed<length){
                    finshed+=speed*1.0;
                }
                Thread.sleep((10-speed)*500);
                //完成比赛
                return speed;
            }
        });
        FutureTask<Integer> runer4 = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random =new Random();
                int speed = random.nextInt(1,10)+1;//随机速度
                double length = 100D;
                double finshed = 0D;
                while(finshed<length){
                    finshed+=speed*1.0;
                }
                Thread.sleep((10-speed)*500);
                //完成比赛
                return speed;
            }
        });
        FutureTask<Integer> runer5 = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random =new Random();
                int speed = random.nextInt(1,10)+1;//随机速度
                double length = 100D;
                double finshed = 0D;
                while(finshed<length){
                    finshed+=speed*1.0;
                }
                //完成比赛
                Thread.sleep((10-speed)*500);
                return speed;
            }
        });

        threadPoolExecutor.execute(runer1);
        threadPoolExecutor.execute(runer2);
        threadPoolExecutor.execute(runer3);
        threadPoolExecutor.execute(runer4);
        threadPoolExecutor.execute(runer5);
        //执行任务
        int count = 0;
        boolean r1 = false;
        boolean r2 = false;
        boolean r3 = false;
        boolean r4 = false;
        boolean r5 = false;

        while (true){
            if(runer1.isDone()&&!r1){
                r1=true;
                System.out.println("1");
                System.out.println(runer1.get()+"获取的值");
                count++;
            }
            if(runer2.isDone()&&!r2){
                r2=true;
                System.out.println("2");
                System.out.println(runer2.get()+"获取的值");
                count++;
            }
            if(runer3.isDone()&&!r3){
                r3=true;
                System.out.println("3");
                System.out.println(runer3.get()+"获取的值");
                count++;
            }
            if(runer4.isDone()&&!r4){
                r4=true;
                System.out.println("4");
                System.out.println(runer4.get()+"获取的值");
                count++;
            }
            if(runer5.isDone()&&!r5){
                r5=true;
                System.out.println("5");
                System.out.println(runer5.get()+"获取的值");
                count++;
            }
            if(count==5){
                threadPoolExecutor.shutdown(); // 使用 shutdown 等待任务完成
                if (threadPoolExecutor.awaitTermination(1, TimeUnit.MINUTES)) {
                    System.out.println("All tasks completed");
                } else {
                    System.out.println("Timeout, force shutdown");
                }
                break;
            }

        }




    }


}
