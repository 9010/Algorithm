package cn.com.self;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * 2019.6.11 zx
 * 判断两个数组，每个数组前后数字大小（每个数字都要比对一下），分两种情况
 *      r[0]<=iv[1] && r[1]>=iv[0]) || (iv[0]<=r[1] && iv[1]>=r[0])
 * 两种情况都需要进行合并操作，并且合并完成要把之前的合并项删除，还会用到迭代器Iterator
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        MergeIntervals tmp = new MergeIntervals();
        int[][] result = tmp.merge(intervals);
        for(int i = 0; i < result.length; i++){
            System.out.print("[" + result[i][0] + "," + result[i][1] + "]");
            System.out.println();
        }
    }
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int[0][];
        List<List<int[]>> dp = new ArrayList<>();
        List<int[]> list1 = new ArrayList<>();
        list1.add(intervals[0]);
        dp.add(list1);

        for(int i=1; i<intervals.length; i++){
            List<int[]> l = new ArrayList<>(dp.get(i-1));
            Iterator<int[]> it = l.iterator();
            int[] r = intervals[i];
            while(it.hasNext()){
                int[]iv = it.next();
                if((r[0]<=iv[1] && r[1]>=iv[0]) || (iv[0]<=r[1] && iv[1]>=r[0]) ){
                    r[0] = Math.min(iv[0], r[0]);
                    r[1] = Math.max(iv[1], r[1]);
                    it.remove();
                }
            }
            l.add(r);
            dp.add(l);
        }

        int[][] ret = new int[dp.get(intervals.length-1).size()][];
        return dp.get(intervals.length-1).toArray(ret);
    }
}
