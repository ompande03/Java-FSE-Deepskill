package ecommerce_platform;

import java.util.Arrays;
import java.util.Comparator;

class Product {
    int id;
    String name;
    String type;

    // Constructor to initialize Product fields
    public Product(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    // Method to perform linear search on the product array
    public static int performLinearSearch(Product[] productList, String searchName) {
        for (int index = 0; index < productList.length; index++) {
            if (productList[index].name.equalsIgnoreCase(searchName)) {
                return index;
            }
        }
        return -1;
    }

    // Method to perform binary search on the product array
    public static int performBinarySearch(Product[] productList, String searchName) {
        // Sort products alphabetically by name before binary search
        Arrays.sort(productList, Comparator.comparing(p -> p.name.toLowerCase()));

        int start = 0, end = productList.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int comparison = productList[mid].name.compareToIgnoreCase(searchName);

            if (comparison == 0)
                return mid;
            else if (comparison < 0)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    // Main method to test both search methods
    public static void main(String[] args) {
        Product[] inventory = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Shoes", "Fashion"),
                new Product(103, "Book", "Stationery"),
                new Product(104, "Camera", "Electronics")
        };

        // Testing linear search
        int resultLinear = performLinearSearch(inventory, "Camera");
        System.out.println("Linear Search Result Index: " + resultLinear);

        // Testing binary search
        int resultBinary = performBinarySearch(inventory, "Camera");
        System.out.println("Binary Search Result Index: " + resultBinary);
    }
}
