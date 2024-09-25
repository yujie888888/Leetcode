package DataStruc_String;

public class LC3163_StringCompressionIII {
    public static void main(String[] args) {

    }
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        int j=0;
        while(j<word.length()){
            int count = 0;
            while(count<9 && j<word.length() && word.charAt(i) == word.charAt(j)){
                count++;
                j++;
            }
            sb.append(count).append(word.charAt(i));
            i = j;
        }
        return sb.toString();
    }

}
