/**
 * Given an array of integers nums, sort the array in ascending order and return it.
 * You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
 * Example 1:
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
 * Example 2:
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * Explanation: Note that the values of nums are not necessairly unique.
 * Constraints:
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 */
package ALG_Sort;
public class SortanArray912 {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        //quickSort(nums,0,nums.length-1);
        //bubbleSort1(nums);
        bubbleSort2(nums);
        //mergeSort
        mergeSort(nums);
        for(int num : nums) {
            System.out.print(num + ", ");
        }
    }
    /**(推荐)Merge Sort
     * O(nlogn) 稳定
     * O(n)
     * 思路：
     * 1.将数组分成两半，递归，直到数组长度变成1
     * 2.按照顺序合并两个小数组
     * 注意事项：
     * 1.在分割左右数组的时候，如果以mid为界限，不论奇数偶数，left是不包含mid的位置的
     * 2.在right数组构造的时候，right要从0开始构造，注意index的处理
     */
    public static void mergeSort(int[] nums){
        if(nums.length == 1) return;

        //分割
        int mid = nums.length/2;
        //左
        int[] left = new int[mid];
        System.arraycopy(nums,0,left,0,mid);
        //右
        int[] right = new int[nums.length-mid];
        System.arraycopy(nums,mid,right,0,nums.length-mid);
        //递归
        mergeSort(left);
        mergeSort(right);
        //合并
        int i=0;
        int j=0;
        int k=0;
        while(i<left.length && j<right.length){
            if(left[i] < right[j]){
                nums[k] = left[i];
                i++;
                k++;
            }
            else{
                nums[k] = right[j];
                j++;
                k++;
            }
        }
        //多余的直接放
        while(i<left.length){
            nums[k] = left[i];
            i++;
            k++;
        }
        while(j<right.length){
            nums[k] = right[j];
            j++;
            k++;
        }
    }

    /**Quick sort
     * O(nlogn)  递归的深度大约是logn，每一层递归都需要对n个元素进行一些操作   最坏的情况下是O(n^2)
     * O()
     * 步骤：
     * 1.任意选取pivot中心轴
     * 2.将大于pivot的数字放在pivot右边
     * 3.将小于pivot的数字放在pivot左边
     * 4.对左右子序列重复前三步操作
     * 用两个指针来实现判断数字与pivot的大小关系
     * 递归：
     * 1.终止条件：当left边界>=right边界
     * 2.递归逻辑：对于依次quicksort结束后，再对pivot值左边的进行quicksort，再对pivot值右边的进行quicksort
     * 3.参数：nums，left，right：每次递归都是缩小范围，所以left边界和right边界要根据pivot的位置进行改变
     * 快速排序细节：
     * i = left; j = right;
     * 1.i遇到大于"pivot"的数才会交换
     * 2.j遇到小于等于"pivot"的数才会交换
     * 3.用两个while()直接实现两个不合适的数通过一次交换实现
     * 3.其他时候i和j只是移动
     * 4.交换的时候i和j不移动
     * 5.while()循环之后的swap只在i<j的时候执行，因为如果i和j重合了是没有必要进行交换的
     * 6.再i和j重合之后，再把pivot塞回去
     * (照葫芦画瓢，其实也没深入理解透快排)
     */
    public static void quickSort(int[] nums, int left, int right){
        if(left>=right) return;

        int pivot = nums[left];
        int i = left;
        int j = right;
        while(i < j) {
            while (i < j && nums[j] > pivot) {
                j--;
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            if (i < j) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        nums[left] = nums[i];
        nums[i] = pivot;

        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);
    }

    /**Bubble Sort-Ascending order
     * O(n^2)
     * O(1)
     * 思路：
     * 1.对n个数字，冒泡n次 (外循环)
     * 2.每次重复交换相邻逆序 (内循环)
     * 注意事项：
     * 1.在升序冒泡排序中，每一次冒泡最大的那个值都会沉底，所以每次冒泡内循环都可以少循环一次
     */
    public static void bubbleSort1(int[] nums){
        for(int i=0; i<nums.length; i++){
            for(int j=1; j<nums.length-i; j++){
                if(nums[j-1] > nums[j]){
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
    /**Bubble Sort-Descending order
     * O(n^2)
     * O(1)
     * 思路：
     * 1.对n个数字，冒泡n次 (外循环)
     * 2.每次重复交换相邻逆序 (内循环)
     * 注意事项：
     * 1.在降序冒泡排序中，每一次冒泡最小的那个值都会沉底，所以每次冒泡内循环都可以少循环一次
     * 2.冒泡排序中谁沉底是根据判断逻辑决定的
     */
    public static void bubbleSort2(int[] nums){
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length-1-i; j++){
                if(nums[j] < nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}
