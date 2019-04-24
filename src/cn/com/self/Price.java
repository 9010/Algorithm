package cn.com.self;

import java.util.Scanner;

/**
 * 你有3个需要完成的任务，完成这3个任务是需要付出代价的。
 * 首先，你可以不花任何代价的完成一个任务；然后，在完成了第i个任务之后，你可以花费|Ai - Aj|的代价完成第j个任务。|x|代表x的绝对值。
 * 计算出完成所有任务的最小代价。
 *
 * 2019.4.24 三个数据，直接强算
 */

public class Price {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] a = new int[3];
        for (int i = 0; i < 3; i++){
            a[i] = scanner.nextInt();
        }
        Price price = new Price();
        System.out.println(price.Price(a));
    }

    public int Price(int [] a){
        int x = Math.abs(a[0] - a[1]);
        int y = Math.abs(a[0] - a[2]);
        int z = Math.abs(a[1] - a[2]);
        int price = x + y;
        if (price > x + z){
            price = x + z;
        }
        if (price > y + z){
            price = y + z;
        }

        return  price;
    }
}
