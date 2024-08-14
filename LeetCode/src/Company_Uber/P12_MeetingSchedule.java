/**
 * int[][][] schedules = { {{5, 6}, {1, 2}, {3,
 * 4}}, {{7, 8}, {5, 6}, {6, 7}}, {{2, 3}, {0, 1}, {4, 5}} }; each employer
 * has their schedule. we want to find the earliest time that every
 * one is free to hold a meeting with length k public int
 * meeting(int[][][] schedule, int k){}
 */
package Company_Uber;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Ideas
 * 先merge all interval，然后在看中间的空闲时间是否够
 */
public class P12_MeetingSchedule {
    public static void main(String[] args){
        int[][][] schedules = {
                {{5, 6}, {1, 2}, {3, 4}},
                {{7, 8}, {5, 6}, {6, 7}},
                {{2, 3}, {0, 1}, {4, 5}}
        };
        int k = 1;
        System.out.println(meeting(schedules, k));
    }
    public static int meeting(int[][][] schedules, int k) {
        List<int[]> allIntervals = new ArrayList<>();
        // 将所有时间段合并到一个列表中
        for (int[][] employeeSchedule : schedules) {
            allIntervals.addAll(Arrays.asList(employeeSchedule));
        }
        // 对所有时间段按开始时间排序
        allIntervals.sort((a, b) -> Integer.compare(a[0], b[0]));
        // 检查合并时间段之间的空隙
        int end = -1; // 跟踪当前最新的结束时间
        for (int[] interval : allIntervals){
            if (end == -1) {
                end = interval[1];
                continue;
            }
            // 检查当前间隔和前一个间隔之间的空隙
            if (interval[0] - end >= k) {
                return end; // 找到满足条件的空闲时间段
            }
            end = Math.max(end, interval[1]);
        }
        // 如果找不到合适的时间段，返回 -1
        return -1;
    }
}
