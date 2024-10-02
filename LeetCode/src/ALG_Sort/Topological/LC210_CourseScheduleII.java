package ALG_Sort.Topological;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    /**DFS
     * O(N+E)
     * O(N+E)
     * Ideas:
     * 构建图：使用邻接表（Adjacency List）表示课程之间的依赖关系。
     * 标记每个课程的状态：
     *      未访问（0）：课程尚未被检查。
     *      正在访问（1）：当前正在检查该课程的依赖。
     *      已访问（2）：课程及其所有依赖已被检查，无环。
     * 对每个课程
     *      如果尚未访问(0)，则进行DFS检查
     *          如果当前课程为1，表示遇到了环，返回false
     *          如果当前课程为2，表示该课程已经北方问过，返回true
     *          如果当前课程为0
     *              遍历该课程的pre，执行同样的dfs检查；
     *              遍历过程中如果遇到false，就直接返回false
     *              如果遍历结束，就设置当前state[cur]=2,表示该课程已经被访问过；并记录res
     *      如果所有课程都没有形成环路，则可以完成所有课程，返回 true
     */
    public static int[] findOrder1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> rlp = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            rlp.add(new ArrayList<>());
        }
        for(int[] preq : prerequisites){
            rlp.get(preq[0]).add(preq[1]);
        }

        List<Integer> res = new ArrayList<>();
        int[] state = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            if(state[i] == 0){
                if(!dfs(i, state, rlp, res)){
                    return new int[]{};
                }
            }
        }

        int[] ans = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    public static boolean dfs(int cur, int[] state, List<List<Integer>> rlp, List<Integer> res){
        if(state[cur] == 1){
            return false;
        }

        if(state[cur] == 2){
            return true;
        }

        state[cur] = 1;
        for(int pre : rlp.get(cur)){
            if(!dfs(pre, state, rlp, res)){
                return false;
            }
        }

        state[cur] = 2;
        res.add(cur);

        return true;
    }

    /**Topological Sort (Kahn ALG)
     * O(N+E) N是numCourses，E是preq的数量
     *      外层循环：最多执行 N 次，每次循环中队列的 poll 操作是 O(1)。
     *      内层循环：对于每个被处理的课程 cur，遍历其所有指向的课程（即出度）。整个过程中，所有的 E 条边被恰好遍历一次，因此内层循环的总时间复杂度是 O(E)
     *      所以这个循环里N和E没有什么关系，对所有的course也是循环一遍；对所有的边也是循环一遍；
     * O(N+E)
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
        // 1.存关系；关系决定了入度要怎么增减
        List<List<Integer>> rlp = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            rlp.add(new ArrayList<>());
        }

        // 2.存入度；入度决定了要从哪个course开始
        int[] inDegree = new int[numCourses];
        for(int[] preq : prerequisites){
            rlp.get(preq[1]).add(preq[0]);
            inDegree[preq[0]] ++;
        }

        // 3.存course处理次序；存依次要处理的course
        Queue<Integer> queue = new LinkedList<>();
        // 存第一个course
        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0) queue.add(i);
        }

        // 4.存结果
        int[] res = new int[numCourses];

        for(int j=0; j<numCourses; j++){
            if(queue.isEmpty()){
                return new int[]{};
            }
            int cur = queue.poll();
            // 弹出当前要处理的course
            res[j] = cur;
            // 遍历cur course的指向关系，将指向的course的degree--；也就是说满足了这个条件了
            for(int num : rlp.get(cur)){
                inDegree[num] --;
                if(inDegree[num] == 0){
                    queue.add(num);
                }
            }
        }
        return res;
    }
}
