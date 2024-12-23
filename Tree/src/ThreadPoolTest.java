import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.*;

/**
 * ClassName: ThreadPoolTest
 * Package: PACKAGE_NAME
 */
public class ThreadPoolTest {

    private static  final  Object lock = new Object();
    private  int age =0;

    public static void main(String[] args) {
        BigDecimal price1 = new BigDecimal("10.2");
        BigDecimal price2 = new BigDecimal("10.2");

        // 进行加法运算
        BigDecimal total = price1.add(price2);

        // 输出结果
        System.out.println("总金额: " + total);  // 输出：总金额: 20.4
        BigDecimal b = new BigDecimal("10.2");
        BigDecimal d = new BigDecimal("10.2");
        BigDecimal k = b.add(d);
        System.out.println(k);
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int taskId = i+1;
            threadPool.submit(()->{
                System.out.println("这是第 "+taskId+" 个线程");
                try {
                    TimeUnit.SECONDS.sleep(2);
                }catch (Exception e){
                        Thread.currentThread().interrupt();
                }
            });
            System.out.println("this is complete!");
        }
        threadPool.shutdown();

        try {
            // 等待所有任务执行完毕
            if (!threadPool.awaitTermination(1, TimeUnit.SECONDS)) {
                threadPool.shutdownNow(); // 超时后强制关闭线程池
            }
        } catch (InterruptedException e) {
            threadPool.shutdownNow(); // 线程被中断时，立即关闭线程池
            Thread.currentThread().interrupt(); // 恢复中断状态
        }

        System.out.println("All tasks completed.");
        Object[] a=new Object[]{1,23,4};

        Arrays.sort(a,new Comparator<Object>(){
            @Override
            public int compare(Object o1, Object o2) {
                return Integer.parseInt(o1.toString())-Integer.parseInt(o2.toString());
            }
        });
        for (Object c:
             a) {
            System.out.println(c);

        }
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('c',map.getOrDefault('c',0)+1);
        map.put(null,null);
        ArrayList<Integer> tet = new ArrayList<>();
        int [] a2 = new int[]{};


        ExecutorService et =  new ThreadPoolExecutor(5,Integer.MAX_VALUE,60L,TimeUnit.SECONDS,new LinkedBlockingDeque<>());




    }


}
