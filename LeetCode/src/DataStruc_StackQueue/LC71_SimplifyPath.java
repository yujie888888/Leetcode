package DataStruc_StackQueue;
import java.util.Deque;
import java.util.ArrayDeque;

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
    public String simplifyPath(String path) {
        Deque<String> queue = new ArrayDeque<>();
        String[] dic = path.split("/");

        for(String str : dic){
            if(str.equals(".") || str.equals("")){
                continue;
            }
            else if(str.equals("..")){
                if(!queue.isEmpty()){
                    queue.removeLast();
                }
            }
            else{
                queue.addLast(str);
            }
        }

        if(queue.isEmpty()) return new String("/");

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            sb.append("/");
            sb.append(queue.remove());
        }
        return sb.toString();
    }
}
