import java.util.Arrays;

/**
 * ClassName: HIndex
 * Package: PACKAGE_NAME
 */
public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = citations.length-1;
        int h =0;
        while(i>=0&&citations[i]>h){
            h++;
            i--;
        }
        return h;

    }
}
