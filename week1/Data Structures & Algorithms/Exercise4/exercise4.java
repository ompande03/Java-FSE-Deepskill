class Employee {
    String employeeId;
    String name;
    String position;
    double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return employeeId + " | " + name + " | " + position + " | $" + salary;
    }
}

// 3. Implementation: Employee array and operations
class EmployeeManager {
    private Employee[] employees;
    private int size;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add employee
    public boolean addEmployee(Employee emp) {
        if (size >= employees.length) {
            System.out.println("Employee list is full.");
            return false;
        }
        employees[size++] = emp;
        return true;
    }

    // Search employee by ID
    public Employee searchEmployee(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(id)) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete employee by ID
    public boolean deleteEmployee(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(id)) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                return true;
            }
        }
        return false;
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        manager.addEmployee(new Employee("E001", "Alice", "Manager", 70000));
        manager.addEmployee(new Employee("E002", "Bob", "Developer", 50000));
        manager.addEmployee(new Employee("E003", "Charlie", "Tester", 45000));

        System.out.println("\nAll Employees:");
        manager.traverseEmployees();

        System.out.println("\nSearching for E002:");
        Employee emp = manager.searchEmployee("E002");
        System.out.println(emp != null ? emp : "Not Found");

        System.out.println("\nDeleting E001:");
        boolean deleted = manager.deleteEmployee("E001");
        System.out.println(deleted ? "Deleted successfully." : "Not Found.");

        System.out.println("\nAll Employees after deletion:");
        manager.traverseEmployees();
    }
}