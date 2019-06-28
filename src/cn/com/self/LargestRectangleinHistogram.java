package cn.com.self;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1
 * find the area of largest rectangle in the histogram.
 *
 * 不能用从左右开始向中间移动的方式来求最大值，因为会丢失一些可能的长方形的情况
 * 只能求每一块与其它块可以组成的最大的长方形的面积
 *
 * 2019.6.28 zx
 */
public class LargestRectangleinHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 2};
        LargestRectangleinHistogram tmp = new LargestRectangleinHistogram();
        System.out.println(tmp.largestRectangleArea(heights));
    }
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int[] lessFromLeft = new int[heights.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[heights.length]; // idx of the first bar the right that is lower than current
        lessFromRight[heights.length - 1] = heights.length;
        lessFromLeft[0] = -1;

        for(int i = 1; i < heights.length; i++){
            int p = i - 1;
            while(p >= 0 && heights[p] >= heights[i]){
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }
        for(int i = heights.length - 2; i >= 0; i--){
            int p = i + 1;
            while(p < heights.length && heights[p] >= heights[i]){
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int area = 0;
        for(int i = 0; i < heights.length; i++){
            area = Math.max(area, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
        return area;
    }
}
