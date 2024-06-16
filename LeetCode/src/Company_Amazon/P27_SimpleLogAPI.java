/**
 * regiser login and logout （hashmap处理，分清情况讨论，注意logout的时候输入没有psw的边界情况，容易出现指针越界）
 * 写一个简单的api，有三个功能 register，log in，log out。
 * register的时候要输入name和password，如果这个用户已经register过了要返回username already exists，没有的话返回registered successfully；
 * log in时也要name和password，如果该name并没有register或者已经logged in，或者password错误，要返回log in unsuccessful，如果都满足就返回logged in successfully；
 * 最后是log out，也是很直观的逻辑，正常的话返回成功，
 * 没有register或者没有log in的name要返回log out失败。
 * 这道题不是要你去写class，而是一个函数，通过输入a list of strings然后你自己去parse出以上三个指令
 */
package Company_Amazon;
import java.util.HashMap;
import java.util.Scanner;

public class P27_SimpleLogAPI {
    /**API
     * 用一个map1存 注册(name，password)pairs
     * 用一个map2存 登陆(name,psd) pairs
     * 选择功能(1,2,3) 选择
     *   功能状态：
     *     1.注册时：输入name和psd
     *       如果name已经存在，map1.contains(),返回“username already exists”
     *       不存在，返回registered successfully
     *     2.登陆时：输入name和psd
     *       如果!map1.contains(),返回“log in unsuccessful”--没有这个账号
     *       如果map1.get(key)!=psd,返回“log in unsuccessful”--密码不匹配
     *       如果登陆成功：把map1.pairs -> map2中
     *     3.登出
     *       将map2的pair转移到map1中
     *       如果为空，返回“no account”
     * 通过输入a list of strings然后你自己去parse出以上三个指令
     */
    public static void main(String[] args) {
        String operations = "register,login,logout,login,register,logout,logout,logout";
        String[] opera = operations.split(",");
        HashMap<String,String> map1 = new HashMap<>();
        HashMap<String,String> map2 = new HashMap<>();
        for(String op: opera){
            System.out.println("You are in the command "+op);
            switch (op) {
                case "register":
                    System.out.println(register(map1));
                    break;
                case "login":
                    System.out.println(login(map1, map2));
                    break;
                case "logout":
                    System.out.println(logout(map1, map2));
                    break;
                default:
                    System.out.println("invalid command");
            }
            System.out.println("----------------------------");
        }
    }

    public static String register(HashMap<String,String> map1){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the new username:");
        String name = sc.nextLine();
        if(map1.containsKey(name)) return "username already exists";
        System.out.println("Input the new password:");
        String password = sc.nextLine();
        map1.put(name,password);
        return "register successfully!";
    }
    public static String login(HashMap<String,String> map1, HashMap<String,String> map2){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input your username:");
        String name = sc.nextLine();
        if(!map1.containsKey(name)) return "log in unsuccessful";
        System.out.println("Input the new password:");
        String password = sc.nextLine();
        if(!map1.get(name).equals(password)) return "log in unsuccessful!";
        map2.put(name,password);
        map1.remove(name);
        return "log in successful!";
    }
    public static String logout(HashMap<String,String> map1, HashMap<String,String> map2){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the username you want to logout:");
        String name = sc.nextLine();
        if(!map2.containsKey(name)) return "logout unsuccessful";
        map1.put(name,map2.get(name));
        map2.remove(name);
        return "log out successful!";
    }
}
