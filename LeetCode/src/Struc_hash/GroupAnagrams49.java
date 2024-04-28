package Struc_hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]   /eat,tea,tan,ate,nat,bat
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 * Constraints:
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */
public class GroupAnagrams49 {
    public static void main(String[] args) {
        //处理输入["eat","tea","tan","ate","nat","bat"]
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the word list, use ',' as separator:");
        String inputList = sc.nextLine();
        String[] List = inputList.split(",");

        //Method_1
        //System.out.println(complexClassify(List));
        //Method_1改进
        //System.out.println(keyBuilderClassify(List));
        //Method_2
        System.out.println(sortMethod(List));

    }
    /**方法1
     * 时间复杂度O(cn), 空间复杂度非常高，但是是可以被lettcode接受的。这里写是为了理解其中的数据类型转换。
     * Create每个单词的字母频率表 这里就已经内存爆炸了
     * 字母频率表是一个int[],将它转换成String格式
     *      这里注意每个字母的频率前需要加一个符号比如'#'，不然就会出现问题：
     *      直接将result数组的每个数字拼接成字符串作为key会导致一些问题，因为不同的字符计数可以产生相同的字符串。
     *      例如，result为[1,11]（表示有一个'a'和十一个'b'）和[11,1]（表示有十一个'a'和一个'b'）都会被转换成相同的字符串"111"作为key
     * 转换成的String格式的单词字母频率作为key存入map，这里map的创建格式也很重要，后面说
     * 进行分类
     * 如果当前key存在，那么将这个单词加到这个key对应的value的尾部。这里就提到map的格式，map.value要用arraylist，因为可以直接add新值
     * 如果key不存在，那么新建一组键值对，这里注意新建键值对的格式，然后将这个单词加入map.value
     * 最后返回一个新的arraylist，arraylist<>(map.value)，也就是只返回map的value
     */
    private static ArrayList complexClassify(String[] List){
        //这里定义新HashMap的时候，要注意这个类型，key是String，value是一个Arraylist类型，为了方便同类的单词能够加在同一个key下
        HashMap<String,ArrayList> types = new HashMap<>();

        //对于LinkedList等，使用for-each循环是O(n) 使用索引访问(传统for循环并调用.get(i))是O(n^2)
        //for-each看场景选择，看起来比较简洁
        //对每一个单词进行频率统计O(n*c),c是单词长度
        for(String s : List){
            int[] nums = new int[26]; //内存消耗
            for(char c : s.toCharArray()){//这里将s转换成char[]格式，又是一次内存消耗
                //开始存值
                nums[c-'a']++;//c-'a' c-97都行  对char类型的变量执行算术运算时，char类型的值会自动转换为它的ASCII码
            }
            //将每个单词的频率数组转换成String格式，因为array是不能存入key的
            String key_nums = "";//初始化空String,又是一次内存消耗
            for(int i=0;i<nums.length;i++){
                key_nums += '#'+nums[i];
            }
            //转换结束String应该是#0#0#1#0#0...这种格式

            //用HashMap进行分类，这里HashMap的定义要在for循环之前，因为HashMap要在for之外返回
            //将key存入map，这里要分情况讨论,if-else结构可以用.computeIfAbsent替换
            //.containsKey() O(1)
            if(types.containsKey(key_nums)){//key存在，直接将值加在这个key下面的值的后面
                types.get(key_nums).add(s);//这里的.add方法肯定是从ArrayList那来的
            }
            else{//如果key不存在，那就整个新键值对，再赋值
                types.put(key_nums,new ArrayList());//这里value要先定义格式再赋值
                types.get(key_nums).add(s);
            }
        }
        //分类结束，输出结果
        return new ArrayList(types.values());
    }

    /**StringBuilder
     * StringBuilder是Java中非常常用的一种数据格式，特别是在需要频繁修改字符串内容的场景中
     * StringBuilder是Java中一个可变的字符序列，用于高效地构建字符串。
     * 相比于使用不可变的String类进行连续的字符串连接操作，StringBuilder可以显著提高性能，因为它避免了创建多个临时字符串实例
     * // 创建StringBuilder实例
     * StringBuilder sb = new StringBuilder();
     * // 指定初始容量
     * StringBuilder sbWithCapacity = new StringBuilder(100);
     * // 用String初始化
     * StringBuilder sbWithString = new StringBuilder("Initial");
     * //添加内容
     * sb.append("Hello");
     * sb.append(" ");
     * sb.append("World");
     * // 连续调用
     * sb.append(" ").append(2021);
     * // 插入内容到指定位置
     * sb.insert(0, "Start");
     * // 替换StringBuilder中指定位置的字符串
     * sb.replace(0, 6, "Finish");
     * // 删除指定位置的字符或子字符串
     * sb.delete(0, 6);
     * // 删除指定位置的字符
     * sb.deleteCharAt(0);
     * // 翻转字符串
     * sb.reverse();
     * // 返回StringBuilder中当前字符的数量
     * int length = sb.length();
     * // 返回其当前的总容量
     * int capacity = sb.capacity();
     * // 转换成String格式
     * String result = sb.toString();
     */
    private static ArrayList keyBuilderClassify(String[] List) {
        HashMap<String,ArrayList> types = new HashMap<>();
        for(String s : List){
            int[] nums = new int[26];
            for(char c : s.toCharArray()){
                nums[c-'a']++;
            }
            //替换成StringBulider
            StringBuilder sb_nums = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb_nums.append('#').append(nums[i]);
            }
            //将StringBuilder类型转换成String类型
            String string_nums = sb_nums.toString();

            // 替换成用.computeIfAbsent()方法
            // 只有在指定的键不存在于映射中时，才计算其值，并将其插入到映射中。
            // 如果映射已包含该键的映射，则该方法返回当前映射的值。
            types.computeIfAbsent(string_nums, k -> new ArrayList<String>()).add(s);
        }
        return new ArrayList(types.values());
    }


    /**方法2
     * sort方法，很简单明了
     * 也是用map实现分类
     */
    private static ArrayList sortMethod(String[] List){
        HashMap<String,ArrayList<String>> types = new HashMap<>();
        for(String s : List){
            //对每一个单词进行sort，将分类后的结果作为键值对
            //String key =  new String(Arrays.sort(s.toCharArray()));错误示范，因为Arrays.sort不返回任何值
            char[] char_s = s.toCharArray();
            Arrays.sort(char_s);
            //char[]转可以直接new String转换成String类型
            String key = new String(char_s);
            //HashMap
            types.computeIfAbsent(key, k-> new ArrayList<String>()).add(s);
        }
        return new ArrayList<>(types.values());
    }
}
