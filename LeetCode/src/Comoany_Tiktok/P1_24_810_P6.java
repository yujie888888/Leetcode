/**
 * ByteDance推出了一项名为“TikTok Collectibles”的新功能，用户可以收集和交易包含流行TikTok创作者的数字卡片。每个创作者有不同类别的卡片，例如最受欢迎创作者的稀有卡片，独特设计的特别版卡片，以及带有独家视频内容的互动卡片。
 * ByteDance希望创建一定数量的收藏包，每个包中包含相等数量的每种类型的卡片。为此，他们需要添加更多卡片，以确保每种类型的卡片可以均匀分布在各个包中。
 * 给定每种卡片类别的现有库存（作为大小为n的整数数组cardTypes），确定需要添加的最小卡片数量，以便能够创建多个包，每个包中的卡片类型数量相等。
 * 示例：
 * n = 5
 * cardTypes = [4, 7, 5, 11, 15]
 * 为了创建2个匹配的包，必须添加以下数量的额外卡片：[0, 1, 1, 1, 1]，这总共需要添加4张卡片。
 * 卡片数量变为 [4, 8, 6, 12, 16]，它们可以均匀分配到2个包中。
 * 函数描述：
 * 完成函数 cardPackets，该函数接收一个整数数组cardTypes，返回需要添加的最小额外卡片数量。
 * 约束：
 * 1 ≤ n ≤ 10^5
 * 1 ≤ cardTypes[i] ≤ 500
 */
package Comoany_Tiktok;
import java.util.Arrays;
/**
 * 可以用二分，但是我不会
 */
public class P1_24_810_P6 {
    //从2到最大的数，依次作为公因数，遍历，计算costAll，取最小值
    public static void main(String[] args){
        int[] nums = new int[]{5,5,5,5,10,7};
        Arrays.sort(nums);
        int costAll = Integer.MAX_VALUE;
        for(int i=2; i<=nums[nums.length-1]; i++){
            int cost = 0;
            for(int j=0; j<nums.length; j++){
                cost += (nums[j]%i);
            }
            costAll = Math.min(costAll,cost);
        }
        System.out.println(costAll);
    }
}
