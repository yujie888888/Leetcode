/**
 * An AWS client wants to deploy multiple applications and needs two servers, one for their frontend and another for their backend.
 * They have a list of integers representing the quality of servers in terms of availability.
 * The client's preference is that the availability of an application's frontend server must be greater than that of its backend.
 * Two arrays of same size s, frontend[s] and backend[s] where elements represent the quality of servers,
 * create pairs of elements (frontend[i], backend[i]) such that frontend[i] > backend[i] in each pair.
 * Each element from an array can be picked only once to form a pair. Find the maximum number of pairs that can be formed.
 * Function Description
 * Complete the function findMaximumPairs in the editor.
 * findMaximumPairs has the following parameters:
 *   int frontend[s]: frontend server qualities
 *   int backend[s]: backend server qualities
 * Returns
 * int: the maximum number of pairs that can be formed
 * Example 1:
 * Input:  frontend = [1, 2, 3], backend = [1, 2, 1]
 * Output: 2
 * Explanation:
 * The possible valid pairs which can be made are:
 * - (frontend[1], backend[0])=(2, 1) and (frontend[2], backend[2])=(3, 1) are valid pairs
 * - (frontend[1], backend[0])=(2, 1) and (frontend[2], backend[1])=(3, 2) are valid pairs
 * It can be seen that a maximum of 2 valid pairs can be made at a time. So the maximum number of pairs that can be formed is 2. Return 2.
 * Example 2:
 * Input:  frontend = [1, 2, 3, 4, 5], backend = [6, 6, 1, 1, 1]
 * Output: 3
 * Explanation:
 * The valid pairs which we can form are as follows. (According to the given condition of frontend[i] > backend[i]):
 * - (frontend[1], backend[2]) = {2,1}, (frontend[2], backend[3]) = {3,1} and (frontend[3], backend[4]) = {4,1} is one assignment to form pairs.
 * - (frontend[1], backend[2]) = {2,1}, (frontend[2], backend[3]) = {3,1} and (frontend[4], backend[4]) = {5,1} is one assignment to form pairs.
 * - (frontend[1], backend[2]) = {2,1}, (frontend[3], backend[3]) = {4,1} and (frontend[4], backend[4]) = {5,1} is one assignment to form pairs.
 * - (frontend[2], backend[2]) = {3,1}, (frontend[3], backend[3]) = {4,1} and (frontends, backend[4]) = {5,1} is one assignment to form pairs.
 * There are more valid assignment of pairs, but it can be made sure that there is no way we can create more than 3 pairs of assignment as among five elements of backend, two of them are 6 which is greater than the maximum value in frontend array. Hence return 3 as 3 is the maximum number of valid pairs that can be formed.
 * Constraints:
 * 1 ≤ s ≤ 10^5
 * 1 ≤ frontend[i], backend[i] ≤ 10^9
 */
package Company_Amazon;
import java.util.Arrays;

public class P22_FindMaximumServerPairs {
    public static void main(String[] args) {
        int[] frontend = {1, 2, 3};
        int[] backend = {1,2,1};
        int s = 3;
        System.out.println(findMaximumPairs(s,frontend,backend));
    }
    /**Greedy
     * O(slogs)
     * 1.sort
     * 2.让frontend的最大的去匹配backend的最大的，尽可能让更多的backend能被选中,才能有更多pairs
     * 3.局部最优-->全局最优
     */
    private static int findMaximumPairs(int s, int[] frontend, int[] backend){
        Arrays.sort(frontend);
        Arrays.sort(backend);
        int i=s-1, j=s-1;
        int res = 0;
        while(i>=0 && j>=0){
            if(frontend[i] > backend[j]){
                res++;
                i--;
                j--;
            }
            else{
                j--;
            }
        }
        return res;
    }
}
