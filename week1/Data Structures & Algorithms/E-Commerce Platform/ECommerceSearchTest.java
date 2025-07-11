package com.ecommerce.search;

public class ECommerceSearchTest {

    public static void main(String[] args) {
        // Creating an array of Product objects (sample product catalog)
        Product[] productCatalog = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Shoes", "Footwear"),
                new Product(103, "Watch", "Accessories"),
                new Product(104, "Phone", "Electronics")
        };

        // Performing linear search for the product "Phone"
        Product linearSearchResult = LinearSearch.searchProductByName(productCatalog, "Phone");
        System.out.println("Linear Search Result: " +
                (linearSearchResult != null ? linearSearchResult : "Not Found"));

        // Performing binary search for the product "Phone"
        Product binarySearchResult = BinarySearch.searchProductByName(productCatalog, "Phone");
        System.out.println("Binary Search Result: " +
                (binarySearchResult != null ? binarySearchResult : "Not Found"));
    }
}
