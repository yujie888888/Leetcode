package ALG_Greedy;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class LC253_MeetingRoomsII {
    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(minMeetingRooms(intervals));
    }
    /**Greedy
     * O(n^2)  n squared
     * O(nlogn)
     */
    public static int minMeetingRooms(int[][] intervals) {
        List<int[]> rooms = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));

        for(int[] time : intervals){
            int flag = 0;
            for(int[] selectRoom : rooms){
                if(selectRoom[1] <= time[0]){
                    selectRoom[1] = time[1];
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) rooms.add(time);
            if(rooms.size() == 0) rooms.add(time);
        }
        // rooms.forEach(room -> {System.out.println(Arrays.toString(room));});
        return rooms.size();
    }
}
