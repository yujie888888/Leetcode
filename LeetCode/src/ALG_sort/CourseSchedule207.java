/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 * Constraints:
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */
package ALG_sort;
public class CourseSchedule207 {
    /**Topological sorting
     * 要求掌握：
     * 比如topological sorting的过程中，还需要额外去统计边或者点的权重，作为最后返回的值之类的。
     * 是需要真的对于topological sorting的应用场景有一些了解的，才知道怎么去写，而不是像course schedule一样原题默写十分钟就完事了。
     *
     * 怎么看出这道题用拓扑排序、怎么建图让它能套上拓扑排序才是最难和最考查实力的;
     * 建议图问题熟悉基本算法以后不要按照tag刷，比如你刷拓扑排序tag下的题，你都提前知道这些题要用拓扑排序了，其实就已经把最难的（也是最有价值的）部分跳过了。
     */
    public static void main(String[] args) {

    }
}
