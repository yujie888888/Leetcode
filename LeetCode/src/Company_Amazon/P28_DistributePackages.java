package Company_Amazon;
import java.util.Arrays;
/**
 * Distribute Packages
 * Amazon has to distribute multiple packages across all of their delivery trucks.
 * Given an array of trucks where trucks[i] represents the ith truck quantity.
 * We also have another input to_distribute which states the number of packages we want to distribute across all the trucks.
 * So how would we distribute the to_distribute number such that the max total of each truck is minimized?
 * Function Description
 * Complete the function distributePackages in the editor.
 * distributePackages has the following parameters:
 * 1. int[] trucks: an array of integers representing the quantity of each truck
 * 2. int to_distribute: the number of packages to distribute
 * Returns
 * int[]: an array representing the distributed packages across the trucks
 * Example 1:
 * Input:  trucks = [2, 3, 4, 5, 6], to_distribute = 10
 * Output: [6, 6, 6, 6, 6]
 * Explanation:
 * This means that 4 packages go to the first truck, 3 packages to the second truck,
 * 2 packages to the third truck, 1 package to the fourth truck, and none to the fifth truck,
 * resulting in each truck having a total of 6 packages.
 */
public class P28_DistributePackages {
    public static void main(String[] args) {
        int[] trucks1 = new int[]{2, 3, 4, 5, 6};
        int to_distribute = 23;
        System.out.println(Arrays.toString(trucks1));
        System.out.println("---After Assign--- ");
        // 方法12差不多，只是最后分配的方式有点差异
        System.out.println(Arrays.toString(distributePackages1(trucks1,to_distribute)));
        int[] trucks2 = new int[]{2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(distributePackages2(trucks2,to_distribute)));
    }
    /**Binary Search
     * O(n)
     * O(n)
     * Ideas:
     * 1. Binary Search find the min Max can use for every truck
     * 2. use this min value to assign packages to trucks
     * 有点麻烦但是把每个部分拆解了来做其实还好
     */
    public static int[] distributePackages1(int[] trucks, int assign) {
        int max = -1;
        for(int num : trucks){
            max = Math.max(max,num);
        }
        // O(logn)
        int truckMax = findMax(max, assign, assign, trucks);

        // start assign
        int n = trucks.length;
        int remain = assign;
        int[] res = trucks;
        // O(n)
        for(int i=0; i<n; i++){
            if(remain - (truckMax - res[i]) < 0){
                res[i] = trucks[i] + remain;
                return res;
            }
            remain -= (truckMax - res[i]);
            res[i] = truckMax;
        }
        return res;
    }
    private static int findMax(int left, int right, int needToAssign, int[] trucks){
        int canUse = 0;
        int n = trucks.length;
        while(left <= right){
            int mid = left + (right-left)/2;
            canUse = 0;
            for(int i=0; i<n; i++){
                canUse += (mid-trucks[i]);
            }
            // 可以缩小
            if(canUse > needToAssign){
                right = mid-1;
            }
            // 必须扩大
            else if(canUse < needToAssign){
                left = mid+1;
            }
            else{
                return mid;
            }
        }
        // 二分法的left是满足条件的最小值
        return left;
    }

    /**Brute Force
     * O(n)
     * Ideas：
     * 我的初始想法，也是web上提供的solution
     */
    public static int[] distributePackages2(int[] trucks, int toAssign) {
        int n = trucks.length;
        int max = trucks[0];
        int sum = 0;

        for (int truck : trucks) {
            if (truck > max) {
                max = truck;
            }
            sum += truck;
        }

        // 计算可分配的空间
        int canUse = max * n - sum;

        // 如果现有空间足够分配
        if (canUse > toAssign) {
            int remain = toAssign;

            // 尽量在每辆 truck 上分配货物
            for (int i = 0; i < n; i++) {
                if (remain > 0) {
                    int canDistribute = Math.min(remain, max - trucks[i]);
                    trucks[i] += canDistribute;
                    remain -= canDistribute;
                } else {
                    break;
                }
            }
        } else {
            // 如果现有空间不足，计算每个 truck 应分配的平均重量
            int total = sum + toAssign;
            int average = total / trucks.length;
            int remain = total% trucks.length;
            // 每个 truck 分配平均重量
            Arrays.fill(trucks, average);
            // 剩余的重量分配给前几个 truck
            for (int i = 0; i < remain; i++) {
                trucks[i]++;
            }
        }
        return trucks;
    }
}
