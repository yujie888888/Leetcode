/**
 * 6. Minimizing Transitions in TikTok Content Storage
 * In the bustling world of TikTok, data management behind the scenes is critical for smooth content delivery.
 * The platform's core storage mechanism is represented by a binary array called tiktokStorage,
 * which holds in bits of data, each representing a different type of content:
 * - Standard content (represented by 0s)
 * - Priority content (represented by 1s)
 * As TikTok's user engagement peaks, it's essential to minimize the transitions between standard and
 * priority content in tiktokStorage to ensure the platform's content pipeline operates seamlessly.
 * Two engineers, Liora and Thorne, are tasked with reorganizing the content to achieve this goal.
 * They can perform operations to swap the bits at any two distinct indices in the array.
 * Your task is to determine the minimum number of swap operations required so that after performing these operations,
 * there are the fewest possible transitions between 0s and 1s in the array.
 * Example:
 * Input:
 * tiktokStorage = [1, 0, 1, 0, 1]
 * Output:
 * 1
 * Explanation:
 * The optimal strategy of operations is to:
 * Swap tiktokStorage[0] and tiktokStorage[3]. After performing this operation, the array becomes [0, 0, 1, 1, 1]
 */
package Comoany_Tiktok;
public class P3_24_817_P6 {
    public static void main(String[] args){
        /**
         *  1.先计算0和1的个数，找到分界点；选择0个个数；
         *  2.分界点有两个，一个是从前往后；一个是从后往前；定位0和1的分界点；
         *  3.选择哪个分界点看的是：0个个数，选择0的个数多的一边
         *  4.计算将0的个数多的这边全部换成1的操作次数
         */
//        int[] nums = new int[]{1,0,1,0,1};//1
//        int[] nums = new int[]{0, 1, 0, 1, 0, 1, 0, 1};//2
//        int[] nums = new int[]{1, 1, 1, 1, 1, 1};//0
//        int[] nums = new int[]{0, 0, 0, 0, 1, 0};//1
        int[] nums = new int[]{1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1};//3
        int n = nums.length;
        int count0 = 0;
        for(int num : nums){ if(num == 0) count0++;}
        int count1Left = 0, count1Right = 0;
        for(int i=0; i<count0; i++){
            if(nums[i] == 1) count1Left++;
        }
        for(int i=n-1; i>=n-count0; i--){
            if(nums[i] == 1) count1Right++;
        }
        System.out.println(Math.min(count1Left,count1Right));
    }
}
