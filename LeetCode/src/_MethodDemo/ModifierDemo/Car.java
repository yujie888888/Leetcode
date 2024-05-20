package _MethodDemo.ModifierDemo;

public class Car {
    //1.1.public 当需要用到class属性时
    public String color;
    public int year;
    public Car(String color, int year) {
        this.color = color;
        this.year = year;
    }
    //displayInfo()这个public方法用到了Car class的属性
    public void displayInfo() {
        System.out.println("Car color: " + color + ", Year: " + year);
    }
}
