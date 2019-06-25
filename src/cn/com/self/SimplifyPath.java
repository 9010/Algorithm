package cn.com.self;

/**
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 * In a UNIX-style file system, a period . refers to the current directory.
 * Furthermore, a double period .. moves the directory up a level.
 * For more information, see: Absolute path vs relative path in Linux/Unix
 * Note that the returned canonical path must always begin with a slash /
 * and there must be only a single slash / between two directory names.
 * The last directory name (if it exists) must not end with a trailing /.
 * Also, the canonical path must be the shortest string representing the absolute path.
 *
 * 2019.6.25 zx
 * Discussion Answer：
 *  First to first, there is no stack or deque used in my solution.
 *  The only thing I did is just to transfer original string into char array.
 *  My idea is:
 *  Key: Use a counter to count how many times ".." appears before we handle a normal string of part of the path.
 *  1、go through the char array from end to start
 *  2、ignore all '/' characters
 *  3、get string between '/'
 *  4、handle this string in 4 branches:
 *      4.a if it is empty or equals to ".", do nothing
 *      4.b if it is equals to "..", counter++
 *      4.c if the counter is greater than 0, then counter--
 *      4.d else ( counter == 0) do concatenation of result with current part of path.
 */
public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/../";
        SimplifyPath tmp = new SimplifyPath();
        System.out.println(tmp.simplifyPath(path));
    }
    public String simplifyPath(String path) {
        StringBuilder res = new StringBuilder();
        int i = path.length() - 1;
        int count = 0;
        while(i >= 0){
            int j = i;
            while(j >= 0 && path.charAt(j) == '/'){
                j--;
            }
            int k = j;
            while(k >= 0 && path.charAt(k) != '/'){
                k--;
            }
            String part = path.substring(k + 1, j + 1); //结束索引不包括，所以需要+1
            if(part.isEmpty() || part.equals(".")){
                i = k;
                continue;
            }
            else if(part.equals("..")){
                count++;
            }
            else if(count > 0){
                count--;
            }
            else{
                res.insert(0, "/" + part);
            }
            i = k;
        }
        return res.length() == 0 ? "/" : res.toString();
    }
//        if(path.length() == 0) return "/";
//        Stack<String> canonicalPath = new Stack<>();
//        StringBuilder tmp = new StringBuilder();
//        int i = 0;
//        for(; i < path.length(); i++){
//            if(path.charAt(i) != '/'){
//                break;
//            }
//        }
//        for(; i < path.length(); i++){
//            if(Character.isLetter(path.charAt(i))){
//                tmp.append(path.charAt(i));
//            }
//            else if((i < path.length() - 2 && path.charAt(i) == '.'
//                    && path.charAt(i + 1) == '.'
//                    && path.charAt(i + 2) == '.')){
//                canonicalPath.push("...");
//                i = i + 2;
//            }
//            else if(path.charAt(i) == '/'){
//                if(tmp.length() != 0) {
//                    canonicalPath.push(tmp.toString());
//                    tmp.delete(0, tmp.length());
//                }
//                else {
//                    continue;
//                }
//            }
//            else if(path.charAt(i) == '.'){
//                if(i < path.length() - 2 && path.charAt(i + 1) == '.' && !Character.isLetter(path.charAt(i + 2))){
//                    if(!canonicalPath.isEmpty()){
//                        canonicalPath.pop();
//                    }
//                }
//                else if(i == path.length() - 2 && path.charAt(i + 1) == '.'){
//                    if(!canonicalPath.isEmpty()){
//                        canonicalPath.pop();
//                    }
//                }
//                else{
//                    tmp.append(path.charAt(i));
//                }
//            }
//        }
//        if(tmp.length() != 0) {
//            canonicalPath.push(tmp.toString());
//            tmp.delete(0, tmp.length());
//        }
//        List<String> reverse = new ArrayList<>();
//        StringBuilder res = new StringBuilder();
//        while(!canonicalPath.isEmpty()){
//            reverse.add(canonicalPath.pop());
//        }
//        for(int j = reverse.size() - 1; j >= 0; j--){
//            res.append('/');
//            res.append(reverse.get(j));
//        }
//        if(res.length() == 0){
//            return "/";
//        }
//        return res.toString();
}
