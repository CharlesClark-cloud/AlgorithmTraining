import java.util.*;

/**
 * ClassName: LayerPrint
 * Package: PACKAGE_NAME
 */
public class LayerPrint{
    //计算二叉树的每层平均值
    //其实就是二叉树的层序遍历
    public  static  List<Double> averageOfLevels(TreeNode root) {
        //广度优先探索
        List<Double> ansList  = new LinkedList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while(!deque.isEmpty()){
            //证明队列中有值
            int layerSize = deque.size();//表示这层树有几个节点
            double sum = 0;
            for(int i=0;i<layerSize;i++){
                TreeNode currentFirst = deque.pollFirst();//挨个取出第一个节点
                sum+=currentFirst.val;
                //然后将其子节点放入队列
                if(currentFirst.left!=null){
                    deque.add(currentFirst.left);
                }
                if(currentFirst.right!=null){
                    deque.add(currentFirst.right);
                }

            }
            ansList.add(sum/layerSize);
        }
        return ansList;
    }
    public static  List<Double> layerPrintDeepFirst(TreeNode root){
        //深度优先遍历
        List<Integer> counts = new ArrayList<>();
        List<Double> sums = new ArrayList<>();
        int level  = 0;
        dfs(root,level,counts,sums);
        List<Double> ans = new ArrayList<>();
        for (int i = 0; i < counts.size(); i++) {
            ans.add(sums.get(i)/ counts.get(i));
        }
        return  ans;

    }
    public  static  void  dfs(TreeNode root,int level, List<Integer> counts, List<Double> sums){
        if(root == null){
            return;
        }
        if(level<sums.size()){
            // 说明目前所在的层数是已经到达过的层数
            //直接调整counts，然后计入sums。
            counts.set(level,counts.get(level)+1);
            sums.set(level,sums.get(level)+root.val);
        }else{
            //说明目前所到的层数是之前没有到过的
            counts.add(1);
            sums.add(root.val*1.0);
        }
        dfs(root.left,level+1,counts,sums);
        dfs(root.right, level+1, counts, sums);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2147483647);
        root.left = new TreeNode(2147483647);
        root.right = new TreeNode(2147483647);
//        root.left.right=new TreeNode(5);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(4);
//        layerPrint(root);


    }
}