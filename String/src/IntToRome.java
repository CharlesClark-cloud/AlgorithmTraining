import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: IntToRome
 * Package: PACKAGE_NAME
 */
public class IntToRome {
    public String intToRoman(int num) {
        int values[]=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String reps[]= new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        String res = "";
        for(int i=0; i<13; i++){
            while(num>=values[i]){
                num -= values[i];
                res += reps[i];
            }
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(new IntToRome().intToRoman(49));
    }
}
