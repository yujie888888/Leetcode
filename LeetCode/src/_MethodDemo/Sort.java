package _MethodDemo;
import java.util.*;

public class Sort {
    public static void main(String[] args) {
        System.out.println("对自定义结构进行自定义排序:");
        sort1();
        System.out.println("--------------------------------");

        System.out.println("按照自定义的字典序进行字典序排序:");
        sort2();
        System.out.println("--------------------------------");

        // 将String类型的nums按照字典序大小排序
        System.out.println("自定义排序String[]:");
        String[] nums = new String[]{"921","111","322","129","9","2","1888","899","10000"};
        Arrays.sort(nums, (a,b) -> (b.compareTo(a)));
        System.out.println(Arrays.toString(nums));
        //compareTo() 不能用于基本数据类型的比较，基本数据类型的比较有Integer.compareTo(a,b); Double.compareTo(a,b)等
        // x.compareTo(y) 返回值>0的时候，x排在y后面
        // x.compareTo(y) == 0：表示 x 和 y 相等，通常表示两个对象在排序中的位置相同。
        // x.compareTo(y) < 0：结果<0, 表示x<y，通常意味着在排序中，x应该排在y之前。
        // x.compareTo(y) > 0：结果>0, 表示x>y，通常意味着在排序中，x应该排在y之后。
        //compareTo()支持数字，字符串，日期

        // Comparator.naturalOrder() 正序 , Comparator.reverseOrder() 逆序
        System.out.println("自定义排序String[]:");
        String[] fruits = {"apple", "orange", "banana", "pear"};
        Arrays.sort(fruits, Comparator.naturalOrder());
        System.out.println(Arrays.toString(fruits));

        // 将nums按照'能组成的String最大'这个逻辑排序
        System.out.println("自定义排序String[]:");
        Arrays.sort(nums, (a,b) -> ((b+a).compareTo(a+b)));
        System.out.println(Arrays.toString(nums));
        System.out.println("--------------------------------");

        // 自带排序方法
        // List
        System.out.println("自带排序方法List:");
        List<Integer> list = Arrays.asList(3, 1, 4, 1, 5);
        // 1.直接调用
        Collections.sort(list);
        System.out.println(list);
        // 2.自定义降序排序
        list.sort(Comparator.reverseOrder());
        list.sort((a,b) -> (b-a));
        System.out.println(list);
        System.out.println("--------------------------------");

        // Arrays 这个只能对数字进行排序，要想对String排序要自定义逻辑
        System.out.println("自带排序int[]:");
        int[] nums1 = new int[]{10000, 111, 129, 1888, 2, 322, 899, 9, 921};
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
        System.out.println("--------------------------------");
        // Attention: int[]不能直接在Arrays.sort()中自定义排序规则，因为int是基本数据类型; double[]等等基本数据类型的都不可以

        // TreeSet
        System.out.println("自带排序方法treeSet:");
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(8);
        System.out.println(treeSet);
        System.out.println("--------------------------------");

        // TreeMap 按照key值的‘字典顺序’升序排序
        System.out.println("自带排序方法treeMap String:");
        Map<String, String> treeMap1 = new TreeMap<>();
        treeMap1.put("400", "five");
        treeMap1.put("8", "two");
        treeMap1.put("200", "eight");
        System.out.println(treeMap1);
        System.out.println();

        System.out.println("自带排序方法treeMap Integer:");
        Map<Integer, String> treeMap2 = new TreeMap<>();
        treeMap2.put(400, "five");
        treeMap2.put(8, "two");
        treeMap2.put(200, "eight");
        System.out.println(treeMap2);
        System.out.println();

        // TreeMap自定义降序排序
        Map<Integer, String> customMap = new TreeMap<>(Comparator.reverseOrder());
        customMap.put(5, "five");
        customMap.put(2, "two");
        customMap.put(8, "eight");
        System.out.println(customMap);
        System.out.println("--------------------------------");

        // PriorityQueue 升序 只表现在peek()
        System.out.println("自带排序方法PriorityQueue:");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(2);
        pq.add(8);
        System.out.println(pq);

        // 自定义降序 只表现在peek()
        //PriorityQueue<Integer> customPQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> customPQ = new PriorityQueue<>((a,b) -> (b-a)); //这么写更直观更常用
        customPQ.add(5);
        customPQ.add(2);
        customPQ.add(8);
        System.out.println(customPQ);
        System.out.println("--------------------------------");
    }

    // Custom Comparator
    private static void sort1(){
        HashMap<String, Integer> person = new HashMap<>();
        person.put("Alice", 18);
        person.put("Ally", 20);
        person.put("Ash", 26);
        person.put("Belly", 16);
        person.put("Bob", 10);
        String[] people = {"Alice", "Ally", "Ash", "Belly", "Bob"};
        Arrays.sort(people, (p1, p2) -> (person.get(p1) - person.get(p2)));
        System.out.println(Arrays.toString(people));
    }

    // 按照自定义的字典序进行字典序排序
    private static void sort2(){
        String order = "zyxwvutsrqponmlkjihgfedcba";
        String[] productCodes = {"azz", "zaa", "xyz", "xyy", "auv", "abb"};
        HashMap<Character, Integer> sortOrder = new HashMap<>();
        char[] charOrder = order.toCharArray();
        for (int i = 0; i < order.length(); i++) {
            sortOrder.put(charOrder[i], i);
        }
        Arrays.sort(productCodes, (a, b) -> {
            if (a.length() != b.length()) return a.length() - b.length();
            else {
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) != b.charAt(i)) {
                        return sortOrder.get(a.charAt(i)) - sortOrder.get(b.charAt(i));
                    }
                }
            }
            return 0;
        });
        System.out.println(Arrays.toString(productCodes));
    }

    /* 多重排序条件 */
    private static void sort3(){
        // Arrays.sort(T[] a, Comparator<? super T> c)
        int[][] nums = new int[][]{{2,2},{1,3},{2,1}};
        //先按照nums[0]排序，如果nums[0]相等，再按照nums[1]排序
        Arrays.sort(nums, (a,b) -> {
            if(a[0] != b[0]) return a[0]-b[0];
            else return a[1]-b[1];
        });
        System.out.println(Arrays.deepToString(nums));
    }
}