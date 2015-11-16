/**
 * Created by zzy on 15/11/16.
 */

/**
 * 对于一个给定的 source 字符串和一个 target 字符串，
 * 你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。
 * 如果不存在，则返回 -1。
 *
 * 如果 source = "source" 和 target = "target"，返回 -1。
 * 如果 source = "abcdabcdefg" 和 target = "bcd"，返回 1。
 *
 *
 * O(n2)的算法是可以接受的。如果你能用O(n)的算法做出来那更加好。（提示：KMP）

 */
public class StringSearch {

    public static  int  strString (String source,String target){
        if (source == null || target == null){
            return -1;
        }
        int i,j;
        for ( i = 0; i < source.length() - target.length() + 1; i++) {
            for (j = 0; j < target.length();j++){
                if (source.charAt(i+j) !=target.charAt(j)){
                    break;
                }

            }
            if (j == target.length()){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
      int temp =  strString("abadcddfrefad","ba");
        System.out.println(temp);
    }
}
