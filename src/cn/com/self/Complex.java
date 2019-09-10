package cn.com.self;

import java.util.Scanner;

public class Complex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        int[] result1 = getReal(a);
        int[] result2 = getReal(b);

        int real1 = result1[0];
        int image1 = result1[1];
        int real2 = result2[0];
        int image2 = result2[1];

        int newReal = real1*real2 - image1*image2;
        int newImage = image1*real2 + real1*image2;

        String result = "";

        if (newImage > 0) {
             result = newReal + "+" + newImage + "i";
        } else if (newImage == 0) {
             result = String.valueOf(newReal);
        } else if (newImage < 0) {
            newImage = -newImage;
             result = newReal + "-" + newImage + "i";
        }

        System.out.println(result);
    }

    static public int[] getReal(String a){
        int[] result = new int[2];
        StringBuilder sb = new StringBuilder();
        int i;
        int isF = 1;
        boolean flag = false;
        for(i = 0; i < a.length(); i++){
            sb.append(a.charAt(i));
            if(a.charAt(i) == '+'){
                sb.deleteCharAt(sb.length() - 1);
                if(sb.length() != 0) {
                    int real = Integer.valueOf(sb.toString());
                    result[0] = real;
                }
                else {
                    result[0] = 0;
                }
                sb = new StringBuilder();
                flag = true;
            }
            if(a.charAt(i) == '-'){
                isF = -1;
                sb.deleteCharAt(sb.length() - 1);
                if(sb.length() != 0) {
                    int real = Integer.valueOf(sb.toString());
                    result[0] = real;
                }
                else {
                    result[0] = 0;
                }
                sb = new StringBuilder();
                flag = true;
            }
            if(i == a.length() - 1){
                if(a.charAt(i) == 'i'){
                    sb.deleteCharAt(sb.length() - 1);
                    if(!flag) {
                        result[0] = 0;
                    }
                    if(sb.length() != 0){
                        int image = (int) Integer.valueOf(sb.toString()) * isF;
                        result[1] = image;
                    }
                    else{
                        result[1] = 1;
                    }
                }
                else{
                    int real = (int) Integer.valueOf(sb.toString());
                    result[0] = real;
                    result[1] = 0;
                }
            }
        }
        return result;
    }
}
