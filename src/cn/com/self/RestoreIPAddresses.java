package cn.com.self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * 2019.8.5 zx
 * 一串字符串按照IP地址格式进行分段，要求求出所有可能的分段
 * 求所有可能第一反应DFS，这里复杂在要求数字不能小于0,不能大于255，同时还有一位数、两位数和三位数的区别
 * 还是一个个试，不符合条件就回退
 */
public class RestoreIPAddresses {
    public static void main(String[] args) {
        String s = "200000";
        RestoreIPAddresses tmp = new RestoreIPAddresses();
        System.out.println(tmp.restoreIpAddresses(s).toString());
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res  = new ArrayList();
        if(s == null || s.length() == 0|| s.length() < 4|| s.length() > 12){
            return res;
        }

        helper(res, s, new StringBuilder(), 0, 4);
        return res;
    }

    private void helper(List<String> res, String s ,StringBuilder sb, int pos, int left){  //DFS
        if(pos == s.length() || left == 0){
            if(pos == s.length() && left == 0){  //读到了末尾并且存在达到4段符合条件的数字，存入res中
                res.add(sb.toString());
            }
            return;
        }
        if(left != 4){
            sb.append(".");
        }

        int len = sb.length();
        for(int i = pos + 1; i <= Math.min(pos + 3, s.length()); i++){  //数字最大往后3位，否则到字符串结束
            if(i != pos + 1 && s.charAt(pos) == '0'){  //不能以0开始数字
                break;
            }
            int num = Integer.parseInt(s.substring(pos, i));
            if(num >= 0 && num <= 255){
                sb.append(num);
                helper(res, s, sb, i, left-1);
                sb.setLength(len);
            }
        }
    }

}
