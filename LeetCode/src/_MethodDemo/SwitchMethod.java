package _MethodDemo;

public class SwitchMethod {
    public static void main(String[] args) {
//        expression：必须是一个可以被转换为整型值的表达式（Java 7 之后支持字符串），比如 int、char、byte、short、String 或枚举类型。
//        case：每个 case 表示 expression 与某个具体值的匹配。当匹配成功时，会执行该 case 中的代码。
//        break：break 用来结束当前 case 的执行，避免继续执行下一个 case。如果省略 break，程序会继续执行后面的 case，即使它们的条件不成立（称为“贯穿”）。
//        default：default 是可选的，表示当所有 case 都不匹配时执行的代码。
//        switch (expression) {
//            case value1:
//                // 语句1
//                break;
//            case value2:
//                // 语句2
//                break;
//            // 可以有多个 case
//            default:
//                // 默认语句
//        }

//        switch 表达式只能用于以下类型的值：
//        基本数据类型：byte, short, char, int
//        包装类型：Byte, Short, Character, Integer, String
//        枚举类型（enum）

        String fruit = "Apple";
        switch (fruit) {
            case "Apple":
                System.out.println("It's an Apple.");
                break;
            case "Banana":
                System.out.println("It's a Banana.");
                break;
            case "Mango":
                System.out.println("It's a Mango.");
                break;
            default:
                System.out.println("Unknown fruit.");
                break;
        }

        // 从 Java 12 开始，switch 引入了新的语法形式，可以将 switch 用作表达式，而不是单纯的语句
        // 与传统的 switch 语句相比，switch 表达式允许返回一个值，并且使用 -> 符号来替代 case 和 break 组合
        //result = switch (expression) {
        //    case value1 -> value;
        //    case value2 -> value;
        //    default -> defaultValue;
        //};

        int day = 3;
        String dayName = switch (day) {
            case 1 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            case 4 -> "Wednesday";
            case 5 -> "Thursday";
            case 6 -> "Friday";
            case 7 -> "Saturday";
            default -> "Invalid day";
        };
        System.out.println("Day is: " + dayName);
    }
}
