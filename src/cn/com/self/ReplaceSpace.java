package cn.com.self;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 2019.4.1 zx
 * 相对而言相当简单，注意StringBuffer的用法，另外Stringbuffer线程安全。
 */

public class ReplaceSpace {
    public static void main(String[] args) {
        StringBuffer test = new StringBuffer("We Are Happy.");
        ReplaceSpace replaceSpace = new ReplaceSpace();

        String result = replaceSpace.replaceSpace(test);

        System.out.println(result);
    }

    public String replaceSpace(StringBuffer str) {
        String replace = "%20";
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                str.replace(i, i+1, replace);
            }
        }

        return str.toString();
    }

}
