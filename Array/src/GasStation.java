import java.util.Arrays;

/**
 * ClassName: GasStation
 * Package: PACKAGE_NAME
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum =0;
        int costSum =0;
        for (int i = 0; i < gas.length; i++) {
            gasSum+=gas[i];
            costSum+=cost[i];
        }
        //直接排除肯定不够的情况
        if(costSum>gasSum){
            return  -1;
        }
        int maxSurplus = 0;
        int res = -1;
        boolean flag;
        for (int i = 0; i < gas.length; i++) {
            flag =true;
            int gasSur = 0;
            if(gas[i]>=cost[i]){
                //可以走到下一个节点，可以尝试启动
                int count =0;
                int currentCycle = i;
                while(count<gas.length){
                    int currentStation = currentCycle%gas.length;
                    gasSur+=gas[currentStation];
                    if(gasSur>=cost[currentStation]){
                        gasSur-=cost[currentStation];
                        currentCycle++;
                        count++;
                    }else {
                        i=currentStation;//这行是破解超时的关键，总结一句话就是，你这个节点若是没法走一圈，那么这段路中的任何一个节点都没法走一圈，直接从终点开始
                        flag =false;
                        break;
                    }
                }
                if(flag){
                    res = i;
                    return res;
                }
            }

        }

        return  res;
    }

    public static void main(String[] args) {
//        int[] gas = new int[]{1,2,3,4,5};
//        int [] cost = new int[]{3,4,5,1,2};
//        System.out.println(new GasStation().canCompleteCircuit(gas,cost));
        int[] gas2 = new int[]{2};
        int [] cost2 = new int[]{2};
        System.out.println(new GasStation().canCompleteCircuit(gas2,cost2));

    }
}
