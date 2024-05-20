package _MethodDemo.ModifierDemo;

public class Demo {
    public static void main(String[] args) {
        //1.public
        //1.1.public 当需要用到class属性时
        Car c1 = new Car("red",2021);
        c1.displayInfo();
        //1.2.public static 属于class本身的行为，它们可以在不创建类的实例的情况下被访问和使用
        Utils u1 = new Utils();
        System.out.println(u1.add(1, 2));
    }
}
