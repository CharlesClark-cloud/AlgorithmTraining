import java.util.*;

/**
 * ClassName: LayerPrint
 * Package: PACKAGE_NAME
 */
public class LayerPrint{
    //计算二叉树的每层平均值
    //其实就是二叉树的层序遍历
    public  static  List<Double> averageOfLevels(TreeNode root) {
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


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2147483647);
        root.left = new TreeNode(2147483647);
        root.right = new TreeNode(2147483647);
//        root.left.right=new TreeNode(5);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(4);
        layerPrint(root);


    }
}