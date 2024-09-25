package Company_Amazon;
/**
 * n an Amazon analytics team, the Analysts collectively have a preference for the number zero and a disapproval towards negative numbers. Their objective is to determine the maximum number of zeroes achievable after performing a series of operations (possibly zero) on an array, all while avoiding negative values.
 * Formally, given an array arr of size n of positive integers, the Analysts can perform the following operation any number of times (possibly zero):
 * Choose a prefix of size s (1 ≤ s ≤ n) that doesn't contain any zero (there is no index i such that arr[i] = 0 and 1 ≤ i ≤ s).
 * Decrease all values of this prefix by one, i.e., set arr[i] = arr[i] - 1 for all 1 ≤ i ≤ s.
 * Find the maximum number of zeroes that the array arr can contain after performing any (possibly zero) number of operations on the array.
 * Note that a prefix of size s in an array arr is the first s elements in this array, for example, the prefix of size 3 of array [3, 1, 5, 5, 2] is [3, 1, 5].
 * Function Description
 * Complete the function findMaximumZeroes in the editor.
 * findMaximumZeroes has the following parameters:
 * int arr[n]: the elements of the array.
 * Returns
 * int: the maximum number of zeroes that the array arr can contain after performing any (possibly zero) number of operations on the array.
 * Example 1:
 * Input:  arr = [4, 3, 5, 5, 3]
 * Output: 3
 * Explanation:
 * If we perform the following operations:
 * No further operations can be done on the array, and the number of zeroes in arr is 3, which is the maximum possible.
 * Constraints:
 * 1 ≤ n ≤ 2 * 10^5
 * 1 ≤ arr[i] ≤ 10^9
 */
public class P31_FindMaximumZeroes {
    public static void main(String[] args) {
        int[] arr1 = new int[]{5,3,2,6,1};
        System.out.println(findMaximumZeroes1(arr1));
        int[] arr2 = new int[]{5,3,2,6,1};
        System.out.println(findMaximumZeroes1(arr2));
    }

    /**Greedy
     * O(n)
     * Ideas：
     * 很好的算法，使我心情舒畅
     * 记录在index=i之前的最小值，也就是能减少的操作数，和当前num值比一下，如果在i之前的操作数能减掉num的值就说明num可以为0
     * 之后再把canOp换成包含num在内的，在区间[0,i]的最小值
     */
    public static int findMaximumZeroes1(int[] arr){
        int canOp = arr[0];
        int res = 0;
        for(int num: arr){
            if(num <= canOp){
                res++;
            }
            canOp = Math.min(canOp,num);
        }
        return res;
    }
    /**
     * O(n^2)
     * 依次寻找最小值，然后减掉最小值
     */
    public static int findMaximumZeroes2(int[] arr){
        int n = arr.length;
        int index = n;
        int res = 0;

        while(true){
            int min = Integer.MAX_VALUE;
            for(int i=0; i<index; i++){
                if(arr[i] != 0 && arr[i] < min){
                    min = arr[i] ;
                }
            }
            for(int i=0; i<index; i++){
                arr[i] -= min;
                if(arr[i] == 0) res++;
            }
            // 找前缀index
            index = 0;
            for(; index<n; index++){
                if(arr[index] == 0){
                    break;
                }
            }
            if(index == 0) break;
        }
        return res;
    }
}
