package DataStruc_StackQueue.ALG_MonotonicStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class LC496_NextGreaterElementI {
    /**Monotonic Stack(推荐2的做法)
     * O(n)
     * O(n)
     * Ideas：
     * 创建映射：
     * 使用 HashMap map 存储 nums1 中元素到其索引的映射。
     * 这样可以快速判断 nums2 中的元素是否在 nums1 中，并找到其在 nums1 中的位置。
     * 准备结果数组：
     * 创建 res 数组，长度与 nums1 相同。
     * 初始化所有元素为 -1，表示默认没有找到下一个更大元素。
     * 使用单调栈处理 nums2：
     * 遍历 nums2 数组。
     * 维护一个单调递减的栈，栈中存储的是 nums2 的索引。
     * 对于每个元素 nums2[j]：
     * a. 如果栈不为空，且当前元素大于栈顶元素对应的值：
     * 这意味着我们找到了栈顶元素的下一个更大元素。
     * 如果栈顶元素在 nums1 中（通过 map 判断），更新 res 数组。
     * 弹出栈顶元素，继续比较。
     * b. 将当前索引 j 压入栈中。
     */
    public static void main(String[] args){
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i],i);
        }
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);
        for(int j=0; j<nums2.length; j++){
            while(!stack.isEmpty() && nums2[j] > nums2[stack.peek()]){
                if(map.containsKey(nums2[stack.peek()])){
                    res[map.get(nums2[stack.peek()])] = nums2[j];
                }
                stack.pop();
            }
            stack.push(j);
        }
        System.out.println(Arrays.toString(res));
    }

    /**HashMap
     * O(n)
     * O(n)
     * Ideas:
     * 思路是一样的，但是这个简化很多，只需要多一个hashmap
     */
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        // value : next greater value
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<nums2.length; i++){
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                map.put(stack.peek(), nums2[i]);
                stack.pop();
            }
            stack.push(nums2[i]);
        }
        // System.out.println(map);
        for(int i=0; i<nums1.length; i++){
            if(map.containsKey(nums1[i])){
                nums1[i] = map.get(nums1[i]);
            }
            else{
                nums1[i] = -1;
            }
        }
        return nums1;
    }
}
