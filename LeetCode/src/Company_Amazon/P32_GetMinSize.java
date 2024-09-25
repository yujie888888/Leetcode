package Company_Amazon;

import java.util.Arrays;

/**
 * Within the Amazon Gaming Distribution System, a logistics coordinator is faced with the task of efficiently distributing n games among k different children. Each game is characterized by its size, denoted by gameSize[i] for 1 ≤ i ≤ n.
 * To facilitate the distribution process, the coordinator opts to utilize pen drives, ordering k pen drives with identical storage capacity. Each pen drive can receive a maximum of 2 games, and every child must receive at least one game, also no game should be left unassigned.
 * Considering the impracticality of transferring large game files over the internet, the strategy involves determining the minimum storage capacity required for the pen drives. A pen drive can only store games if the sum of their sizes does not exceed the pen drive's storage capacity.
 * What is the minimum storage capacity of pen drives that you must order to be able to give these games to the children?
 * Function Description
 * Complete the function getMinSize in the editor.
 * getMinSize has the following parameters:
 * int gameSize[n]: the size of each game
 * int k: the number of children amongst whom the games are to be distributed
 * Returns
 * int: an integer variable denoting the minimum capacity of pen drives required to distribute the games amongst the children
 * Example 1:
 * Input:  gameSize = [9, 2, 4, 6], k = 3
 * Output: 9
 * Explanation:
 * We note that we will need pen drives of the size of at least 9 units, to store the first game.
 * This also turns out to be the minimum size of pen drives that should be ordered to give the games to these children.
 * We can use the first pen drive to store the game of size 9, the 2nd one to store the second and third games, and the 3rd pen drive to store the fourth game.
 * Hence, the minimum capacity of pen drives required is 9 units.
 * Constraints:
 * 1 ≤ k ≤ n ≤ 2 * 10^5
 * 1 ≤ gameSize[i] ≤ 10^9
 * n ≤ 2*k
 */
public class P32_GetMinSize {
    public static void main(String[] args) {
        int[] gameSize = new int[]{9, 2, 4, 6};
        int k = 3;
        System.out.println(getMinSize(gameSize,k));
    }

    /**Greedy
     * O(nlogn)
     * O(1)
     * Ideas:
     * 题目说的看起来很复杂，但其实就是
     *  有k个U盘，找一个minSize，这k个minSize的U盘要装下所有的游戏
     *  并且每个U盘都要被用到
     *  并且每个U盘最多放2个游戏
     *  !!key：因为必须每一个U盘都要被用到，所以分成3种情况(自己想出来的哦)
     *  从Constraints k ≤ n ≤ 2*k看出来的端倪
     *  1. k == n 每个k放1个game，直接求max就可以
     *  2. if(2k == n) 每个k都要放2个game，首尾相加取最大和，这个最大和就是可满足条件的最小U盘容量
     *  3. if(2k < n) U盘有可能放1个有可能放2个
     *      先把最大的几个放进singleU，再首尾相加剩下的games
     *      因为如果把大的和别的game相加肯定是比 小的和game相加的值要大
     *      过程中记录res(MaxU)
     */
    public static long getMinSize(int[] games, int k) {
        int n = games.length;
        Arrays.sort(games);
        int max = games[n-1];

        // 我感觉要判断k和n的关系
        // 1. k == n 每个k放1个game，直接求max就可以
        if (k == n) return max;

        // 2. if(2k == n) 每个k都要放2个game
        if (2 * k == n) {
            int res = -1;
            for (int i = 0; i < k; i++) {
                // 首尾逐个相加,这样确保每个U盘用的是最小的size
                res = Math.max(res, games[i] + games[n - 1 - i]);
            }
            return res;
        }
        else {
            // 3. if(2k < n) U盘有可能放1个有可能放2个
            int res = max;
            //把最大的先放进singleU,singleU是只存放1个game的U盘的数量
            //必须要先把single放完，因为必须要用完k个U盘，而现在U盘有点“过剩”，所以尽可能放满singleU
            int singleU = 2 * k - n;
            //然后再从剩下的里面两两放入
            int index = n - 1 - singleU;
            int i=0;
            while(i < index) {
                res = Math.max(res, games[i] + games[index]);
                i++;
                index--;
            }
            return Math.max(max,res);
        }
    }
}
