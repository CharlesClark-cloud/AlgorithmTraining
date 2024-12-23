import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ClassName: SingleNew
 * Package: PACKAGE_NAME
 */
public class SingleNew {
    private  static SingleNew singleNew;
//    private  static  final  SingleNew singleNew = new SingleNew(); 这就是饿汉式  直接创建
    private SingleNew(){}
    public static  synchronized SingleNew getInstance(){
        //直接加锁 线程安全 但效率低
        if(singleNew==null){
            singleNew = new SingleNew();
        }
       return singleNew;
    }
    public  static SingleNew getInstance2(){
        //  双检锁  线程安全 效率高
        if(singleNew == null){
            synchronized (SingleNew.class){
                if(singleNew==null){
                    singleNew = new SingleNew();
                }
            }
        }
        return  singleNew;
    }

    public static void main(String[] args) {
        Integer a=null;
        int b=1;
        a=b;
        Deque<Character> de = new ArrayDeque<>();
        de.add((char) 1);
        System.out.println(de.peekFirst());
        System.out.println(de);
    }
}
