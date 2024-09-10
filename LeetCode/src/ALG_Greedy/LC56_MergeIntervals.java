package ALG_Greedy;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class LC56_MergeIntervals {
    public static void main(String[] args){
        int[][] intervals = new int[][]{
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    /**
     * O(nlogn) 排序时间
     * O(nlogn) 排序空间
     * Ideas:
     * 巧妙的start和right—border
     */
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0]-b[0]));
        int m = intervals.length;
        int n = intervals[0].length;
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int rightBorder = intervals[0][1];

        for(int i=1; i<m; i++){
            if(intervals[i][0] > rightBorder){
                res.add(new int[]{start,rightBorder});
                start = intervals[i][0];
                rightBorder = intervals[i][1];
            }
            else{
                rightBorder = Math.max(intervals[i][1],rightBorder);
            }
        }
        res.add(new int[]{start,rightBorder});

        return res.toArray(new int[res.size()][]);
    }
}
