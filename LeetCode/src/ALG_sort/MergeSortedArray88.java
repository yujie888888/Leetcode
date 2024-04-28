package ALG_sort;
/**复制数组
 * 1、(推荐)System.arraycopy() 方法
 * 这是一种效率较高的方法来复制数组。它直接在系统级别操作内存，可以快速复制数组元素。
 * int[] nums1 = {1, 2, 3, 4};
 * int[] nums1Copy = new int[nums1.length];
 * System.arraycopy(nums1, 0, nums1Copy, 0, nums1.length);
 * System.arraycopy(src, srcPos, dest, destPos, length);
 * src - 源数组，即从哪个数组复制数据。
 * srcPos - 源数组中的起始位置，从这个位置开始复制数据。
 * dest - 目标数组，即将数据复制到哪个数组。
 * destPos - 目标数组中的起始位置，从这个位置开始存放复制过来的数据。
 * length - 要复制的数组元素的数量。
 *
 * 2、Arrays.copyOf() 方法
 * 这是一种更简单但效率稍低的方法，适合大多数情况。
 * int[] nums1 = {1, 2, 3, 4};
 * int[] nums1Copy = Arrays.copyOf(nums1, nums1.length);
 *
 * 3、使用循环手动复制
 * 如果你想要更多的控制或者仅需要复制数组的一部分，可以手动通过循环来复制
 * int[] nums1 = {1, 2, 3, 4};
 * int[] nums1Copy = new int[nums1.length];
 * for (int i = 0; i < nums1.length; i++) {
 *     nums1Copy[i] = nums1[i];
 * }
 */
public class MergeSortedArray88 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge1(nums1,m,nums2,n);
        for(int num : nums1) {System.out.print(num+",");}
    }
    //从前往后需要辅助数组 O(n)/O(m)
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        //base case
        if(n == 0) return;
        //复制数组
        int[] nums1Copy = new int[nums1.length];
        System.arraycopy(nums1, 0, nums1Copy, 0, nums1.length);
        //从前往后需要一个辅助数组
        //从后往前就不需要了，参考merge2
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        //判断条件
        while(p1<m && p2<n){
            if(nums1Copy[p1] < nums2[p2]){
                nums1[p] = nums1Copy[p1];
                p++;
                p1++;
            }
            else{
                nums1[p] = nums2[p2];
                p++;
                p2++;
            }
        }
        while(p2<n){
            nums1[p] = nums2[p2];
            p2++;
            p++;
        }
        while(p1<m){
            nums1[p] = nums1Copy[p1];
            p1++;
            p++;
        }
    }
    //从后往前不用辅助数组 O(n)/O(1)
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        //base case
        if(n==0) return;
        //从后往前
        int p1 = m-1;
        int p2 = n-1;
        int p = nums1.length-1;
        //注意这里把p1如果没有走到头和p2没有走到头包含进去了
        //对于p1没有走到头的情况，其实nums1剩下的已经是结果了，所以不用再对p1剩下的元素进行重置
        //对于p2没有走到头的情况，应该按照nums2中的顺序依次把剩下的元素放进nums1中
        while(p2>=0){
            //要加上=，0的时候也是有值的
            if(p1>=0 && nums1[p1] > nums2[p2]){
                nums1[p] = nums1[p1];
                p1--;
                p--;
            }
            //这里else包含两种情况，p1<0 || (p1>0 &&nums1[p1] <= nums2[p2])
            else{
                nums1[p] = nums2[p2];
                p2--;
                p--;
            }
        }
    }
}
