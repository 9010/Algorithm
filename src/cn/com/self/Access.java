package cn.com.self;

import java.util.Scanner;

/**
 * 小易准备去拜访他的朋友，他的家在0点，但是他的朋友的家在x点(x > 0)，均在一条坐标轴上。
 * 小易每一次可以向前走1，2，3，4或者5步。问小易最少走多少次可以到达他的朋友的家。
 *
 * 2019.4.24 zx
 */
public class Access {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();

        Access test = new Access();

        System.out.println(test.Step(x));
    }

    public int Step(int x){
        if(x == 0){
            return 0;
        }
        int step;
        if( x%5 != 0) {
            step = x / 5 + 1;
        }
        else{
            step = x / 5;
        }

        return step;
    }
}
