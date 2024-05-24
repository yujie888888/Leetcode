/**
 * Given an array of characters chars, compress it using the following algorithm:
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 * After you are done modifying the input array, return the new length of the array.
 * You must write an algorithm that uses only constant extra space.
 * Example 1:
 * Input: chars = ["a","a","b","b","c","c","c"]
 * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
 * Example 2:
 * Input: chars = ["a"]
 * Output: Return 1, and the first character of the input array should be: ["a"]
 * Explanation: The only group is "a", which remains uncompressed since it's a single character.
 * Example 3:
 * Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
 * Constraints:
 * 1 <= chars.length <= 2000
 * chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.
 */
package DataStruc_Array;

public class StringCompression443 {
    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c','a','a','c','c'};
        int len = compress(chars);
        System.out.print("[");
        for(int i=0; i<len; i++){
            System.out.print(i == len-1 ? chars[i] : chars[i]+",");
        }
        System.out.println("]");
    }

    /**代码逻辑题
     * O(n) 99%
     * O(n) 70%
     * 思路：
     * 这道题要求是压缩，不能用hashmap做，因为这样没办法体现char出现的位置，比如aabbaa,压缩的结果应该是a2b2a2，而不是a4b2
     * 1.遍历元素，只在一段区域内进行比较，也就是相邻的元素进行比较，求出每个元素的count
     * 2.将元素加入chars
     * 3.将count加入chars;这里要注意处理count==1和count>9的情况;
     * 4.count > 1才会插入count，解决count==1的情况
     * 5.对于count>=2(包括>=9)的情况可以一起处理: 将count转换成string，再转换成char[]，然后挨个加入chars[]中的char后面
     */
    public static int compress(char[] chars) {
        int i = 0;
        int index = 0;
        while(i < chars.length){
            int count = 1;
            while(i< chars.length -1 && chars[i] == chars[i+1]){
                count ++;
                i++;
            }
            chars[index++] = chars[i];
            if(count > 1){
                //这一步神来之笔，先把count转换成string，然后再转换成array数组，这样就算count>10也一样处理
                char[] countChars = Integer.toString(count).toCharArray();
                for(char c: countChars){
                    chars[index++] = c;
                }
            }
            i++;
        }
        return index;
    }
}
