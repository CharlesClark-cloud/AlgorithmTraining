package Test;

import java.util.Random;

/**
 * ClassName: RandomizedSet
 * Package: Test
 */
public class RandomizedSet {
    public int[] data;
    public int realLength = 0;

    public RandomizedSet() {
        data = new int[2*(int)Math.pow(10,5)];
    }

    public boolean insert(int val) {
        for(int i=0;i<realLength;i++){
            if(data[i]==val){
                return false;
            }
        }
        data[realLength] = val;
        realLength++;
        return true;
    }

    public boolean remove(int val) {
        for(int i=0;i<realLength;i++){
            if(data[i]==val){
                for(int j = i;i<realLength-1;j++){
                    int temp = data[i];
                    data[i] = data[i+1];
                    data[i+1] = temp;
                }
                realLength--;
                return true;
            }
        }

        return false;

    }

    public int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(realLength);
        return data[index];

    }
}
