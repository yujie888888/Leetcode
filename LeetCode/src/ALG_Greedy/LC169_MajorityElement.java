package ALG_Greedy;

public class LC169_MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
    /**Boyer-Moore 投票算法
     * O(n)
     * O(1)
     * 思路:
     * 经典Boyer-Moore投票算法题(斗兽场算法-自己起的)
     * 1.Boyer-Moore 投票算法是一种用于寻找数组中多数元素 "出现次数超过一半的元素" 的高效算法
     *   它在时间复杂度为 O(n) 且空间复杂度为 O(1) 的情况下能够找到多数元素
     *   通过消除不同的元素来找到可能的多数元素，最终剩下的候选者即为多数元素
     * 注意事项:s
     * 1.这道题的变量范围就暗示了不能用hashmap和时间复杂度大于O(n)的做法
     * 2."出现次数超过一半的元素"才能用Boyer-Moore算法
     */
    public static int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for(int num : nums){
            if(count == 0){
                candidate = num;
                count ++;
            }
            else if(candidate != num){
                count--;
            }
            else if(candidate == num){
                count++;
            }
        }
        return candidate;
    }
}
