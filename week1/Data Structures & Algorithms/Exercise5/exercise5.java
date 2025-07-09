class Task {
    String taskId;
    String taskName;
    String status;
    Task next;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    @Override
    public String toString() {
        return taskId + " | " + taskName + " | " + status;
    }
}

// 3. Implementation: Singly Linked List
class TaskManager {
    private Task head;

    // Add task to the end
    public void addTask(String taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);
        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
    }

    // Search task by ID
    public Task searchTask(String taskId) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId.equals(taskId)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Traverse tasks
    public void traverseTasks() {
        Task temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // Delete task by ID
    public boolean deleteTask(String taskId) {
        if (head == null) return false;

        if (head.taskId.equals(taskId)) {
            head = head.next;
            return true;
        }

        Task prev = null;
        Task curr = head;
        while (curr != null && !curr.taskId.equals(taskId)) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) return false;

        prev.next = curr.next;
        return true;
    }
}

public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask("T001", "Design UI", "Pending");
        manager.addTask("T002", "Implement Login", "In Progress");
        manager.addTask("T003", "Test Module", "Pending");

        System.out.println("\nAll Tasks:");
        manager.traverseTasks();

        System.out.println("\nSearch T002:");
        Task found = manager.searchTask("T002");
        System.out.println(found != null ? found : "Not Found");

        System.out.println("\nDelete T001:");
        boolean removed = manager.deleteTask("T001");
        System.out.println(removed ? "Deleted Successfully." : "Task Not Found.");

        System.out.println("\nTasks After Deletion:");
        manager.traverseTasks();
    }
}