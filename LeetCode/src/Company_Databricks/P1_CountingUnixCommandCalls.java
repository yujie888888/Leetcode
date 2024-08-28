/**
 *  - Given a list of Unix commands (`cp`, `ls`, `mv`, `$1`, `$4`), return a list indicating the number of times each command is called. Variables like `$4` and `$1` are references, where `$4` resolves to `$1`, and `$1` resolves to `cp`.
 * - **Steps:**
 *   - Resolve command references.
 *   - Count occurrences of each command.
 *   - Return the count of each command.
 * -Ex:
 *   Input: ["cp", "ls", "mv", "$1", “$4"]
 *   Output: [3, 1, 1]
 */
package Company_Databricks;
import java.util.Arrays;
import java.util.HashMap;

public class P1_CountingUnixCommandCalls {
    /**代码逻辑题
     * HashMap
     * O(n)
     * O(n)
     */
    public static void main(String[] args){
        String[] input = new String[]{"cp", "ls", "mv", "$1", "$4"};
        HashMap<String,Integer> map = new HashMap<>();
        for(String str : input){
            if(str!="$1" && str!="$4"){
                map.put(str,map.getOrDefault(str,0)+1);
            }
            else{
                map.put("cp",map.getOrDefault("cp",0)+1);
            }
        }
        int[] res = new int[map.size()];
        for(int i=0;i<map.size();i++){
            res[i] = map.get(input[i]);
        }
        System.out.println(Arrays.toString(res));
    }
}
