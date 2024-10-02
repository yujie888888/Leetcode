package Company_icc;

//import java.awt.print.Book;
// 1. Create class "Product" which has two string type fields: Category, Name
//    Create class "Shop" which has a field: List of Products
// 2. Create a constructor in "Shop" and initialize the List of Products with following 5 products:
//      Category: Book, Name: "Python", "Java", "Scala"
//      Category: Phone. Name: "Iphone", "Pixel"
//      3. Define a method, getSortedProduct(String category) which returns a list of product names in the given category.
//         Use the main method to print the return.
//      4. Define a method, findAllCategories() which returns a Set of categories. Use the main method to print the return.


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

// 不懂为啥非要用到Product Class，不用也能做啊
class Product{
    String Name;
    String Category;

    public Product(String Category, String Name){
        this.Category = Category;
        this.Name = Name;
    }
}

class Shop{
    HashMap<String, List<String>> map;

    public Shop(){
        addProduct(new Product("Book","Python"));
        addProduct(new Product("Book", "Java"));
        addProduct(new Product("Book", "Scala"));
        addProduct(new Product("Phone", "Iphone"));
        addProduct(new Product("Phone", "Pixel"));
    }

    public void addProduct(Product p){
        if(map == null) map = new HashMap();
        if(!map.containsKey(p.Category)){
            map.put(p.Category,new ArrayList<>());
        }
        map.get(p.Category).add(p.Name);
    }

    public List<String> getSortedProduct(String category){
        return map.get(category);
    }

    public Set<String> findAllCategories(){
        return map.keySet();
    }
}

public class pilot2 {
    public static void main(String[] args) {
        Shop p = new Shop();
        System.out.println(p.getSortedProduct("Book"));
        System.out.println(p.findAllCategories());
    }
}

