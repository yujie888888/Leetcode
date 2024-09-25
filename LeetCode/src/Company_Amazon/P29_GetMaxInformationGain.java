package Company_Amazon;

/**
 * Get Maximum Information Gain
 * Data analysts at Amazon are analyzing a data set of n strings in the array dataSet[], each consisting of lowercase English letters. Each character in a string corresponds to a particular feature.
 * The information gain obtained by training a model with two strings, dataSet[i] and dataSet[j], is the difference between the lengths of the strings i.e., |len(dataSet[i]) - len(dataSet[j])|. To avoid too many overlapping features, two strings can be selected only if the number of common features between them does not exceed a given threshold, max_common_features. The number of common features here is equal to the number of common characters between the two strings. For example, "abc" and "bcd" have 2 common features 'b' and 'c'. While "aa" and "aaa" have two common features, the "a" two 'a' characters.
 * Given dataSet and max_common_features, determine the maximum information gain possible.
 *
 * Function Description
 * Complete the function getMaxInformationGain in the editor.
 * getMaxInformationGain takes the following arguments:
 * String[] dataSet: the strings of features
 * int max_common_features: the maximum number of common features allowed between data points
 * Returns
 * int: the maximum possible information gain
 *
 * Example 1:
 * Input:  dataSet = ["abofh", "ab", "mo"], max_common_features = 1
 * Output: 3
 * Explanation：
 * It is optimal to choose the strings "abofh" and "mo". Their number of common features is 1 ('o') and the information gain is |5 - 2| = 3.
 *
 * Example 2:
 * Input:  dataSet = ["a", "bcdef"], max_common_features = 1
 * Output: 4
 * Explanation:
 * The two strings can be chosen. They do not share any common features and their difference in length is 4.
 *
 * Constraints:
 * 2 ≤ n ≤ 1000
 * 1 ≤ len(dataSet[i]) ≤ 1000
 * 1 ≤ max_common_features ≤ 1000
 */
public class P29_GetMaxInformationGain {
    public static void main(String[] args) {
        String[] dataSet = new String[]{"aaaaabbbbbbccccc", "z"};
        int max_common_features = 4;
        System.out.println(getMaxInformationGain(dataSet,max_common_features));
    }

    /**Brute Force + int[][]
     * O(n^2)
     * O(n)
     * Ideas:
     * check every 满足 <= max_common_features 的String
     * 用int[n][26]存strs中每个str的char的频次
     * 然后for（1->26){去两两判断str1和str2之间的common数量}
     * 如果满足common数量，就计算长度差，并记录最长结果
     */
    private static int getMaxInformationGain(String[] strs, int target){
        int n = strs.length;
        int[][] freq = new int[n][26];
        int index=0;
        for(String str : strs){
            for(char c : str.toCharArray()){
                freq[index][c-'a'] ++;
            }
            index++;
        }
        int res = -1;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(isQulified(i, j, freq, target)){
                    res = Math.max(res,Math.abs(strs[i].length() - strs[j].length()));
                }
            }
        }
        return res;
    }
    // O(1)
    private static boolean isQulified(int i, int j, int[][] freq, int target){
        int count = 0;
        for(int index = 0; index < 26; index++){
            int freq1 = freq[i][index];
            int freq2 = freq[j][index];
            if(freq1 != 0 && freq2 != 0){
                if(freq1 != freq2){
                    count += Math.min(freq1, freq2);
                }
                else{
                    count += freq1;
                }
            }
        }
        System.out.println("count is: " + count);
        if(count > target) return false;
        return true;
    }
}
