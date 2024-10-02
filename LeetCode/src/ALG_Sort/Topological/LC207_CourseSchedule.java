package ALG_Sort.Topological;

import java.util.*;

public class LC207_CourseSchedule {
    public static void main(String[] args) {

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
     *              如果遍历结束，就设置当前state[cur]=2,表示该课程已经被访问过
     *
     *      如果所有课程都没有形成环路，则可以完成所有课程，返回 true
     */
    public static boolean canFinish1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> rlp = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            rlp.add(new ArrayList<>());
        }
        for(int[] preq : prerequisites){
            rlp.get(preq[0]).add(preq[1]);
        }

        int[] state = new int[numCourses];
        // 0 doesn't access
        // 1 in access
        // 2 done access
        Arrays.fill(state,0);
        for(int i=0; i<numCourses; i++){
            if(state[i] == 0){
                if(!findCycle(i,rlp, state)) return false;
            }
            else if(state[i] == 1){
                return false;
            }
        }
        return true;
    }

    public static boolean findCycle(int course, List<List<Integer>> rlp, int[] state){
        if(state[course] == 1){
            return false;
        }

        if(state[course] == 2){
            return true;
        }

        state[course] = 1;
        for(int pre : rlp.get(course)){
            if(!findCycle(pre, rlp, state)){
                return false;
            }
        }
        state[course] = 2;

        return true;
    }


    /**Topological (Kahn ALG)
     * O(N+E) 详情解释看P210
     * O(N+E)
     * Ideas:
     * 就是检查有没有环，如果在找的过程中发现inDegree为空了，也就是找不到入度为0的course，也就是说有环
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        for(int j=0; j<numCourses; j++){
            if(queue.isEmpty()){
                return false;
            }
            int cur = queue.poll();
            // 弹出当前要处理的course
            // 遍历cur course的指向关系，将指向的course的degree--；也就是说满足了这个条件了
            for(int num : rlp.get(cur)){
                inDegree[num] --;
                if(inDegree[num] == 0){
                    queue.add(num);
                }
            }
        }
        return true;
    }



}
