package cn.com.self;

import java.util.Scanner;

/**
 * 给定一个N*M的矩阵，在矩阵中每一块有一张牌，我们假定刚开始的时候所有牌的牌面向上。
 * 现在对于每个块进行如下操作：
 * > 翻转某个块中的牌，并且与之相邻的其余八张牌也会被翻转。
 * XXX
 * XXX
 * XXX
 * 如上矩阵所示，翻转中间那块时，这九块中的牌都会被翻转一次。
 * 请输出在对矩阵中每一块进行如上操作以后，牌面向下的块的个数。
 *
 * 超大容量数组 n和m的值最多可以到到1,000,000,000，无法创建这样的数组需要用到其他数据结构
 */
public class Turn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++){
            long n = scanner.nextLong();
            long m = scanner.nextLong();
            int [][] a = new int[(int)n][(int)m];

            for (int x = 0; x < n; x++){
                for (int y = 0; y < m; y++){
                    a[x][y] = 1 - a[x][y];
                    if (x - 1 >= 0){
                        a[x-1][y] = 1 - a[x-1][y];
                    }
                    if (x - 1 >= 0 && y - 1 >= 0){
                        a[x-1][y-1] = 1 - a[x-1][y-1];
                    }
                    if (y - 1 >= 0){
                        a[x][y-1] = 1 - a[x][y-1];
                    }
                    if (x + 1 < n && y - 1 >= 0){
                        a[x+1][y-1] = 1 - a[x+1][y-1];
                    }
                    if (x + 1 < n){
                        a[x+1][y] = 1 - a[x+1][y];
                    }
                    if (y + 1 < m){
                        a[x][y+1] = 1 - a[x][y+1];
                    }
                    if (y + 1 <m && x - 1 >= 0){
                        a[x-1][y+1] = 1 - a[x-1][y+1];
                    }
                    if (y + 1 < m && x + 1 < n){
                        a[x+1][y+1] = 1 - a[x+1][y+1];
                    }
                }
            }
            int sum = 0;
            for (int x = 0; x < n; x++){
                for (int y = 0; y < m; y++){
                    if (a[x][y] == 1){
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
