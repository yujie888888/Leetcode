import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InterviewAssignment {
    public static void main(String[] args) {
        // 人
        List<String> people = new ArrayList<>();
        people.add("Aria");
        people.add("Maria");
        people.add("Rabbit");
        people.add("Kaiyu");
        people.add("Simon");
        people.add("CC");

        // 随机打乱
        Collections.shuffle(people);

        System.out.println("面试分组：");
        for (int i = 0; i < people.size(); i++) {
            String interviewer = people.get(i);
            String interviewee = people.get((i + 1) % people.size()); // 循环分配
            System.out.println(interviewer + " 面 " + interviewee);
        }
    }
}
