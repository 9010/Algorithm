package cn.com.self;

import java.util.Scanner;

/**
 * 在一条街上有n幢房子，标号从1到n，两个在标号上相差为1的房子视为相邻，这些房子中有k幢房子已有住户。
 * 现你准备搬入这条街，你能搬入一幢房子的条件是这幢房子没有人住在里面，与此同时由于你非常热爱与邻居进行交流，故而你需要你所入住的房子两边上都有住户。
 * 现要你求最小的可能符合要求的房子数，以及最大的可能符合要求的房子数。
 *
 * Note: 就样例来说，#代表已有住户，-代表空位，这种情况（###---)，没有满足条件的房子，为最小，故输出0
 * 最大的情况为(#-#-#-)，此种情况有二个位置满足条件，为最大，故输出2
 */
public class PlaceToStay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++){
            long n = scanner.nextLong();
            long k = scanner.nextLong();

            if(k == 0 || n == 0 || k == 1){
                System.out.println(0+" "+0);
            }
            else if (k + k - 1 < n){
                System.out.println(0+" "+(k-1));
            }
            else {
                System.out.println(0+" "+(n-k));
            }
        }
    }
}
