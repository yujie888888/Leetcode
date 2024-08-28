package Topic_Others;

import java.util.Arrays;

public class LC135_Candy {
    public static void main(String[] args){
        int[] ratings = {1,2,2};
        System.out.println(candy(ratings));
    }

    /**Logic
     * Beats 80%
     * neighbor: next and previous
     * Two for-loop
     *  1.from 1 to n-1 to meet the request of "next"
     *  2. from n-2 to 0 to meet the requeast of "previous"
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }
        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i],candies[i+1]+1);
            }
        }
        int res = 0;
        for(int num : candies){
            res += num;
        }
        return res;
    }
}
