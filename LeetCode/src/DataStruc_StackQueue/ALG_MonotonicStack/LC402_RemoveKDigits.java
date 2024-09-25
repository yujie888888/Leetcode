package DataStruc_StackQueue.ALG_MonotonicStack;
import java.util.Deque;
import java.util.ArrayDeque;

public class LC402_RemoveKDigits {
    public static void main(String[] args) {

    }

    /**Greedy+Monotonic Stack
     * O(n)
     * O(n)
     * Ideas:
     * Greedy想法是，比如在String"1432219"中，每个位置的num的权重是不一样的
     *      为了让最后的数字最小，因为删除k个数字之后最后不管删除谁，位数都是一样的
     *      所以想到可以将权重较高的位置的数尽可能小
     *      然后依次将小的num“推”到小权重的位置，直到删除了k个权重高的位置的num
     *      这个过程同Monotonic Stack实现
     *          比较stack.peek()和nums[i]的大小
     *              如果nums[i]大，那么说明满足“小的num在权重高的位置”这个Greedy思想，所以不用删除
     *              如果nums[i]小于stack.peek()，那么说明大的num占据了权重高的位置，所以要stack.poll()，删除这个num，从而让后面的小num顶上去
     *          这样依次执行完后，得到的一定是删除k个num后能得到的最小结果
     */
    public static String removeKdigits1(String num, int k) {
        // every time, let the smaller number occupy the more weighted position
        Deque<Character> stack = new ArrayDeque<>();
        stack.push(num.charAt(0));
        int n = num.length();
        if(n == 1 && k >= 1) return "0";

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<n; i++){
            while(k>0 && i<n && !stack.isEmpty() && (int)stack.peek() > num.charAt(i)){
                stack.poll();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while(k > 0){
            stack.poll();
            k--;
        }

        while(!stack.isEmpty()){
            sb.append(stack.poll());
        }
        String res = sb.reverse().toString().replaceFirst("^0+","");
        //System.out.println(res);

        return res = res.length()==0 ? "0" : res;
    }
    /**
     * 1的优化，直接用sb模拟栈
     */
    public static String removeKdigits2(String num, int k) {
        // every time, let the smaller number occupy the more weighted position
        int n = num.length();
        if(n == 1 && k>=1) return "0";
        StringBuilder sb = new StringBuilder();
        sb.append(num.charAt(0));

        for(int i=1; i<n; i++){
            while(k>0 && i<n && sb.length()>0 && (int)sb.charAt(sb.length()-1) > num.charAt(i)){
                sb.setLength(sb.length()-1);
                k--;
            }
            sb.append(num.charAt(i));
        }

        while(k > 0){
            sb.setLength(sb.length()-1);
            k--;
        }
        String res = sb.toString().replaceFirst("^0+","");
        //System.out.println(res);

        return res = res.length()==0 ? "0" : res;
    }
}
