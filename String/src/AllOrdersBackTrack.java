import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: AllOrdersBackTrack
 * Package: PACKAGE_NAME
 */
public class AllOrdersBackTrack {

    public static String[] goodsOrder(String goods) {
        List<String> res = new ArrayList<>();
        char[] chars = goods.toCharArray();
        //有重复的 要排序
        Arrays.sort(chars);
        boolean[] used = new boolean[goods.length()];
        backtrack(res,new StringBuffer(),chars,used);
        char[] charArray = res.get(0).toCharArray();

        return res.toArray(new String[0]);


    }
    public static void backtrack(List<String> res,StringBuffer currRes,char[] chars,boolean[] used){
        if(currRes.length()==chars.length){
            res.add(currRes.toString());

            return ;
        }
        for(int i=0;i<chars.length;i++){
            if(used[i]||i>0&&chars[i]==chars[i-1]&&!used[i-1]) continue;
            used[i] = true;
            currRes.append(chars[i]);
            backtrack(res,currRes,chars,used);
            currRes.deleteCharAt(currRes.length()-1);
            used[i] = false;
        }

    }

    public static void main(String[] args) {
        String test = "agew";
        System.out.println(goodsOrder(test));
        StringBuilder sv = new StringBuilder();


    }
}
