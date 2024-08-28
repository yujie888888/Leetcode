/**
 * You are given an array favoriteCategories of length nwhere each element represents the number offavorite content categories of a TikTok user.
 * Find thehighest number ofcommon interests between any two Tiktok users.
 * Ex:
 * Input: favoritecategories = [4,2,6,8]
 * Output;
 * 4
 * Explanation:
 * Out of all the pairs possible from the array, themaximum number of common interests
 * (the largestpositive integer that evenly divides the number offavorite content categories of both users)
 * is betweenthe users with 4 and 8 favorite content categories.
 * The number of common interests is 4, which is thehighest possible value.
 */
package Comoany_Tiktok;
public class P4_24_817_P7 {
    /**
     * O(n^2 * log(Math.min(a,b))) --能接受的输入范围不超过10^5
     * 1.两两组和
     * 2.求组合的公约数
     * 3.记录最大的那个
     * O(log(min(a,b))) 欧几里得算法的时间复杂度
     */
    public static void main(String[] args){
//        int[] nums = new int[]{4,2,6,8};
//        int[] nums = new int[]{10,10,10,10};
//        int[] nums = new int[]{1, 3, 7, 11};
        int[] nums = new int[]{13, 17, 19, 23};
//        int[] nums = new int[]{2, 1000000, 500000, 1000001};
//        int[] nums = new int[]{0, 12, 18, 24};
//        int[] nums = new int[]{-6, 18, -9, 3};
        bruteForce(nums);
        System.out.println(getMax(nums));
    }

    /**Sieve Of Eratosthenes Method
     * O(high^2)
     * O(high)
     * 思路：
     * 这样就把时间复杂度从n^2减少到high^2,high取值在10^5以内都能过test
     * 1.先找出最大值
     * 2.记录所有num的出现次数
     * 3.依次找出从high到1的num和它的倍数出现的次数，如果==2，说明这个i是一个gcd
     */
    private static int getMax(int[] nums){
        //1.找nums中的最大值
        int high = 0;
        for(int num : nums) high = Math.max(high,num);

        //2.记录nums中每个number的出现次数
        int[] count = new int[high+1];
        for(int num : nums){
            count[num]++;
        }

        int counter = 0;
        // Iterating from MAX to 1, GCD is always between MAX and 1
        // The first GCD found will be the highest as we are decrementing the potential GCD
        for(int i=high; i>=1; i--){
            // j是i的倍数，初始化为i
            int j = i;
            // Iterating from current potential GCD till it is less than MAX
            while(j<=high){
                // 如果倍数j存在于arr中
                if(count[j]>0){
                    // 将counter++，counter表示一个数和这个数的倍数加起来的数量
                    counter++;
                }
                //如果counter==2，就说明i和i的倍数在arr中，此时i就是最大公约数
                if(counter == 2){
                    return i;
                }
                // To check i, 2i, 3i....
                //增加倍数，继续检查i的倍数是否存在于arr中
                j += i;
            }
            //counter重置，每个i有不同的counter
            counter = 0;
        }
        return 1;
    }

    private static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a % b);
    }
    private static void bruteForce(int[] nums){
        int n = nums.length;
        int res = 1;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                //0和a的公约数是a，但是0的定义很模糊，所以如果取值范围有0，最好还是排除
                if(nums[i]==0 || nums[j]==0) continue;
                res = Math.max(res,gcd(nums[i],nums[j]));
            }
        }
        System.out.println(res);
    }

}
