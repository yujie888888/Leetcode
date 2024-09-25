package Company_IBM;

import java.util.Arrays;

/**
 * 一所大学录取了一组具有不同技能水平的学生。为了更好地照顾学生，大学决定根据技能水平创建班级。
 * 一次分班考试会返回一个技能水平，将用于对学生进行分组，其中 levels[i] 代表学生 i 的技能水平。
 * 每个组内的所有学生的技能水平之间的差异不能超过 maxSpread，即指定的最大范围。你的任务是确定必须形成的最小班级数。
 * 示例：
 * 输入:
 * n = 5 （学生总数为 5）
 * levels = [1, 4, 7, 3, 4] （技能水平数组）
 * maxSpread = 2 （每组学生之间允许的最大技能水平差异）
 * 输出: 3
 * 解释: 学生组的技能水平差异不能超过 2。可能的分组之一是：
 * 第一组: (1, 3)
 * 第二组: (4, 4)
 * 第三组: (7)
 * 另一种可能的分组是：
 * 第一组: (1)
 * 第二组: (3, 4, 4)
 * 第三组: (7)
 * 无论如何，都无法形成少于 3 个班级。
 * 函数描述：
 * 请完成函数 groupDivision，该函数具有以下参数：
 * int levels[n]: 每个学生的技能水平数组。
 * int maxSpread: 允许的最大技能水平差异。
 * 返回:
 * int: 必须形成的最小班级数。
 */
public class AssignClass {
    public static void main(String[] args) {
        int[] levels = new int[]{1, 4, 7, 3, 4};
        int maxSpread = 2;

        Arrays.sort(levels);
        System.out.println(Arrays.toString(levels));
        int res = 0;
        for(int i=0; i<levels.length; i++){
            int max = levels[i] + maxSpread;
            res++;
            while(i<levels.length && levels[i] <= max){
                //System.out.print(levels[i]+",");
                i++;
            }
            i--;
            //System.out.println();
        }

        System.out.println(res);
    }
}
