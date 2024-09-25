package ALG_Regex;
import java.util.Arrays;

/**
 * 你有一个包含多个字符串的列表，这些字符串可能代表有效的纬度/经度对。你的任务是检查给定的纬度/经度对是否合法。
 * 一个字符串 (X, Y) 被认为是有效的，如果满足以下条件：
 * 字符串以括号开头，逗号位于 X 和 Y 之间，以括号结尾。
 * X 的第一个字符和开头括号之间没有空格。
 * X 的最后一个字符和逗号之间没有空格。
 * Y 的第一个字符和逗号之间没有空格。
 * Y 的最后一个字符和闭括号之间没有空格。
 * X 和 Y 是十进制数字，可以有符号。
 * X 和 Y 没有前导零。
 * X 和 Y 中没有其他字符。
 * X 的范围是 -90 <= X <= 90，Y 的范围是 -180 <= Y <= 180。
 * 编写一个算法来识别给定的字符串列表中有效和无效的纬度/经度对。
 * 输入：
 * 第一行输入一个整数 input_size，表示字符串列表的大小 (N)。
 * 第二行包含 N 个用空格分隔的子字符串，表示纬度/经度对。
 * 输出：
 * 输出 N 个用空格分隔的字符串，表示每个纬度/经度对是否合法。合法的输出为 "Valid"，不合法的输出为 "Invalid"。
 * 约束：
 * 1≤N≤100
 * 示例：
 * 输入：
 * 5
 * (90,180) (+90,+180) (90.,180) (90.0,180.1) (855,95W)
 * 输出：
 * 复制代码
 * Valid Valid Invalid Invalid Invalid
 * 解释：
 * 字符串 "(90,180)" 和 "(+90,+180)" 是有效的，因为它们符合给定条件。
 * "(90.,180)" 是无效的，因为它在 90 后多了一个小数点。
 * "(90.0,180.1)" 是无效的，因为 180.1 超出了经度的有效范围。
 * "(855,95W)" 是无效的，因为 855 超出了纬度范围且包含非法字符 W。
 */
public class Coordinate {
    /**Regex
     * 好复杂
     */
    public static void main(String[] args) {
        String[] coor = new String[]{"(90,180 )", "(+90,--180)", "(90.,180)", "(*90.0,180.1)", "(855,95W)"};
        String[] res = new String[coor.length];
        int i=0;
        for(String str : coor){
            if(isValidLatLongPair(str)){
                res[i] = "Valid";
            }
            else{
                res[i] = "Invalid";
            }
            i++;
        }
        System.out.println(Arrays.toString(res));
    }
    /**
     * 字符串以括号开头，逗号位于 X 和 Y 之间，以括号结尾。
     * 前后无空格：
     *   X 的第一个字符和开头括号之间没有空格。
     *   Y 的最后一个字符和闭括号之间没有空格。
     * 逗号前后无空格：
     *   X 的最后一个字符和逗号之间没有空格。
     *   Y 的第一个字符和逗号之间没有空格。
     * X和Y只包含+ - 数字：
     *   X 和 Y 是十进制数字，可以有符号。
     *   X 和 Y 中没有其他字符。
     * X和Y没有前导0
     *   X 和 Y 没有前导零。
     * X和Y的取值范围：
     *   X 的范围是 -90 <= X <= 90，Y 的范围是 -180 <= Y <= 180
     */
    private static boolean isValidLatLongPair(String pair) {
        // 检查是否有空格
        if (pair.contains(" ")) {
            return false;
        }

        // 检查格式是否是 (X,Y) 的形式
        if (!pair.startsWith("(") || !pair.endsWith(")")) {
            return false;
        }

        // 去掉括号后，按逗号分割成两部分
        String[] coordinates = pair.substring(1, pair.length() - 1).split(",");
        String latStr = coordinates[0];
        String lonStr = coordinates[1];

        // 检查两个部分是不是只包含number和+-和.
        if (!latStr.matches("^[+-]?\\d+(\\.\\d+)?$")){ //可以有+-，可以有. 但是如果出现了.后面必须跟数字
            return false;
        }
        if (!lonStr.matches("^[+-]?\\d+(\\.\\d+)?$")){
            return false;
        }

        // 去掉经纬度的符号部分
        String latNumericPart = latStr.startsWith("+") || latStr.startsWith("-") ? latStr.substring(1) : latStr;
        String lonNumericPart = lonStr.startsWith("+") || lonStr.startsWith("-") ? lonStr.substring(1) : lonStr;

        // 检查前导零（非小数的整数部分不能有前导零）
        if (latStr.matches("^[+-]?0\\d+")) { // 如果是以0开头但不是小数，说明有前导零
            return false;
        }
        if (lonStr.matches("^[+-]?0\\d+")) { // 经度检查同理
            return false;
        }

        // 提取经度和纬度，转换为浮点数
        double lat, lon;
        try {
            lat = Double.parseDouble(latStr);
            lon = Double.parseDouble(lonStr);
        } catch (NumberFormatException e) {
            return false; // 如果无法转换为数字，则返回错误
        }

        // 验证 X（纬度）是否在 [-90, 90] 之间
        if (lat < -90 || lat > 90) {
            return false;
        }

        // 验证 Y（经度）是否在 [-180, 180] 之间
        if (lon < -180 || lon > 180) {
            return false;
        }

        return true;
    }

}
