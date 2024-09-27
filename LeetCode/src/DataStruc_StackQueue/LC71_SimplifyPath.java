package DataStruc_StackQueue;
import java.util.Stack;

public class LC71_SimplifyPath {
    public static void main(String[] args) {


    }
    /**Queue
     * O(n)
     * O(n)
     * Ideas:
     * 用queue存要保留的路径上的文件名
     *  对于要上找的("..")就删除上一个文件
     *  对于("/")和(".")和("")这些都不用加入queue
     *  其他的就直接加入queue
     * 注意对于String，比较的时候要用equal()
     */
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] names = path.split("/");
        //System.out.println(Arrays.toString(names));

        for(String str : names){
            if(!str.isEmpty()){
                if(str.equals("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                        continue;
                    }
                    else{
                        continue;
                    }
                }
                else if(str.equals(".")){
                    continue;
                }
                stack.push(str);
            }
        }
        StringBuilder res = new StringBuilder();
        for(String str : stack){
            res.append('/');
            res.append(str);
        }
        if(res.length() == 0) res.append('/');
        return res.toString();
    }
}
