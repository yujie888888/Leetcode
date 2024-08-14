/**
 * Bob is the governor of the city X. This city consists on N spots which are arranged in a straight line A spot can be either a red spot of a green spot . the color of a spot is give as a string STR
 * if STR[i] is 'R' the ith spot is a red spot
 * if STR[i] is 'G' the ith spot is a green spot
 * Bob wants to turn this city into a green city. It is given that a city is called a green city if there exists at least one consecutive segment of K spots which are all green spots.
 * Bob can pass a bill at-most once. According to this bill any segment of consecutive spots can all be designated as green spots. However, bob wants to find the length of the shortest segment that can be alterded such that the city becomes a green city.
 * Constraints
 * 1 <= N <= 10^5
 * 1 <= K <= 10^5
 * 1 <= len (STR)<=10^5
 * Sample Input Sample Output Explanation
 * 5
 * 5 4 select segment 1to 4. we ll have a greenzone of length 5 ans=4
 * RRGRG
 * 5
 * 3 1 select segment 4 to 4 we ll have a greenzone of length 3 ans=1
 * RRGRG
 * 5
 * 1
 * RRGRG 0 we already have a greenzone of length 1 ans=0
 */
package Company_Uber;
import java.util.ArrayList;
import java.util.List;

public class P5_GreenCity {
    public static void main(String[] args){
        String str = "RRGRGRR";
        int k = 5;
        System.out.println(solution(str,k));
    }
    /**Slide Window
     * 要找一段长度最小的指定区域，那么只需要固定k长度的窗口，找最小的，需要指定成绿色的红色区域的长度
     * 1.先把前k个长度的元素作为初始窗口
     * 2.然后每次滑动一个位置，记录最后一个Red和第一个Red的距离，记录最小值即可
     */
    private static int solution(String str, int k){
        List<Integer> Red = new ArrayList<>();
        List<Integer> Green = new ArrayList<>();
        for(int i=0; i<k; i++){
            if(str.charAt(i) == 'R') Red.addLast(i);
            else Green.addLast(i);
        }
        if(Green.size() == k) return 0;
        int ans = Math.min(k, Red.getLast()-Red.getFirst()+1);
        int start = 0;
        int end = k;
        while(end<str.length()){
            if(str.charAt(end) == 'R'){
                Red.addLast(end);
            }
            else{
                Green.addLast(end);
            }
            end ++;
            if(str.charAt(start) == 'R'){
                Red.removeLast();
            }
            else{
                Green.removeLast();
            }
            start ++;
            if(Green.size() == k) return 0;
            ans = Math.min(ans, Red.getLast()-Red.getFirst()+1);
        }
        return ans;
    }
}
