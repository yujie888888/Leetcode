/**
 * for a list a string, find all pairs
 * that words[I] is words[j] suffix or words[j] is words[i] suffix
 */
package Company_Uber;
import java.util.HashMap;
import java.util.Map;

public class P13_FindAllPairs {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }
    // Trie class
    static class Trie {
        TrieNode root = new TrieNode();
        // Insert a word in reverse order
        public void insert(String word) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                        node = node.children.computeIfAbsent(c, k -> new
                        TrieNode());
            }
            node.isEndOfWord = true;
        }
        // Search for a suffix in the trie
        public boolean searchSuffix(String word) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (!node.children.containsKey(c)) {
                    return false;
                }
                        node = node.children.get(c);
            }
            return node.isEndOfWord;
        }
    }
    public int pairCheck(String[] words) {
        Trie trie = new Trie();
        int count = 0;
        // Insert all words into the trie in reversed order
        for (String word : words) {
            trie.insert(word);
        }
        // Check each word against the trie for suffix match
        for (String word : words) {
        // Remove the word from the trie to avoid counting itself
            if (trie.searchSuffix(word)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        P13_FindAllPairs checker = new  P13_FindAllPairs();
        String[] words = {"apple", "ple", "banana", "na", "an"};
        int result = checker.pairCheck(words);
        System.out.println("Number of valid suffix pairs: "+result);
    }
}

