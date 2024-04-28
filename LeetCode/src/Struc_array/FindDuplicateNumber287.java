package Struc_array;
/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * Example 1:
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * Example 3:
 * Input: nums = [3,3,3,3,3]
 * Output: 3
 * Constraints:
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
public class FindDuplicateNumber287 {
    public static void main(String[] args) {

    }

    /**1、找循环相遇点 和P141一样的思路
     * O(n) Beats 80%
     * 注意事项
     * 1.nums 数组包含 n + 1 个元素，每个元素的值都在 [1, n] 的范围内。考虑到数组元素的值可以视为指向数组索引的指针（即 nums[i] 指向 nums[nums[i]]
     *   这意味着至少有一个元素重复：因为有 n + 1 个元素但只有 n 个可能的值（即 1 到 n），根据鸽巢原理，至少有一个值被重复使用。
     *   形成环：重复的元素意味着至少有两个不同的索引 i 和 j（i ≠ j），使得 nums[i] = nums[j]。
     *   这导致链表中至少有一个环，因为从 nums[i] 和 nums[j] 出发的链表路径最终会回到相同的点。
     * 2.看不懂1可以画图，比如[3,1,3,4,2],nums[0]-3 循环:|nums[3]-4 nums[4]-2 nums[2]-3 |nums[3]-4 nums[4]-2 nums[2]-3 |
     * 3.初始化：设置两个指针，slow 和 fast。slow 每次移动一步（slow = nums[slow]），而 fast 每次移动两步（fast = nums[nums[fast]]
     * 4.这里的移动不是slow和fast++，而是指向的移动
     * 5.第一次相遇：由于环的存在，快指针 fast 和慢指针 slow 最终会在环内的某个点相遇。这个相遇点不一定是环的开始，也不一定是重复的数，但它确实位于环内。
     * 6.找到环的入口（!重复的数!）：当快慢指针第一次相遇后，将一个指针（例如 slow）重置到链表的起点，然后两个指针都以相同的速度（每次一步）移动。下一次它们相遇的点就是环的入口，这个入口也是重复的数。
     * 7.第5和第6都是环问题的固定解法，记住这个规律就行。这个规律应用到这个题中就是，环的入口一定是重复的那个数。
     * 8.这道题在迭代寻找相遇点的时候要注意，一开始就进行一次迭代。
     * 9.第6步重置的位置，也就是起点的位置是0，不是nums[0].因为在寻找相遇点的时候slow = nums[0];fast = nums[nums[0]];这两句是让指针先进行了一次迭代，起点位置依旧应该是0。
     */
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    /**2、HashSet法
     * O(n) Beats 35%
     */
    private static int hashSetFind(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        //for-each
        for(int num : nums){
            if(set.contains(num)) return num;
            else{
                set.add(num);
            }
        }
        return 0;
    }

    /**3、Sort法
     * O(nlogn) Beats 6%
     */
    private static int sortFind(int[] nums){
        //.sort nlogn
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i] == nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }
}
