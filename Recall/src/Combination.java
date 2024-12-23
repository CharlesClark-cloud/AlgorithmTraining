import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Combination
 * Package: PACKAGE_NAME
 */
public class Combination {
    // 用于存储所有可能的组合
    List<List<Integer>> listTotal = new ArrayList<>();

    // 回溯函数
    private void backtrack(int n, int k, List<Integer> list, int index) {
        // 当当前组合的长度等于 k 时，将该组合添加到结果中
        if (list.size() == k) {
            listTotal.add(new ArrayList<>(list));
            return;
        }
        // 从 index 开始遍历到 n
        for (int i = index; i <= n; i++) {
            // 将当前元素加入组合
            list.add(i);
            // 递归调用，i+1 作为下一次递归的开始索引
            backtrack(n, k, list, i + 1);
            // 回溯，移除最后一个元素
            list.remove(list.size() - 1);
        }
    }

    // 主函数，生成从 1 到 n 中所有 k 个数的组合
    public List<List<Integer>> combine(int n, int k) {
        // 调用回溯函数
        backtrack(n, k, new ArrayList<Integer>(), 1);
        // 返回结果
        System.out.println(listTotal);
        return listTotal;
    }
    public static void main(String[] args) {
        new Combination().combine(4,2);
    }

}
