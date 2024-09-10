package ALG_TwoPointers;

public class LC1151_MinimumSwapstoGroup {
    public static void main(String[] args){
        int[] data = new int[]{1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1};
        System.out.println(minSwaps(data));
    }
    /**Slide Window
     * O(n)
     * O(1)
     * Ideas:
     * 固定大小的滑动窗口
     * 1的集合的位置不一定在哪个位置，用SW找最优结果
     * 计算SW中的0的数量，就是要swap的次数
     * 注意这个缩小窗口的时候resL--
     */
    public static int minSwaps(int[] data) {
        int count1 = 0;
        int n = data.length;
        for(int i=0; i<n; i++){
            if(data[i] == 1) count1 ++;
        }
        if(count1 <= 1) return 0;

        int left = 0;
        int right = 0;
        int res = n;
        int resL = 0;

        while(right < n){
            if(data[right] == 0){
                resL++;
            }
            if(right - left + 1 == count1){
                res = Math.min(res,resL);
                if(data[left] == 0){
                    resL --;
                }
                left ++;
            }
            right++;
        }
        return res;
    }
}
