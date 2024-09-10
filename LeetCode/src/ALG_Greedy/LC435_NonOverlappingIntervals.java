package ALG_Greedy;

import java.util.Arrays;

public class LC435_NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {2,3},
        };
        System.out.println(eraseOverlapIntervals(intervals));
    }

    /**Greedy
     * Idea:
     * 先按照每个区间的结束时间排序
     * 看当前interval和之前的interval是否重叠
     *      如果重叠要删除这个intervals
     *      !!因为是直接删除所以这里要用previous保存当前interval要进行判断是否overlap的interval，而不是比较interval[i]和interval[i-1]
     * Attention:
     * 正确的贪心算法应该是按照每个区间的结束时间 endi 排序，因为这样可以确保你每次选择的区间的结束时间最早，
     * 从而给后续区间留出更多的空间，这样才能保证不重叠的区间数量最大化
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[1]-b[1]));
        int prev = 0;
        int res = 0;
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] < intervals[prev][1]){
                res++;
            }else{
                prev = i;
            }
        }
        return res;
    }
}
