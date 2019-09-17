package cn.com.self;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas
 * to travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index
 * if you can travel around the circuit once in the clockwise direction,
 * otherwise return -1.
 *
 * Explain:
 * The algorithm is pretty easy to understand.
 * Imagine we take a tour around this circle,
 * the only condition that we can complete this trip is to have more fuel provided than costed in total.
 * That's what the first loop does.
 *
 * If we do have more fuel provided than costed,
 * that means we can always find a start point around this circle
 * that we could complete the journey with an empty tank.
 * Hence, we check from the beginning of the array,
 * if we can gain more fuel at the current station,
 * we will maintain the start point, else,
 * which means we will burn out of oil before reaching to the next station,
 * we will start over at the next station.
 *
 * 注意：从i站点到i+1站点，消耗量是cost[i]，例如从0站点到1站点，消耗cost[0]数量的gas
 *
 * 解释：
 * 首先：查看所有的gas是否大于cost，如果所有的gas小于cost，那么肯定走不完一圈
 * 第二：选定一个起始点，如果从这一点开始，我们需要消耗完后的gas始终 >= 0，那么我们可以继续走下去，否则就不行
 *
 *
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        GasStation tmp = new GasStation();
        System.out.println(tmp.canCompleteCircuit(gas, cost));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //首先检查总的gas是否大于cost
        int tank = 0;
        for(int i = 0; i < gas.length; i++){
            tank += gas[i] - cost[i];
        }
        if(tank < 0){
            return -1;
        }

        int start = 0;
        int accumulate = 0;
        for(int i = 0; i < gas.length; i++){
            int curGain = gas[i] - cost[i];
            if(accumulate + curGain < 0){
                start = i + 1;
                accumulate = 0;
            }
            else accumulate += curGain;
        }

        return start;
    }
}
