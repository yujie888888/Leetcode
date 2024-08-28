package _MethodDemo.ModifierDemo;
import java.util.Date;

public class StringMethod {
    public static void main(String[] args){
        //1.字符串格式化
        String name = "Alice";
        String formattedString1 = String.format("Hello, %s!", name);
        System.out.println(formattedString1);  // 输出: Hello, Alice!

        String firstName = "John";
        String lastName = "Doe";
        String formattedString2 = String.format("Name: %s %s", firstName, lastName);
        System.out.println(formattedString2);  // 输出: Name: John Doe

        //2. 整数格式化
        //基本整数替换
        int age = 30;
        String formattedString3 = String.format("Age: %d years", age);
        System.out.println(formattedString3);  // 输出: Age: 30 years

        //带符号的整数
        int temperature = -5;
        String formattedString4 = String.format("Temperature: %+d°C", temperature);
        System.out.println(formattedString4);  // 输出: Temperature: -5°C

        //整数补零
        int number = 7;
        String formattedString5 = String.format("Number: %03d", number);
        System.out.println(formattedString5);  // 输出: Number: 007

        //3. 浮点数格式化
        //基本浮点数替换
        double price = 123.456;
        String formattedString6 = String.format("Price: %.2f", price);
        System.out.println(formattedString6);  // 输出: Price: 123.46

        //科学计数法
        double bigNumber = 12345678.9;
        String formattedString7 = String.format("Scientific: %e", bigNumber);
        System.out.println(formattedString7);  // 输出: Scientific: 1.234568e+07

        //大小写科学计数法
        double bigNumber1 = 12345678.9;
        String formattedString8 = String.format("Scientific: %e", bigNumber1);
        String formattedString9 = String.format("Scientific: %E", bigNumber1);
        System.out.println(formattedString8);  // 输出: Scientific: 1.234568e+07
        System.out.println(formattedString9);  // 输出: Scientific: 1.234568E+07

        //4. 字符格式化
        //字符替换
        char initial = 'A';
        String formattedString10 = String.format("Initial: %c", initial);
        System.out.println(formattedString10);  // 输出: Initial: A

        //5. 布尔值格式化
        boolean isLoggedIn = true;
        String formattedString11 = String.format("Logged in: %b", isLoggedIn);
        System.out.println(formattedString11);  // 输出: Logged in: true

        //6. 对齐和宽度控制
        //右对齐
        String text1 = "cat";
        String formattedString12 = String.format("%5s", text1);
        System.out.println(formattedString12);  // 输出: "  cat"（右侧填充两个空格）

        //左对齐
        String text2 = "cat";
        String formattedString13 = String.format("%-5s", text2);
        System.out.println(formattedString13);  // 输出: "cat  "（左对齐，右侧填充两个空格）

        //设置宽度并补零
        int number1 = 42;
        String formattedString14 = String.format("%05d", number1);
        System.out.println(formattedString14);  // 输出: 00042

        //7.日期格式化
        //日期格式化
        String formattedString15 = String.format("Today is %tB %te, %tY", new Date(), new Date(), new Date());
        System.out.println(formattedString15);  // 输出: Today is August 16, 2024

        //日期和时间格式化
        String formattedString16 = String.format("Time: %tH:%tM:%tS", new Date(), new Date(), new Date());
        System.out.println(formattedString16);  // 输出: Time: 14:30:45

        //8.指定数值的进制
        //输出十六进制、八进制和二进制
        int number2 = 255;
        String hexString = String.format("Hex: %x", number2);
        String octalString = String.format("Octal: %o", number2);
        String binaryString = String.format("Binary: %s", Integer.toBinaryString(number2));

        System.out.println(hexString);   // 输出: Hex: ff
        System.out.println(octalString); // 输出: Octal: 377
        System.out.println(binaryString);// 输出: Binary: 11111111

    }
}
