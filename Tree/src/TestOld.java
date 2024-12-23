import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * ClassName: Test
 * Package: PACKAGE_NAME
 */
public class TestOld {
    public  static ThreadLocal<Integer> mylocal = new ThreadLocal<>();
    public  volatile  int x =0;
    List<Integer> nums;
    HashMap<Integer,Integer> map;
    Random random;

    public void RandomizedSet() {
        nums =new ArrayList<>();
        map  = new HashMap<>();
        random  = new Random();
    }

    public boolean insert(int val) {
        //先判断map中是否有
        if(map.get(val)!=null){
            return false;
        }else{
            int index = nums.size();
            nums.add(val);
            map.put(val,index);
            return true;
        }

    }

    public boolean remove(int val) {
        if(map.get(val)==null){
            return false;
        }else{
            int index = map.get(val);
            nums.set(index,nums.indexOf(nums.size()-1));
            nums.remove(nums.size()-1);
            map.remove(val);
            return true;
        }
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));

    }
    public static  void printBinTree(TreeNode root){
        //二叉树 层序遍历
        if(root == null){
            return;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            TreeNode treeNode = deque.poll();
            System.out.println(treeNode.val);
            if(treeNode.left!=null){
                deque.addLast(treeNode.left);
            }
            if(treeNode.right!=null){
                deque.addLast(treeNode.right);
            }
        }
    }
    public static  void printBinTreeInZWay(TreeNode root){
        if(root == null){
            return;
        }
        Deque<TreeNode> oddDeque = new ArrayDeque<>();//正向打印
        Deque<TreeNode> evenDeque = new ArrayDeque<>();//反向打印
        oddDeque.addLast(root);
        int countLayers = 1;
        while(!oddDeque.isEmpty()||!evenDeque.isEmpty()){
            //此时能进来先判断是正向还是反向
            if(countLayers%2!=0){
                //奇数层 正向
                while(!oddDeque.isEmpty()){
                    TreeNode treeNode = oddDeque.pollFirst();
                    System.out.print(treeNode.val);
                    if(treeNode.left!=null){
                        evenDeque.addLast(treeNode.left);
                    }
                    if(treeNode.right!=null){
                        evenDeque.addLast(treeNode.right);
                    }
                }
                System.out.println();
            }else {
                //偶数层 反向
                while(!evenDeque.isEmpty()){
                    TreeNode treeNode = evenDeque.pollLast(); //从右边取
                    System.out.print(treeNode.val);
                    if(treeNode.left!=null){
                        oddDeque.addLast(treeNode.left);
                    }
                    if(treeNode.right!=null){
                        oddDeque.addLast(treeNode.right);
                    }
                }
                System.out.println();

            }
            countLayers++;
        }
    }

    public  static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(res,tempList,nums,used);
        return  res;
    }

    private  static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums,boolean[] used) {
        if(tempList.size()==nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i])continue;
            tempList.add(nums[i]);//当前位置已确定
            used[i] = true;
            backtrack(result,tempList,nums,used);//寻找下一位置可以使用的变量
            tempList.remove(tempList.size()-1);//移除当前答案中的最后一个元素 为回溯做准备
            used[i]=false;//变量使用完 恢复为未使用的状态（回溯）

        }
    }
    public static int calculate(String s) {
        // 一个栈存符号 一个栈存数字且只存正数
        Deque<Character> stackChars = new ArrayDeque<>();
        Deque<List<Integer>> stackNumbers = new ArrayDeque<>();//List长度为2 0处是此数字 1处表示是否是左括号起步位置
        char preSignal = '+';
        for(int i =0;i<s.length();i++){
            char currentChar = s.charAt(i);
            if(currentChar==' '){
                continue;
            }
            if(currentChar=='('){
                //说明此时要开始另一段处理括号内部的内容了
                if(preSignal=='-'){
                    stackChars.addLast('-');
                }else if(preSignal == '+'){
                    stackChars.addLast('+');
                }

            }
            if(Character.isDigit(currentChar)){
                //证明是数字
                //判断前面是否是左括号
                if(preSignal=='('){
                    //此数字要带上标志符
                    List<Integer> insertList = new ArrayList();
                    insertList.add((int)(currentChar-'0'));
                    insertList.add(1);
                    stackNumbers.addLast(insertList);
                    stackChars.add('+');
                }
                if(Character.isDigit(preSignal)){
                    //上一位也是数字
                    List<Integer> insertList = stackNumbers.pollLast();
                    int number = insertList.get(0)>0?insertList.get(0)*10+(int)(currentChar-'0'):insertList.get(0)*10-(int)(currentChar-'0');
                    insertList.set(0,number);
                    stackNumbers.addLast(insertList);
                }
                if(preSignal == '-'){
                    //减 直接添负数
                    List<Integer> insertList = new ArrayList();
                    insertList.add(-(int)(currentChar-'0'));
                    insertList.add(0);
                    stackNumbers.addLast(insertList);
                    stackChars.addLast('-');
                }
                if(preSignal == '+'){
                    //减 直接添负数
                    List<Integer> insertList = new ArrayList();
                    insertList.add((int)(currentChar-'0'));
                    insertList.add(0);
                    stackNumbers.addLast(insertList);
                    stackChars.addLast('+');
                }
            }
            if(currentChar==')'){
                //上一个肯定是数字
                List<Integer> getList = stackNumbers.pollLast();
                char fuhao = stackChars.pollLast();
                int currSum = 0;
                while(getList.get(1)==0){
                    if(fuhao=='-'){
                        currSum-=getList.get(0);
                    }else {
                        currSum+=getList.get(0);
                    }

                    if(!stackNumbers.isEmpty()){
                        getList = stackNumbers.pollLast();
                        fuhao = stackChars.pollLast();
                    }else {
                        break;
                    }
                }

                getList.set(1,0);
                stackNumbers.addLast(getList);
            }

            preSignal = currentChar;
        }
        //此时stackNumbers 求和即可
        int ans = 0;
        while(!stackNumbers.isEmpty()){
            List<Integer> currList = stackNumbers.pollLast();
            ans+=currList.get(0);
        }
        return ans;


    }
    public static boolean canJump(int[] nums) {

        int maxPositon = 0;
        for(int i = 0;i<nums.length;i++){
//            if(nums[i]+i>=nums.length-1){
//                return  true;
//            }
            for(int j = i;j<=nums[i]+i&&j<nums.length;j++){
                //判断当前所能走到的最大位置
                if(nums[j]+j>=maxPositon){
                    maxPositon = nums[j]+j;
                    i = j;
                }
                if(nums[j]+j>=nums.length-1){
                    return  true;
                }
            }
            if(nums[i]==0&&i!=nums.length-1){
                return  false;
            }
        }
        if(maxPositon>=nums.length-1){
            return  true;
        }
        return  false;
    }
    public static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if(k==1){
            return true;
        }

        List<Integer> indexesOfStart = new ArrayList<>();
        for(int i = 0;i<=nums.size()-k;i++){
            boolean flag = true;
            for(int j = i;j<i+k-1;j++){
                if(nums.get(j)>=nums.get(j+1)){
                    flag =false;
                }
            }
            if(flag){
                indexesOfStart.add(i);
            }
        }
        System.out.println(indexesOfStart.size());

        for(int i=0;i<indexesOfStart.size();i++){
            System.out.println(indexesOfStart.get(i));
            for(int j = i;j<=i+k&&j<indexesOfStart.size();j++){
                if(indexesOfStart.get(i)+k==indexesOfStart.get(j)){
                    return true;
                }
            }
        }
        return false;


    }
    public static int hasIncreasingSubarrays2(List<Integer> nums) {
       int maxK = 1;
        int [] ks = new int[nums.size()];
        Arrays.fill(ks,1);
        List<Integer> indexesOfStart = new ArrayList<>();
        for(int i = 0;i<=nums.size();i++){
            boolean flag = true;
            int currentK = 1;
            for(int j = i;j<nums.size()-1;j++){
                if(nums.get(j)<nums.get(j+1)){
                    currentK++;
                }else {
                    break;
                }
            }
            for(int q = i;q<currentK+i&&q<nums.size();q++){
                ks[q] = currentK;
                currentK--;
            }
        }
        System.out.println();
        for(int i=0;i<ks.length;i++){
            System.out.print(ks[i] +" ");
        }
        System.out.println();
        int max = findLongestSameGrowth(ks);

        return max;


    }
    public static int findLongestSameGrowth(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        List<Integer> lengths = new ArrayList<>(); // 存储每个连续递减区间的长度
        int count = 1;

        // 计算每个递减区间的长度
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] - 1) {
                count++;
            } else {
                lengths.add(count);
                count = 1; // 重置计数
            }
        }
        lengths.add(count); // 添加最后一个区间长度

        // 找出最长的相同递增长度的相邻区间
        int maxSameLength = 1; // 存储最大相邻区间重复次数
        int currentCount = 1;

        for (int i = 1; i < lengths.size(); i++) {
            if (lengths.get(i).equals(lengths.get(i - 1))) {
                currentCount++;
            } else {
                maxSameLength = Math.max(maxSameLength, currentCount);
                currentCount = 1;
            }
        }
        maxSameLength = Math.max(maxSameLength, currentCount); // 处理最后一组相同长度的区间

        return maxSameLength;
    }


    public static void main(String[] args) {
//
//        int[] nums = {1, 2, 3};
//        List<List<Integer>> result = permute(nums);
//        List<Character> r = new ArrayList<>();
//        r.add('a');
//        r.add('b');
//        StringBuffer sv = new StringBuffer();
//        Deque<Integer> deque = new ArrayDeque<>();
//        List<Integer> insertList = new ArrayList(2);
//
//
//        System.out.println(r.toString());
////        System.out.println(result);
//        System.out.println(calculate("1-(     -2)"));

        int[] nums = new int[]{2,3,-2,-1};
        int k = 3;
        List<Integer> list = new ArrayList<>();

        // 添加元素到列表
        list.add(2);
        list.add(5);
        list.add(7);
        list.add(11);
//        list.add(9);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(3);
//        list.add(1);
        System.out.println(hasIncreasingSubarrays2(list));
        StringBuffer sbf = new StringBuffer();
        StringBuilder sbb = new StringBuilder();
       ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap<>();
       map.put(1,1);
        AtomicInteger atomicCounter = new AtomicInteger(0);
        atomicCounter.incrementAndGet();  // 使用 CAS 原子地增加计数
        HashSet<Integer> objects = new HashSet<>();
        

    }
}
