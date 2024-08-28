package DataStruc_String;

public class LC151_ReverseWordsInString {
    /**
     * O()
     * O()
     * 思路：
     * 1.trim() 方法删除字符串 str 两端的所有空白字符（包括空格、制表符等）
     * 2.replaceAll("\\s+", " ")
     *      \\s 匹配任何空白字符（空格、制表符、换行符等）
     *           \\s 是正则表达式中的一个特殊字符，表示匹配任意的空白字符。空白字符不仅仅包括普通的空格，还包括：
     *                  制表符 (\t)
     *                  换行符 (\n)
     *                  回车符 (\r)
     *                  换页符 (\f)
     *                  其他所有的空白字符
     *      + 表示匹配一个或多个连续的空白字符
     *          + 是正则表达式中的量词，用于表示匹配前面的字符或表达式一次或多次。它表示至少出现一次（1次或多次）的意思
     */
    public static void main(String[] args){
        String s = "a good   example";
        //消除前后空格
        String trimS = s.trim();
        // System.out.println(trimS);

        //消除中间的多余空格
        String replaceS  = trimS.replaceAll("\\s+", " ");
        // System.out.println(replaceS);

        String[] words = replaceS .split(" ");
        // System.out.println(Arrays.toString(words));

        int left = 0;
        int right = words.length-1;
        while(left < right){
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        String res = String.join(" ",words);
        System.out.println(res);
    }
}
