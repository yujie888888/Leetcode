/**
 * An AWS client has brought servers and databases from data centers in different parts of the world fortheir application.
 * For simplicity, let's assume all theservers and data centers are located on a 1.dimensional line.
 * You have been given the task of optimizing the network connection. Each data center must beconnected to a server.
 * The positions of n datacenters and n servers are given in the form ofarrays.
 * Any particular data center, center i, candeliver to any particular server destination j.
 * The lag is defined distance betweena data center at location x and a server destination at location yis x-y, i...
 * the absolute difference between x and y Determine the minimum lag to establish the entire network.
 * Example
 * There are n = 3 connections, the positions of datacenters, center= [1, 2, 2l, and the positions of theserver destinations,destination = [5, 2, 4].
 * The most efficient deliveries are:
 * The center at location 1 makes the first connectionto the server at location 2.
 * The center at location 2 makes the secondconnection to the server at location 4.
 */
package Company_Amazon;
import java.util.Arrays;

public class P10_OptimizingNetworkConnection {
    /**Greedy
     * O(nlogn)
     */
    public static void main(String[] args) {
        int[] center = {1,2,2};
        int[] destination = {5,2,4};
        Arrays.sort(center);
        Arrays.sort(destination);
        int sum = 0;
        for(int i=0; i<center.length; i++){
            sum+=Math.abs(center[i]-destination[i]);
        }
        System.out.println(sum);
    }
}
