import org.w3c.dom.Node;

import java.util.*;

/**
 * ClassName: LRUCache
 * Package: PACKAGE_NAME
 */
public class LRUCache {
    class  ListNode{
        int key;
        int value;
        ListNode prev;
        ListNode next;
        ListNode(){

        }
        ListNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    //此map存放的key 是对应的key，value 是存放的对应的双向链表节点
    HashMap<Integer,ListNode> map = new HashMap<>();
    int capacity = 0;
    int count  = 0;
    ListNode head;
    ListNode tail;
     LRUCache(int capacity){
         //初始化
         this.capacity = capacity;
         head = new ListNode();
         tail = new ListNode();
         head.next = tail;
         tail.prev = head;
     }
    public int get(int key) {
         if(map.get(key)==null){
             return -1;
         }
         ListNode node = map.get(key);
         moveNodeToHead(node);
         return node.value;
    }
    public void addNode(ListNode node){
         //LRU 只要是添加节点 一定是添加到第一个
         node.next = head.next;
         node.prev = head;
         head.next.prev = node;
         head.next = node;
    }

    public void put(int key, int value) {
//         首先查询是否有此节点
        if(map.get(key)==null){
            //没有此节点 进行插入
            ListNode node = new ListNode(key,value);
            if(count==capacity){
                //容量不够去除最后一个节点 然后添加
                removeTailNode();
            }
            map.put(key,node);
            addNode(node);
            count++;
        }else{
//            已经有了此节点 需要进行更改并将节点移动到头部
            ListNode node  = map.get(key);
            node.value = value;
            moveNodeToHead(node);
        }


    }
    public void removeNode(ListNode node){
         map.remove(node.key);
         //在map中移除此节点
        //因为node是地址所以可以直接操作
        node.prev.next = node.next;
        node.next.prev = node.prev;
        count--;
    }
    public ListNode  removeTailNode(){
         ListNode res = tail.prev;
//         移除一个节点
        removeNode(res);
        return res;
    }
    public  void  moveNodeToHead(ListNode node){
         node.prev.next = node.next;
         node.next.prev = node.prev;
         addNode(node);
    }


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }


}
