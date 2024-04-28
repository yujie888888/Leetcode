package Struc_string;

/**
 * 一定要审题，不然浪费时间
 */
public class StringCompression443 {
    public static void main(String[] args) {

    }
    //标准答案，直接插入array
    //这道题主要涉及的就是类型转换
    public int compress1(char[] chars) {
        int i = 0;
        int index = 0;
        while(i < chars.length){
            int count = 1;
            while(i< chars.length -1 && chars[i] == chars[i+1]){
                count ++;
                i++;
            }
            chars[index++] = chars[i];
            if(count > 1){
                //这一步神来之笔，先把count转换成string，然后再转换成array数组，这样就算count>10也一样处理
                char[] countChars = Integer.toString(count).toCharArray();
                for(char c: countChars){
                    chars[index++] = c;
                }
            }
            i++;
        }
        return index;
    }
    //时间复杂度非常高
    public int compress2(char[] chars) {
        String res = "";
        for(int i=0; i<chars.length;){
            int count = count(i,chars);
            if(count == 1){
                res = res + chars[i];
            }
            else{
                res += chars[i] + String.valueOf(count);
            }
            i += count;
        }
        int j = 0;
        for(char c : res.toCharArray()){
            chars[j] = c;
            j++;
        }
        return res.length();
    }
    public int count(int i, char[] chars){
        int count = 1;
        while(i<chars.length-1 && chars[i] == chars[i+1]){
            i ++;
            count ++;
        }
        return count;
    }


}
