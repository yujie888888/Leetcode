package ALG_Greedy;
import java.util.Arrays;

public class LC252_MeetingRooms {
    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(canAttendMeetings(intervals));
    }
    /**Greedy
     * O(nlogn)
     * O(nlogn)
     * Ideas:
     * 和LC56很像，都是去见问题
     */
    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0]-b[0]));
        for(int i=0; i<intervals.length-1; i++){
            if(intervals[i][1] > intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }
}
