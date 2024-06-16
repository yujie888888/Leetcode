/**
 * Amazon games is organizing a tournament of pair games where two teams of two players each compete against one another.
 * There are two groups group1 and group2 of size n each.
 * The skill levels of the i-th players of groups are group1[i] and group2[i],
 * For each pair of indices, (i,j) (0<=i<j<n), the pair of players(group1[i], group1[j]) compete in the pair game with (group2[i], group2[j]).
 * The winner of the game is group1 if group1[i] + group1[j]> group2[i]+ group2[j], and vice-versa.
 * Given group 1, and group2, find the number of games group1 will win. Since the answer can be large, report it modulo 10^9+ 7.
 * Example
 * Suppose n=3, group1=[1,2,3], and group2 =[3,2,1]
 * Function Description:
 * Complete the function countGamesWonByGroup1 in the editor below
 * countGamesWonByGroup1 takes the following arguments.
 * int group1[n]: The skills of the players of group1
 * int group2[n]: The skills of the players of group2
 * Returns:
 * int: The number of games won by group1 modulo 10^9+ 7
 * Constraints
 * 2<= n <=10^5
 * 1<=group1[i], group2[i]<=10^9
 */
package Company_Amazon;
import java.util.Arrays;

public class P9_CountGamesWonByGroup1 {
    public static void main(String[] args) {
        int n = 3;
        int[] group1 = {1,2,3}, group2 = {3,2,1};

//        int[] group1 = new int[n], group2 = new int[n];
//        for(int i=0; i<n; i++){
//            group1[i] = (int)Math.pow(10,9);
//            group2[i] = (int)Math.pow(10,9)-1;
//        }
        //System.out.println(countGamesWonByGroup11(n, group1, group2));
        System.out.println(countGamesWonByGroup12(n, group1, group2));
        //countGamesWonByGroup12(n, group1, group2);
    }
    /**Double-Loop
     * O(n^2)
     * O(1)
     * Ideas:
     * Every compete team only has two players
     * So we only need to find how much this kind of teams we have and sum the skill score and compare with group2
     */
    private static int countGamesWonByGroup11(int n, int[] group1, int[] group2){
        double count = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(group1[i]+group1[j] > group2[i]+group2[j]){
                    count++;
                }
            }
        }
        return (int)(count % (Math.pow(10,9)+7));
    }

    private static int countGamesWonByGroup12(int n, int[] group1, int[] group2){
        int[] diff = new int[n];
        for(int i=0; i<n; i++){
            diff[i] = (group1[i]-group2[i]);
        }
        Arrays.sort(diff);
        //System.out.println(Arrays.toString(diff));
        //1.找临界点
        int k = 0;
        for(int i=0; i<n-1; i++){
            if(diff[i]*diff[i+1]<=0) k=1;
        }
        //System.out.println(k);
        //2.线性扫描
        //把0当成正数看
        int i=1, j=0;
        long resL;
        if(Math.abs(diff[k-i]) < diff[k-j]){
            resL = n-k;
            i--;
        }
        else{
            resL = n-k-1;
            j++;
        }
        long res = resL;
        while(k-i>=0 && k+j<=n-1){
            if(Math.abs(diff[k-i]) < diff[k+j]){
                resL ++;
                res++;
                i++;
            }
            else{
                res += resL;
                j++;
            }
            if(k-i<0 && k+j<=n-1){
                res += resL;
                j++;
            }
        }
        return (int)(res%(Math.pow(10,9)+7));
    }
}
