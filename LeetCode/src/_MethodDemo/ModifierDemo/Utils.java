package _MethodDemo.ModifierDemo;

public class Utils {
    //1.2.public static 属于class本身的行为，它们可以在不创建类的实例的情况下被访问和使用
    int a;
    //add()方法没用到Utils class的属性
    public static int add(int a, int b) {
        return a + b;
    }
}
