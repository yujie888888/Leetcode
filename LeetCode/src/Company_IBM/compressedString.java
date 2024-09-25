package Company_IBM;
/**
 * This problem describes a string compression algorithm and asks you to implement it as a function. Here's a summary of the key points:
 * The compression technique counts consecutive occurrences of characters in a string.
 * For a given input string, the algorithm should:
 * Add a single character to the output if it occurs only once.
 * Add the character followed by the count of consecutive occurrences if it appears multiple times in a row.
 * Example:
 * Input: "abaasass"
 * Output: "aba2sas2"
 * Function details:
 * Name: compressedString
 * Parameter: string message (the input string to compress)
 * Return: string (the compressed message)
 * Constraints:
 * message[i] ∈ ascii[a-z] (input consists of lowercase ASCII letters)
 * |message| ≤ 10^5 (input string length is at most 100,000 characters)
 * The task is to implement this compressedString function that takes a string as input and returns its compressed
 * form according to the described algorithm.
 */
public class compressedString {
    public static void main(String[] args) {
        String str = "abaaaaaaaaaaaaaaasass";
        System.out.println(compressedString(str));

    }
    public static String compressedString(String str){
        StringBuilder sb = new StringBuilder();
        int n = str.length();
        int i=0, j=0;
        while(j<n){
            int count = 0;
            while(count<9 && j<n && str.charAt(i) == str.charAt(j)){
                count++;
                j++;
            }
            sb.append(str.charAt(i));
            if(count > 1) sb.append(count);
            i=j;
        }
        return sb.toString();
    }
}
