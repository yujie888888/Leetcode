package ALG_Sort;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class LC210_CourseScheduleII {
    public static void main(String[] agrs){
        int numCourses = 4;
        int[][] prerequisites = new int[][]{
                {1,0},
                {2,0},
                {3,1},
                {3,2}
        };
        System.out.println( findOrder(numCourses,prerequisites));
    }

    /**Topological Sort
     * O(numCourses + n)
     * O(n)
     * Ideas:
     * 找到指向关系 -> 找到入度为0的点入队 -> 删除这个点并删除相关联点的入度 -> 重新入队 -> 重复
     * 1.relationship -> List<List<Integer>
     *     存放点之间的指向关系，比如course中，[1,0]表示先修0才能修1，根据题目要求（按顺序修），让0指向1
     * 2.inDegree -> int[numCourses]
     *     存每个点的入度，也就是有多少点指向自己，当入度为0的时候说明可以入队
     * 3.queue -> Queue
     *     队列存放可以放入res的点，由于有可能存在同时inDegree为0的点，所以用queue存
     * 4.res -> int[numCourses]
     *     可以依次把queue弹出存到res，并处理弹出后的操作：删除这个点并更新相关点的inDegree
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 1) return new int[]{numCourses-1};
        int n = prerequisites.length;
        List<List<Integer>> rtp = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        int[] res = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            rtp.add(new ArrayList<>());
        }

        // relationship & inDegree
        for(int i=0; i<n; i++){
            rtp.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        // queue
        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0) queue.add(i);
        }

        int j=0;
        while(j<numCourses){
            if(queue.isEmpty() && j!=numCourses-1){
                return new int[]{};
            }
            int cur = queue.poll();
            res[j] = cur;
            // remove
            for(int num : rtp.get(cur)){
                inDegree[num] --;
                if(inDegree[num] == 0) queue.add(num);
            }
            j++;
        }
        return res;
    }
}
