package cn.com.self;

import java.util.Stack;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1
 * compute how much water it is able to trap after raining.
 *
 * 2019.5.27 zx
 *
 * ——————Hard难度——————
 *
 * Discuss里的最多浏览的答案，大概算法：
 *  寻找低谷Valley，将数组push进入栈，当要push的数大于栈顶的数时，假定栈顶的数为一个低谷，
 *  将其pop，如果此时栈为空，那么这不是一个低谷，否则为一个低谷，计算这个低谷和两边高峰的容积
 *
 * 原文： https://leetcode.com/problems/trapping-rain-water/discuss/272443/java-5ms-stack-solution-with-detailed-explanation
 * Apparently, we need two nonadjacent bars to save water, and there must be at least one valley bar between them.
 * For bar[i], if we can find bar[j] and bar[k] where bar[j] > bar[i], bar[k] > bar[i] and j < i < k
 * then bar[i] is a valley bar.
 * For example, if we have a bar sequence [5, 3, 2, 4] then 2 and 3 are both valley bars.
 * Therefore, the key point of this problem is finding all the valley bars.
 * Here, we use a monotone stack to help use finding these valley bars.
 * At first, we ignore the front bars whose length is zero.
 * While bar[i] (current bar) is larger than the top element of the stack
 * then the top element is popped out of the stack as a candidate valley bar.
 * Then we judge whether the stack is empty.
 * If the stack is empty, the popped bar is not a valley bar since we only have right holder (current bar).
 * If the stack is not empty, then the top element, the candidate valley bar and current bar form a valid water holder.
 * The height of the holder is
 *  (Math.min(height[i], height[stack.peek()]) - current) and the width is i - stack.peek() - 1
 *  the holder can hold width * height water.
 */

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        TrappingRainWater tmp = new TrappingRainWater();
        System.out.println(tmp.trap(height));
    }
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int begin = 0, result = 0;
        Stack<Integer> tmp = new Stack<>();
        while(begin < height.length && height[begin] == 0){
            begin++;
        }
        for(int i = begin; i < height.length; i++) {
            while( !tmp.isEmpty() && height[i] > height[tmp.peek()] ) {
                int valley = height[tmp.pop()]; // candidate valley bar
                if( !tmp.isEmpty() ) // If the stack is not empty, then the candidate valley bar is a real valley bar
                    result += (Math.min(height[i], height[tmp.peek()]) - valley) * (i - tmp.peek() - 1);
            }
            tmp.push(i);
        }
        return result;
    }
}
