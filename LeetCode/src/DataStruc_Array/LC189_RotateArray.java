package DataStruc_Array;
import java.util.Arrays;

public class LC189_RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums,k);
        for(int i : nums){
            System.out.print(i+",");
        }
    }

    /**1、整体+部分旋转法
     * O(n) Beats 100%
     * 注意事项：
     * 1.记住这个解题模板，对于array和string都能做
     * 2.不要加base case if(k == 0 || k%nums.length == 0) return;不知道为什么加了反而提高了runtime
     * 3.注意k的取值，要处理k变成代码能使用的形式
     */
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    public static void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

    /**观察规律
     * O(n) Beats 50%
     */
    private static void findPatternsRotate(int[] nums, int k) {
        if(k == 0) return;
        int len = nums.length;
        k = k % len;
        int[] nums_copy = nums.clone();
        for(int i=0; i<len;i++){
            nums[(i+k)%len] = nums_copy[i];
        }
    }
    /**找到位置直接输出法
     * O(n)
     * O(n)
     */
    public static void rotate3(int[] nums, int k) {
        // use poniter as the element move
        if(k == 0) return;
        int n = nums.length;
        if(n == 1) return;
        int start = n - (k % n);
        if(start == n) return;

        int[] copyNum = Arrays.copyOf(nums, n);
        for(int i=0; i<n; i++){
            nums[i] = copyNum[start];
            if(start == n-1){
                start = 0;
            }
            else{
                start++;
            }
        }
    }
}
