package DataStruc_Array;

public class LC238_ProductofArrayExceptSelf {
    public static void main(String[] args) {

    }
    /**
     * O(n)
     * O(1)
     * Ideas: 2的改进版
     * 不用新建array
     * 先计算left (left res[i]不包含nums[i])
     * 再计算right
     */
    public static int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // left
        res[0] = 1;
        for(int i=1; i<n; i++){
            res[i] = res[i-1] * nums[i-1];
        }
        // right
        int right = 1;
        for(int i=n-1; i>=0; i--){
            res[i] = res[i] * right;
            right *= nums[i];
        }
        return res;
    }

    /**
     * O(n)
     * O(n)
     * Ideas:
     * 这个方法比较直观，就是新建两个array，分别存从左开始的累计乘积，和从右边开始的累计乘积
     * 然后遍历i，直接res[i] = left[i-1] * right[i+1];
     */
    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=0; i<n; i++){
            if(i==0) left[i] = nums[i];
            else{
                left[i] = left[i-1] * nums[i];
            }
        }
        for(int i=n-1; i>=0; i--){
            if(i == n-1) right[i] = nums[i];
            else{
                right[i] = right[i+1] * nums[i];
            }
        }
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        int[] res = new int[n];
        for(int i=1; i<n-1; i++){
            res[i] = left[i-1] * right[i+1];
        }
        res[0] = 1 * right[1];
        res[n-1] = 1 * left[n-2];
        return res;
    }
}
