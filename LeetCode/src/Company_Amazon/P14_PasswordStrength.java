/**
 * Your team at Amazon has recently adopted a new password validation scheme for internal user accounts.
 * A password consists of lowercase English letters only and is valid only if it contains at least one vowel and at least one consonant.
 * Vowels are the characters 'a','e','i','o','u'. The rest are consonants.
 * For each substring of the password which contains at least one vowel and one consonant, its strength goes up by 1.
 * Given a password string, find its strength. Return 0 if the password itself is not valid.
 * Example:
 * password="hackerrank"
 * output:3
 */
package Company_Amazon;

public class P14_PasswordStrength {
    public static void main(String[] args) {
        String password = "hackerrank";
        System.out.println(password1(password));
        System.out.println(password2(password));
    }
    /**Greedy
     * O(n)
     * O(1)
     * Ideas:
     * 1.Actually the answer is to find how much (vowel,consonant) pairs we can find of password
     */
    private static int password1(String password) {
        int vowel = 0;
        int consonant = 0;
        int res = 0;

        for (char l : password.toCharArray()) {
            if (l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u') {
                vowel++;
            } else {
                consonant++;
            }
            if (vowel >= 1 && consonant >= 1) {
                res++;
                vowel = 0;
                consonant = 0;
            }
        }
        return res;
    }
    private static int password2(String password) {
        boolean vowel = false;
        boolean consonant = false;
        int res = 0;

        for (char l : password.toCharArray()) {
            if (l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u') {
                vowel=true;
            } else {
                consonant=true;
            }
            if (vowel && consonant) {
                res++;
                vowel = false;
                consonant = false;
            }
        }
        return res;
    }
}
