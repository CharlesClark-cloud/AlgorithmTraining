import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * ClassName: SimplifyPath
 * Package: PACKAGE_NAME
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> resStack = new ArrayDeque<>();
        String[] splits = path.split("/");
        for (int i = 0; i < splits.length; i++) {
            if(!splits[i].equals("")&&!splits[i].equals(".")){
                if(splits[i].equals("..")){
                    if(!resStack.isEmpty()){
                        resStack.pop();
                    }
                }else{
                    resStack.push(splits[i]);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!resStack.isEmpty()) {
            res.insert(0, "/" + resStack.pop());
        }
        if (res.length() == 0) {
            res.append("/");
        }
        return res.toString();

    }

    public static void main(String[] args) {
        String path = "/home/";
        String path2 = "/.../a/../b/c/../d/./";

        System.out.println(new SimplifyPath().simplifyPath(path));
    }
}
