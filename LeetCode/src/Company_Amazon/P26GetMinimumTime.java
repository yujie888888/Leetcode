/**
 * Constraints:
 * 1 ≤ total_servers ≤ 10^9
 * 1 ≤ n ≤ 10^5
 * 1 ≤ servers[i] ≤ n
 */
package Company_Amazon;
import java.util.Arrays;

public class P26GetMinimumTime {
    //Greedy
    public static void main(String[] args) {
        int total_servers = 10;
        int n = 4;
        int[] servers = {4, 6, 2, 9};
    }
    public static int getMinimumTime(int total, int n, int[] servers){
        if(n==1) return 0;
        if(n==2) return servers[1]-servers[0];
        Arrays.sort(servers);
        for(int i=0; i<n; i++){
            //每个server开始都可以选择三个方向开始，向左，向右，向两头
            //因为已经排过序,所以只要选定了方向，剩下的就是依次将相邻的server连接上
            Math.max(Math.max(findTime(servers,i,1),findTime(servers,i,2)),findTime(servers,i,3));
        }
        return 1;
    }
    public static int findTime(int[] servers, int i, int direction){
        return 1;
    }
}
