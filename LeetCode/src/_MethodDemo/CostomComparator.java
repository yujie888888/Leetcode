package _MethodDemo;
import java.util.Arrays;
import java.util.HashMap;

public class CostomComparator {
    /**Custom Comparator
     * 1.Comparator Interface
     * 2.(Java 8)Lambda Expression
     * 3.(Java 8)Comparator.comparing 用于对象排序
     * 4.复合比较器
     */
    public static void main(String[] args) {
        LambdaExpression1();
    }
    //2.1.Lambda Expression 按照年龄排序
    private static void LambdaExpression1() {
        HashMap<String, Integer> person = new HashMap<>();
        person.put("Alice",18);
        person.put("Ally",20);
        person.put("Ash",26);
        person.put("Belly",16);
        person.put("Bob",10);
        String[] people = {"Alice","Ally","Ash","Belly","Bob"};
        Arrays.sort(people, (p1, p2) -> (person.get(p1)-person.get(p2)));
        System.out.println(Arrays.toString(people));
    }
    //2.1.Lambda Expression 按照自定义字典序排序
    private static String[] LambdaExpression2(){
        String order = "abcdefghijklmnopqrstuvwxyz";
        String[] productCodes = {"adc", "abc", "aab", "aaa", "bbb", "bba"};
        HashMap<Character,Integer> sortOrder = new HashMap<>();
        char[] charOrder = order.toCharArray();
        for(int i=0; i<order.length(); i++){
            sortOrder.put(charOrder[i],i);
        }
        Arrays.sort(productCodes, (a,b)->{
            if(a.length() != b.length()) return a.length()-b.length();
            else{
                for(int i=0; i<a.length(); i++){
                    if(a.charAt(i) != b.charAt(i)){
                        return sortOrder.get(a.charAt(i)) - sortOrder.get(b.charAt(i));
                    }
                }
            }
            return 0;
        });
        return productCodes;
    }
}
