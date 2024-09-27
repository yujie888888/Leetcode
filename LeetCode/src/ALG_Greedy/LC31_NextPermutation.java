package ALG_Greedy;

public class LC31_NextPermutation {
    public static void main(String[] args) {

    }

    /**Greedy
     * O(n^2) worst situation
     * O(n)
     * Ideas:
     * 鬼佬东西
     * 按照Gredy思路，每次改变都让这个改变尽可能的小；换句话说，最小地增加字典序
     *  first, from n-1 to 0, find the index i that nums[i] < nums[i+1]
     *  因为要想每次改变最小，那么就从后往前找第一个降序的element（nums[i])，然后替换这个element，替换这个element之后得到的肯定比现在的大
     *  从后往前找也是为了确保找到的位置是替换后影响最小的位置（越靠前，字典序改变的越大)
     *  then find the index j that nums[j] > nums[i]
     *  这也是为了使得每次改变最小，从后向前找第一个比nums[i]大的值，因为在[i+1,n-1]的范围内是升序的，所以找到的第一个element肯定就是最小的大于nums[i]的值
     *  because the range from [n-1, i], the order is assciding
     *  so the first nums[j]>nums[i] is waht we want
     *
     *  主要逻辑：
     * a. 从右向左遍历数组，找到第一个相邻升序对（i, i+1）。
     * b. 从右向左找到第一个大于 nums[i] 的元素 nums[j]，与 nums[i] 交换。
     * c. 将 i+1 到数组末尾的部分反转。
     * d. 如果整个数组是降序的，则将整个数组反转。
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                for (int j = n - 1; j >= 0; j--) {
                    if (nums[j] > nums[i]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
                // System.out.println(Arrays.toString(nums));
                nums = reverse(nums, i+1, n-1);
                break;
            }
        }
        if (i == -1) {
            nums = reverse(nums,0,n-1);
        }
    }

    private static int[] reverse(int[] nums, int left, int right) {
        while (right > left) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return nums;
    }
}
