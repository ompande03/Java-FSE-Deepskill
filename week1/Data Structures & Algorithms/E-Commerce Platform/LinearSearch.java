package com.ecommerce.search;

public class LinearSearch {

    // Method to perform linear search on an array of Product objects
    public static Product searchProductByName(Product[] productList, String targetProductName) {
        // Iterate through each product in the list
        for (Product item : productList) {
            // Compare product name with the target (case-insensitive)
            if (item.productName.equalsIgnoreCase(targetProductName)) {
                return item; // Product found
            }
        }
        // If no match is found, return null
        return null;
    }
}
