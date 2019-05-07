package cn.com.self;

/**
 * Given n non-negative integers a1, a2, ..., an
 * where each represents a point at coordinate (i, ai). n vertical lines are drawn
 * such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * 从0，末尾开始，求每个方块的大小（容积），边小的向里进一位，输出最大容积
 *
 * 2019.5.6 zx
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] test = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater tmp  = new ContainerWithMostWater();
        System.out.println(tmp.maxArea(test));
    }
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0, area;
        while (i < j){
            area = height[i] < height[j] ? (j - i) * height[i++] : (j - i) * height[j--]; //边小的往中间进一位
            max = max > area ? max : area;
        }
        return max;
    }
}
