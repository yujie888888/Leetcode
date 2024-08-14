/**
 * array of currency conversion rates. E.g. ['USD', 'GBP', 0.77] which means 1 USD is equal to 0.77 GBP
 * an array containing a 'from' currency and a 'to' currency
 * Given the above parameters, find the conversion rate that maps to the 'from' currency to the 'to' currency.
 * Your return value should be a number.
 * Example:
 * You are given the following parameters:
 * Rates: [['USD', 'JPY', 110], ['US', 'AUD', 1.45], ['JPY', 'GBP', 0.0070]]
 * To/From currency ['GBP', 'AUD']
 * Find the rate for the 'To/From' curency. In this case, the correct result is 1.89.
 */
package Company_Uber;
import java.util.*;

public class P1_CurrencyConversionRates {
    public static class Node {
        String start;
        String end;
        double rate;

        public Node(String start, String end, double rate) {
            this.start = start;
            this.end = end;
            this.rate = rate;
        }
    }
    public static void main(String[] args) {
        List<List<String>> Countries = Arrays.asList(
                Arrays.asList("USD", "JPY"),
                Arrays.asList("USD", "AUD"),
                Arrays.asList("JPY", "GBP"),
                Arrays.asList("CHY", "AUD")
        );
        double[] rates = {110, 1.45, 0.007, 0.21};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("GBP", "AUD"),
                Arrays.asList("CHY", "USD"),
                Arrays.asList("JPY", "USD"),
                Arrays.asList("GBP", "GBP")
        );
        //1.List<Node>
        List<Node> nodes = new ArrayList<>();
        int i = 0;
        for (List<String> l : Countries) {
            nodes.add(new Node(l.get(0), l.get(1), rates[i]));
            i++;
        }
        //HashMap
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        for (Node n : nodes) {
            if (!map.containsKey(n.start)) map.put(n.start, new HashMap<String, Double>());
            map.get(n.start).put(n.end, n.rate);
            if (!map.containsKey(n.end)) map.put(n.end, new HashMap<String, Double>());
            map.get(n.end).put(n.start, 1.0 / n.rate);
        }
        double[] res = new double[queries.size()];
        int j = 0;
        for (List<String> q : queries) {
            if (q.get(0) == q.get(1)) {
                res[j] = 1.0;
                continue;
            } else if (!map.containsKey(q.get(0)) || !map.containsKey(q.get(1))) {
                res[j] = -1.0;
            } else {
                res[j] = dfs(q.get(0),q.get(1),map,new HashSet<>(),1.0);
            }
            j++;
        }
        System.out.println(Arrays.toString(res));
    }

    public static double dfs(String start, String end, HashMap<String, HashMap<String, Double>> map, HashSet<String> set, double val) {
        set.add(start);
        double res = -1.0;
        if (map.get(start).containsKey(end)) {
            return val * map.get(start).get(end);
        } else {
            for (String next : map.get(start).keySet()) {
                if (set.contains(next)) continue;
                res = dfs(next, end, map, set, val * map.get(start).get(next));
                if (res != -1.0) break;
            }
        }
        return res;
    }
}
