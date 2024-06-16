/**
 * A barcode scanner can be configured by scanning a series of barcodes in the correct order.
 * Barcode configurations are encoded into a single string and stored as a blob in the backend system.
 * The client requests the configuration from the backend configuration service, and then needs to present the configurations in the correct order.
 * The encoded configuration string is a series of <ordinal-index>/<configuration> pairs separated by '|'.
 * The ordinal index value is a 4 digit numeric prefix within zeros. For example, the first configuration will be represented as 0001.
 * The goals are to 1) validate the configuration string and 2) provide the configuration client the configuration values in the order required
 * to successfully configure the barcode scanner.
 * Validation conditions
 * All configurations must be separated by a '|' character.
 * Configurations cannot skip a number in the ordering; if there are three configuration strings, there must be a 1, 2, and 3 index.
 * Configuration values are alphanumeric and may contain no other characters.
 * Ordinal indices may not repeat; for example there cannot be two occurrences of the number "11".
 * Each configuration value is unique, configurations do not repeat.
 * The configuration ordinal index configurations cannot skip a value.
 * If a configuration string is not valid, return ["Invalid configuration"].
 * Function Description
 * Complete the function orderedConfiguration in the editor.
 * orderedConfiguration has the following parameters:
 * str configuration: the encoded configuration string
 * Returns
 * str configuration[]: an array of configurations in the correct order
 * Example 1:
 * Input:  configuration = "0001LAJ5KBX9H8|0003UKURNK403F|0002MO6K1Z9WFA|0004OWRXZFMS2C"
 * Output: ["LAJ5KBX9H8", "MO6K1Z9WFA", "UKURNK403F", "OWRXZFMS2C"]
 * Explanation:
 * The value "LAJ5KBX9H8" is prefixed with an order value of "0001", so it is listed first.
 * Even though "MO6K1Z9WFA" appears third in the string, it is prefixed with "0002" so it is rereturned second.
 * "UKURNK403F" appears second in the configuration string, but is prefixed with "0003" so is listed third.
 * Lastly, "OWRXZFMS2C" is prefixed with 0004 so is listed fourth.
 * Example 2:
 * Input:  configuration = "000533B8XLD2EZ|0001DJ2M2JBZZR|0002Y9YK0A7MYO|0004IKDJCAPG5Q|0003IBHMH59SBO"
 * Output: ["DJ2M2JBZZR", "Y9YK0A7MYO", "IBHMH59SBO", "IKDJCAPG5Q", "33B8XLD2EZ"]
 * Explanation:
 * No explanation for now
 * Example 3:
 * Input:  configuration = "0002f7c22e7904|000176a3a4d214|000305d29f4a4b"
 * Output: ["76a3a4d214", "f7c22e7904", "05d29f4a4b"]
 * Explanation:
 * Based on the 'order' value, the expected output is:
 * [
 *   "76a3a4d214", #0001
 *   "f7c22e7904", #0002
 *   "05d29f4a4b"  #0003
 * ]
 * Example 4:
 * Input:  configuration = "0002f7c22e7904|000176a3a4d214|000205d29f4a4b"
 * Output: ["Invalid configuration"]
 * Explanation:
 * configuration string constains two indices for "0002", so the expected output is ["Invalid configuration"].
 * Constraints:
 * 1 ≤ orders ≤ 9999
 * 1 ≤ orders(configuration) ≤ 9999
 * Order values may not be unique or complete
 * Configuration values are not always unique, the same configuration may appear in multiple configuration steps
 */
package Company_Amazon;
import java.util.Arrays;

public class P20_OrderedConfiguration {
    public static void main(String[] args) {
        String configuration = "0001LAJ5KBX9H8|0003UKURNK403F|0002MO6K1Z9WFA|0005OWRXZFMS2C";
        System.out.println(Arrays.toString(orderedConfiguration(configuration)));
    }
    /**Custom Comparator
     * O(nlogn)
     * Ideas:
     * 1.先自定义比较器按照prefix进行排序
     * 2.更新str，只保留从4开始的char
     * 3.在更新str的时候检查prefix是不是唯一的-->不是-->Invalid
     *                检查perfix是不是完整的-->不是-->Invalid
     * Cautions:
     * 1.split("\\|")
     * 2.process missing index
     */
    private static String[] orderedConfiguration(String conf){
        String[] str = conf.split("\\|");
        Arrays.sort(str,(a,b)->(a.substring(0,4).compareTo(b.substring(0,4))));
        for(int i=0; i<str.length; i++){
            if(i+1<str.length){
                String si = str[i].substring(0,4);
                String sii = str[i+1].substring(0,4);
                if(si.equals(sii) || Integer.parseInt(sii)-Integer.parseInt(si)>1){
                    return new String[]{"Invalid configuration"};
                }
            }
            str[i] = str[i].substring(4,str[i].length());
        }
        return str;
    }
}
