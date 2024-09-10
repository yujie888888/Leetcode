package DataStruc_StackQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

public class LC735_AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = new int[]{-2,-1,1,2};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    /**代码逻辑题
     * O(n)
     * O(n)
     * Ideas:
     * 不难想，但是细节逻辑实施快给我写抽筋了
     * 巧思：用flag存标记
     */
    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            // System.out.println(stack);
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
                continue;
            }
            if(!willCollision(asteroids[i], stack.peek())){
                stack.push(asteroids[i]);
                continue;
            }
            //如果stack不为空，而且新星会和stack.peek()相撞
            int flag = 0;
            while (!stack.isEmpty() && willCollision(asteroids[i], stack.peek())){
                // 挑战成功，asteroids[i]待进入
                if ((Math.abs(asteroids[i]) > Math.abs(stack.peek()))) {
                    stack.poll();
                    flag = 1;
                }
                // 势均力敌，一起毁灭
                else if (Math.abs(asteroids[i]) == Math.abs(stack.peek())) {
                    stack.poll();
                    flag = 0;
                    break;
                }
                // 挑战失败，asteroids[i]不进入
                else {
                    flag = 0;
                    break;
                }
            }
            if(flag == 1) stack.push(asteroids[i]);
        }

        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.poll();
        }
        // System.out.println(Arrays.toString(res));
        return res;
    }

    private static boolean willCollision(int a, int b) {
        if (a > 0 && b > 0) {
            return false;
        } else if (a < 0 && b < 0) {
            return false;
        }
        else if(a>0 && b<0){
            return false;
        }
        return true;
    }
}
