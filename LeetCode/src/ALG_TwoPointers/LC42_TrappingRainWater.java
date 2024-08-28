package ALG_TwoPointers;

public class LC42_TrappingRainWater {
    public static void main(String[] args){
        /**Two Pointers
         * O(n)
         * O(n)
         * 思路：
         * 从暴力求解->优化
         * 1.观察规律可知，可以按照单列来求总量
         * 2.单列的容积=（该列的左侧的最高柱子 和 右侧的最高的柱子 的 较小者） * 1
         * 3.暴力求解是每次都计算一遍柱子的左侧和右侧的最高的柱子 再 取其中的较小者，优化方法是直接先用数组存起来每个柱子的数据
         * 难点是找到其中的求解规律，其他的都不难
         */
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        //求每个柱子的左边的最高的柱子，包括它自己
        maxLeft[0] = height[0];
        for(int i=1; i<n; i++){
            maxLeft[i] = Math.max(height[i],maxLeft[i-1]);
        }
        maxRight[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            maxRight[i] = Math.max(height[i],maxRight[i+1]);
        }
        //按列求总量
        int res = 0;
        for(int i=1; i<n; i++){
            res += Math.min(maxLeft[i],maxRight[i])-height[i];
        }
        System.out.println(res);
    }
}
