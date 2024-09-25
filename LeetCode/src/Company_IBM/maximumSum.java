package Company_IBM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 问题描述：
 * 给定一个大小为n的数组，代表一组可用资源。需要在以下约束条件下，找出一个最优的子数组：
 * 约束条件：
 * 子数组必须有一个特定的长度，用k表示。
 * 子数组中的所有元素必须是唯一的，代表不同的资源分配。
 * 目标：
 * 找到一个子数组，使得分配的资源总和最大化。如果无法满足约束条件分配资源，则返回-1。
 * 注意：子数组是指原数组中的一个连续段。
 *
 * 函数参数：
 * INTEGER_ARRAY arr：表示可用资源的数组
 * INTEGER k：子数组的指定长度
 * 返回值：
 * 函数应返回一个LONG_INTEGER类型的值，表示最优子数组的资源总和，如果不可能则返回-1。
 * 示例：
 * n = 5
 * k = 3
 * arr = [1, 2, 3, 7, 5]
 */
public class maximumSum {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 5));
        int k = 3;
        System.out.println(findOptimalResources(list, k));
    }

    /**Slide Window
     * 感觉和普通的滑动窗口不一样，更难一点
     * 在检查结果之前先设置: 如果是重复元素就要将当前resL变成不包含重复元素为止
     */
    public static long findOptimalResources(List<Integer> list, int k) {
        int i=0;
        int j=0;
        long sum = 0;
        long res = 0;
        HashSet<Integer> set = new HashSet<>();
        while(j < list.size()){
            int num = list.get(j);

            // 移除重复元素，直到当前元素可以被添加
            while(i<j && set.contains(num)){
                set.remove(list.get(i));
                sum -= list.get(i);
                i++;
            }

            set.add(num);
            sum += num;

            // 当窗口大小达到 k 时
            if (j - i + 1 == k) {
                 res = Math.max(res, sum);
                // 移除窗口最左边的元素，为下一次迭代做准备
                set.remove(list.get(i));
                sum -= list.get(i);
                i++;
            }

            j++;
        }
        return res;
    }
}
