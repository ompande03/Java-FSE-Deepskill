class Order {
    String orderId;
    String customerName;
    double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return orderId + " | " + customerName + " | $" + totalPrice;
    }
}

// 3. Implementation of Sorting Algorithms
class OrderSorter {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
        System.out.println();
    }
}

public class SortCustomerOrders {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("O101", "Alice", 250.50),
            new Order("O102", "Bob", 125.00),
            new Order("O103", "Charlie", 320.99),
            new Order("O104", "Diana", 150.75),
            new Order("O105", "Evan", 90.00)
        };

        // Bubble Sort
        System.out.println("--- Bubble Sort ---");
        Order[] bubbleSorted = orders.clone();
        OrderSorter.bubbleSort(bubbleSorted);
        OrderSorter.printOrders(bubbleSorted);

        // Quick Sort
        System.out.println("--- Quick Sort ---");
        Order[] quickSorted = orders.clone();
        OrderSorter.quickSort(quickSorted, 0, quickSorted.length - 1);
        OrderSorter.printOrders(quickSorted);
    }
}