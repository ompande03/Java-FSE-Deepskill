class Product {
    String productId;
    String productName;
    String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return productId + " | " + productName + " | " + category;
    }
}

// 3. Implementation: Linear Search and Binary Search
class SearchEngine {

    // Linear Search by productName
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search by productName
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(targetName);
            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Sort products by productName for Binary Search
    public static void sortProducts(Product[] products) {
        java.util.Arrays.sort(products, (p1, p2) -> p1.getProductName().compareToIgnoreCase(p2.getProductName()));
    }
}

public class EcommerceSearchFunction {
    public static void main(String[] args) {
        Product[] products = {
            new Product("101", "Laptop", "Electronics"),
            new Product("102", "Mouse", "Electronics"),
            new Product("103", "Shoes", "Apparel"),
            new Product("104", "Backpack", "Bags"),
            new Product("105", "Smartphone", "Electronics")
        };

        // Linear Search
        Product result1 = SearchEngine.linearSearch(products, "Mouse");
        System.out.println("Linear Search Result: " + (result1 != null ? result1 : "Not Found"));

        // Sort before Binary Search
        SearchEngine.sortProducts(products);

        // Binary Search
        Product result2 = SearchEngine.binarySearch(products, "Mouse");
        System.out.println("Binary Search Result: " + (result2 != null ? result2 : "Not Found"));
    }
}
