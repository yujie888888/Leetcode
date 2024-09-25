package ALG_Greedy;

import java.util.Arrays;

public class LC27_HIndex {
    public static void main(String[] args) {


    }

    /**Greedy
     * O(nlogn)
     * Ideas:
     * 很easy，搞清楚题目在干什么就能写出来了
     * 首先就是subarray这个array，其中这个subarray的最小值必须>=subarray.len
     * 那就先排序，然后从后向前遍历，只要满足条件，就更新res的值，最后返回一个res的最大值
     */
    public static int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        int res = 0;
        for(int i=n-1; i>=0; i--){
            // System.out.println(citations[i] + ": " + (n-i));
            if(citations[i] >= (n-i)){
                res = n-i;
            }
        }
        return res;
    }
}
