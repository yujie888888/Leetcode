package DataStruc_Heap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class LC253_MeetingRoomsII {
    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(minMeetingRooms1(intervals));
        System.out.println(minMeetingRooms2(intervals));
    }
    /**PriorityQueue
     * O()
     * O()
     * Ideas:
     * use PriorityQueue to store every room's endtime, and the minHeap.peek() is the earliest end room
     *      if can not find the room that can start after the minHeap.peek() then we must need a new room
     *          push()新的room
     *      if can use the earliest end room, then update the endtime
     *          poll()被用过的room
     *          push()新的room
     */
    public static int minMeetingRooms1(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals[0][1]);
        int res = 1;

        for(int i=1; i<intervals.length; i++){
            if(minHeap.peek() <= intervals[i][0]){
                minHeap.poll();
            }
            else{
                res++;
            }
            minHeap.add(intervals[i][1]);
        }
        return res;
    }
    /**
     * O(n^2)  n squared
     * O(nlogn)
     */
    public static int minMeetingRooms2(int[][] intervals) {
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
