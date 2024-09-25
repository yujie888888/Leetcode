package DataStruc_StackQueue.ALG_MonotonicStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class LC496_NextGreaterElementI {
    /**Monotonic Stack
     * O(n)
     * O(n)
     * 思路：
     * 和LC 739一样都是求右边第一个比当前元素大的元素
     * 区别是这道题多一个index的对应，求的不是nums2中的所有的元素的值，而是nums1中对应的nums2中的元素
     *      用hashmap存nums1[i]和i
     *      在向res存值的时候，用res[map.get(nums2[stack.peek()])]来获取nums2的stack的peek值（index)-->的值-->对应的在nums1中的index的位置
     *      很绕，想清楚就行了
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
}
