/**
 * ClassName: IsSameTree
 * Package: PACKAGE_NAME
 */




public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return judge(p,q);

    }
    public boolean judge(TreeNode p, TreeNode q){
        if(p==null&&q==null){
            //都为空时则树到底，中间的值都想同
            return true;
        }
        if(p==null||q==null||p.val!=q.val){
            //一边为空了，那么上一个if没过，说明不一样了。或者值不一样了，错了
            return false;
        }
        //最后返回左右子树是否都相同 相同才返回
        return judge(p.left, q.left) && judge(p.right, q.right);
    }
}
