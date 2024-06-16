/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 * Example 1:
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 * Constraints:
 * 1 <= k <= points.length <= 104
 * -104 <= xi, yi <= 104
 */
package Company_Amazon;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P4_KClosestPointstoOrigin973 {
    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        System.out.println(Arrays.deepToString(kClosest1(points,k)));
        System.out.println(Arrays.deepToString(kClosest2(points,k)));
    }
    /**Custom Comparator of Heap
     * O(nlogn) Beats 90%
     * O(n) Beats 97%
     * Ideas:
     * 关键是存[]和自定义比较器
     * 一开始就看出来了，根据distance对points[]进行排序
     * 只要是能进行自定义比较的结构都可以，minHeap、Arrays.sort
     */
    public static int[][] kClosest1(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a,b) -> ((a[0]*a[0]+a[1]*a[1]) - (b[0]*b[0]+b[1]*b[1]))
        );
        //nlogn
        for(int[] point : points) minHeap.add(point);
        int[][] res = new int[k][2];
        //klogn
        for(int i=0; i<k; i++) res[i] = minHeap.poll();
        return res;
    }
    /**(Recommend)Custom Comparator of Arrays.sort()
     * O(nlogn)
     * O(k)
     * Ideas: Easier
     */
    public static int[][] kClosest2(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> ((a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1])));
        //O(k)
        return Arrays.copyOfRange(points,0,k);
    }
}
