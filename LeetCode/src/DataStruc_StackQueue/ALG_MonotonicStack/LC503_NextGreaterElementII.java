package DataStruc_StackQueue.ALG_MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class LC503_NextGreaterElementII {
    public static void main(String[] args) {

    }
    /**Stack
     * O(2n)
     * O(n)
     * Ideas:
     * Needs search circularly, in order to find each element's greater element, can use 2*n length to ensure this
     * 对于数组末尾的元素，它们的"下一个更大元素"可能在数组的开头。
     * 通过遍历两次，我们确保了每个元素都有机会与数组中的所有其他元素进行比较
     */
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for(int i=0; i<2*n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i % n]){
                res[stack.peek()] = nums[i % n];
                stack.pop();
            }
            stack.push(i % n);
        }
        return res;
    }
}
