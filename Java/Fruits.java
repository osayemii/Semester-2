import java.util.*;

public class Fruits {

    public static void main(String[] args) {
        Collection<String> Fruits = new ArrayList<>();

        // Adding fruits to the collection
        Fruits.add("Apple");
        Fruits.add("Banana");
        Fruits.add("Mango");

        // Displaying the fruits
        System.out.println("Fruits: " + Fruits);

        // check if it contains an element
        System.out.println("Contains Apple: " + Fruits.contains("Apple"));

        // Remove an element
        Fruits.remove("Banana");
        System.out.println("After removing Banana: " + Fruits);

        // Iterate through the collection
        System.out.println("Iterating through fruits:");
        for (String fruit : Fruits) {
            System.out.println(fruit);
        }

        // Size of the collection
        System.out.println("Number of fruits: " + Fruits.size());
    }
}