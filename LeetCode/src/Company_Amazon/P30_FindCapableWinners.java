package Company_Amazon;
import java.util.Arrays;

/**
 * Find Capable Winners
 * Amazon games have recently launched a new multi-player tournament on the platform. Each game of the tournament has 3 rounds. The players are provided with exactly three power boosters at the start of the game and each player is aware of the power boosters of their opponent. In each round, the player can choose to compete with any of the power boosters and any power booster can be used at most once in a particular game. In any particular round, the player with a higher power booster wins.
 * A player X is considered to be capable of defeating player Y if there exists a rearrangement of power boosters of X such that some rearrangement of power boosters of Y can be defeated in at least 2 out of the three rounds. For example, if power boosters of X = [9, 5, 11] and Y = [7, 12, 3], then
 * If Y uses the boosters in order [7, 3, 12] then X can use it in order [11, 9, 5] and wins 2 out of the three games as 11 > 3 and 9 > 7. Thus X is capable of defeating Y.
 * If Y uses the boosters in order [5, 9, 11] then X can use it in order [7, 12, 3] and Y wins 2 out of the three games as 7 > 5 and 12 > 9. Thus Y is also capable of defeating X.
 * Another example is if X = [2, 3, 1] and Y = [4, 5, 6]. Here X is not capable of defeating Y as Y wins more than Y can not be defeated by X in at least two rounds.
 * Given the power boosters provided to n players where the three power boosters of the ith player are defined by (power_a[i], power_b[i], power_c[i]), find the number of players who are capable of defeating all other players in a game by using their power boosters optimally. It is guaranteed that all powers of each player's power boosters are distinct.
 * Function Description
 * Complete the function findCapableWinners in the editor.
 * findCapableWinners has the following parameter:
 * int power_a[n]: the first set of power boosters
 * int power_b[n]: the second set of power boosters
 * int power_c[n]: the third set of power boosters
 * Returns
 * int: the number of players capable of defeating all other players
 * Example 1:
 * Input:  power_a = [9, 4, 2], power_b = [5, 12, 10], power_c = [11, 3, 13]
 * Output: 2
 * Explanation:
 * Consider the number of players to be n = 3, and their first set of power boosters to be power_a = [9, 4, 12], their second set of power boosters to be power_b = [5, 12, 10] and their third set of power boosters to be power_c = [11, 3, 13]. Thus, Player 1 has power boosters [9, 5, 11], Player 2 has [4, 12, 3] and Player 3 has power boosters [12, 10, 13].
 * Player 1 can defeat Player 2 by playing in the following way: 5 against 3, 9 against 4, 11 against 12; Player 1 wins the first 2 rounds.
 * Player 1 can defeat Player 3 by playing in the following way: 5 against 2, 9 against 13, 11 against 10; Player 1 wins the first and last rounds.
 * Player 2 cannot defeat Player 1 using any combination of powers.
 * Player 3 can defeat Player 3 by playing in the following way: 4 against 12, 10 against 3, 13 against 11; Player 3 wins the first 2 rounds.
 * Player 3 can defeat Player 1 by playing in the following way: 2 against 5, 10 against 9, 13 against 11; Player 3 wins the last 2 rounds.
 * Player 3 can defeat Player 2 by playing in the following way: 2 against 12, 10 against 4, 13 against 3; Player 3 wins the last 2 rounds.
 * Thus, Player 1 and Player 3 can defeat all the players using their power boosters optimally. Thus, the answer is 2.
 * Constraints:
 * 2 ≤ n ≤ 10^5
 * 1 ≤ power_a[i], power_b[i], power_c[i] ≤ 10^9, where 0 ≤ i < n
 * All power boosters of each player are distinct.
 */
public class P30_FindCapableWinners {
    public static void main(String[] args) {
        int[] power_a = new int[]{5, 4};
        int[] power_b = new int[]{3, 2};
        int[] power_c = new int[]{1, 6};
        System.out.println(findCapableWinners(power_a ,power_b, power_c));
    }

    /**Sort+Greedy
     * O(n^2)
     * O(n)
     * Ideas:
     * 感觉不是最优解
     * 1.存player
     * 2.判断能不能赢
     *     排序
     *     依次比较(只要存在2个大于的值，不管这两个的位置怎么放)
     */
    public static int findCapableWinners(int[]a, int[]b, int[]c){
        int n = a.length;
        // 获取player列表
        int[][] players = new int[n][3];
        for(int i=0; i<n; i++){
            int[] player = new int[]{a[i], b[i], c[i]};
            Arrays.sort(player);
            players[i] = player;
        }

        int res = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if ((i != j) && canWin(i, j, players)) {
                    res++;
                }
            }
        }
        return res;
    }
    // testcase不过的例子我还没有想到，所以目前姑且算没问题
    private static boolean canWin(int i, int j, int[][] player){
        int p1 = 2;
        int p2 = 2;
        int win = 0;
        while(p1>=0 && p2>=0){
            if(player[i][p1] > player[j][p2]){
                // System.out.println("p1: " + player[i][p1]);
                // System.out.println("p2: " + player[j][p2]);
                win++;
                p1--;
                p2--;
            }
            else p2--;
        }
        if(win >= 2) return true;
        return false;
    }
}
