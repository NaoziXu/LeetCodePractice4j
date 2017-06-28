package org.huoran.lcp4j;

/**
 * Created by Naozi on 2017/6/28.
 *
 * Given a string, you need to reverse the order of characters in each word within a sentence
 * while still preserving whitespace and initial word order.
 *
 * Example:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class No557_ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        // empty
        if(s == null || s.length() == 0){
            return s;
        }
        // split
        String[] strs = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        // get reverse
        for(int j = 0;j < strs.length;j++){
            String str = strs[j];
            char[] chars = str.toCharArray();
            for(int i = chars.length - 1;i >= 0;i--){
                stringBuilder.append(chars[i]);
            }
            if(j < strs.length - 1){
                stringBuilder.append(' ');
            }
        }
        // return
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        No557_ReverseWordsInAStringIII clazz = new No557_ReverseWordsInAStringIII();
        String str = "Let's take LeetCode contest";
        String result = clazz.reverseWords(str);
        System.out.println(result);
    }
}
