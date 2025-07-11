package com.ecommerce.search;

import java.util.Arrays;
import java.util.Comparator;

public class BinarySearch {

    // Method to perform binary search on an array of Product objects
    public static Product searchProductByName(Product[] productList, String targetProductName) {
        // Sort the product list alphabetically by product name (case-insensitive)
        Arrays.sort(productList, Comparator.comparing(p -> p.productName.toLowerCase()));

        int left = 0;
        int right = productList.length - 1;

        // Binary search loop
        while (left <= right) {
            int middle = (left + right) / 2;

            // Compare the target name with the middle product's name
            int comparisonResult = targetProductName.compareToIgnoreCase(productList[middle].productName);

            if (comparisonResult == 0) {
                // Match found
                return productList[middle];
            } else if (comparisonResult < 0) {
                // Target is in the left half
                right = middle - 1;
            } else {
                // Target is in the right half
                left = middle + 1;
            }
        }

        // Product not found
        return null;
    }
}
