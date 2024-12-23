import java.util.*;

/**
 * ClassName: PathSum
 * Package: PACKAGE_NAME
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){return false;}
        //创建两个队列 一个存节点，一个存根节点到目前节点的值
        Deque<TreeNode> dequeT = new ArrayDeque<>();
        Deque<Integer> dequeI = new ArrayDeque<>();
        //初始化两个节点
        dequeT.addLast(root);
        dequeI.addLast(root.val);
        //开始遍历
        while(dequeT.isEmpty()){
            TreeNode nowNode = dequeT.pollFirst();//获得目前节点
            int sum = dequeI.pollFirst();//获得目前根节点到次节点的和
            if(nowNode.left==null&&nowNode.right==null){
                if(sum == targetSum){
                    return true;
                }
                continue;
            }
            if(nowNode.left!=null){
                dequeT.addLast(nowNode.left);
                dequeI.addLast(sum+nowNode.left.val);
            }
            if(nowNode.right!=null){
                dequeT.addLast(nowNode.right);
                dequeI.addLast(sum+nowNode.right.val);
            }

        }
        //遍历过程中没有找到想要的结果
        return  false;
    }
}
