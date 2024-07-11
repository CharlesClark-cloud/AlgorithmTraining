import java.util.HashMap;

/**
 * ClassName: SameStructureStr
 * Package: PACKAGE_NAME
 */
public class SameStructureStr {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> s2t = new HashMap<>();
        HashMap<Character,Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
           char x = s.charAt(i) ,y=t.charAt(i);
           if((s2t.containsKey(x)&&s2t.get(x)!=y)||(t2s.containsKey(y)&&t2s.get(y)!=x)){
               return  false;
           }
           s2t.put(x,y);
           t2s.put(y,x);
        }
        return  true;


    }

    public static void main(String[] args) {
        String s = "abb";
        String t = "egg";
        System.out.println(new SameStructureStr().isIsomorphic(s, t));
    }

}
