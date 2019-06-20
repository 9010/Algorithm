package cn.com.self;

/**
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * 2019.6.20 zx
 * 二进制相加，由于长度过大，不能转成十进制加完再转二进制
 * 需要直接利用字符串操作
 * 此算法速度和空间都很差，需要寻找更优解
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        AddBinary tmp = new AddBinary();
        System.out.println(tmp.addBinary(a, b));
    }
    public String addBinary(String a, String b) {
        int len1 = a.length() - 1;
        int len2 = b.length() - 1;
        boolean plus =false;
        StringBuilder res = new StringBuilder();
        for(; len1 >=0 && len2 >=0; len1--, len2--){
            if(a.charAt(len1) == '1' && b.charAt(len2) == '1' && !plus){
                plus = true;
                res.append('0');
            }
            else if( ((a.charAt(len1) == '0' &&  b.charAt(len2) == '1')
                    || (a.charAt(len1) == '1' && b.charAt(len2) == '0')) && !plus){
                res.append('1');
                plus = false;
            }
            else if( ((a.charAt(len1) == '0' &&  b.charAt(len2) == '0')
                    || (a.charAt(len1) == '0' && b.charAt(len2) == '0')) && !plus){
                res.append('0');
                plus = false;
            }
            else if(a.charAt(len1) == '1' && b.charAt(len2) == '1' && plus){
                plus = true;
                res.append('1');
            }
            else if( ((a.charAt(len1) == '0' &&  b.charAt(len2) == '1')
                    || (a.charAt(len1) == '1' && b.charAt(len2) == '0')) && plus){
                plus = true;
                res.append('0');
            }
            else if( ((a.charAt(len1) == '0' &&  b.charAt(len2) == '0')
                    || (a.charAt(len1) == '0' && b.charAt(len2) == '0')) && plus){
                plus = false;
                res.append('1');
            }
        }

        while(len1 >= 0){
            if(plus && a.charAt(len1) == '1'){
                res.append('0');
                plus = true;
            }
            else if(plus && a.charAt(len1) == '0'){
                res.append('1');
                plus =false;
            }
            else if(!plus) {
                res.append(a.charAt(len1));
            }
            len1--;
        }
        while(len2 >= 0){
            if(plus && b.charAt(len2) == '1'){
                res.append('0');
                plus = true;
            }
            else if(plus && b.charAt(len2) == '0'){
                res.append('1');
                plus =false;
            }
            else if(!plus) {
                res.append(b.charAt(len2));
            }
            len2--;
        }
        if(plus){
            res.append('1');
        }
        res.reverse();
        return res.toString();
    }
}
