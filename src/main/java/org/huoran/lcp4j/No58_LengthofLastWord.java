package org.huoran.lcp4j;

/**
 * Created by Naozi on 2017/6/27.
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * For example,
 * Given s = "Hello World",
 * return 5.
 */
public class No58_LengthofLastWord {

    public static int lengthOfLastWord(String s) {
        // empty
        if(s == null || s.length() == 0){
            return 0;
        }
        // other
        char[] chars = s.toCharArray();
        int length = 0;
        for(int i = chars.length - 1;i >= 0;i--){
            if(chars[i] == ' '){
                if(length == 0){
                    continue;
                }
                else{
                    break;
                }
            }
            else{
                length++;
            }
        }
        return length;
    }

    public static int lengthOfLastWordFaster(String s){
        int length = s.trim().length() - s.trim().lastIndexOf(' ') - 1;
        return length;
    }

    public static void main(String[] args){
        String s = " world ";
        int result = lengthOfLastWordFaster(s);
        System.out.println(result);
    }
}
