package cn.com.self;


import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 2019.4.11 zx
 * 注意转换就行，算法不难
 */
public class reOrderArray {
    public static void main(String[] args) {
        int [] array = {1, 2, 7, 12, 25, 455, 90};
        reOrderArray reOrderArray = new reOrderArray();
        reOrderArray.reOrder(array);
    }

    public void reOrder(int [] array) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            if ( (array[i] % 2) == 0){
                even.add(array[i]);
            }
            else {
                odd.add(array[i]);
            }
        }
        odd.addAll(odd.size(), even);
        for (int i = 0; i < odd.size(); i++){
            array[i] = odd.get(i);
        }
    }
}
