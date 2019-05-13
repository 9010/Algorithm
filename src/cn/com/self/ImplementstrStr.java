package cn.com.self;

/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * 2019.5.13 zx
 * 判断是否存在子字符串，算法时间复杂度很高.
 */

public class ImplementstrStr {
    public static void main(String[] args) {
        ImplementstrStr tmp = new ImplementstrStr();
        String haystack = "a";
        String neddle = "a";
        System.out.println(tmp.strStr(haystack, neddle));
    }
    public int strStr(String haystack, String needle) {
        if(needle.equals("")){
            return 0;
        }
        for(int i = 0; i <= haystack.length() - needle.length(); i++){  //修改i的上限可以从291ms时间减少到3ms...也是没话讲
            int k = i;
            for(int j = 0; j < needle.length(); j++){
                if(haystack.charAt(k) == needle.charAt(j)){
                    if(j == needle.length() - 1){
                        return i;
                    }
                    if(k + 1 < haystack.length()){
                        k++;
                    }
                    else {
                        break;
                    }
                }
                else {
                    break;
                }
            }
        }
        return -1;
    }

    //低时间复杂度算法
//    public int strStr(String haystack, String needle) {
//        int l1 = haystack.length();
//        int l2 = needle.length();
//        for (int i = 0, j; i <= l1 - l2 ; i++) {
//            for (j = 0; j < l2 && needle.charAt(j) == haystack.charAt(i + j); j++);
//            if (j == l2) return i;
//        }
//        return -1;
//    }
}
