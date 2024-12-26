import java.util.ArrayList;
import java.util.Scanner;


class Task {
    private int id;
    private String title;
    private String description;

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + "\nTitle: " + title + "\nDescription: " + description + "\n";
    }
}

public class TaskManager {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int taskIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTask Manager");
            System.out.println("1. Create Task");
            System.out.println("2. Read Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createTask(scanner);
                    break;
                case 2:
                    readTasks();
                    break;
                case 3:
                    updateTask(scanner);
                    break;
                case 4:
                    deleteTask(scanner);
                    break;
                case 5:
                    System.out.println("Exiting Task Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void createTask(Scanner scanner) {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        Task task = new Task(taskIdCounter++, title, description);
        tasks.add(task);
        System.out.println("Task created successfully!\n" + task);
    }

    private static void readTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nList of Tasks:");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    private static void updateTask(Scanner scanner) {
        System.out.print("Enter task ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Task taskToUpdate = findTaskById(id);
        if (taskToUpdate != null) {
            System.out.print("Enter new title: ");
            String newTitle = scanner.nextLine();
            System.out.print("Enter new description: ");
            String newDescription = scanner.nextLine();

            taskToUpdate.setTitle(newTitle);
            taskToUpdate.setDescription(newDescription);
            System.out.println("Task updated successfully!\n" + taskToUpdate);
        } else {
            System.out.println("Task not found.");
        }
    }

    private static void deleteTask(Scanner scanner) {
        System.out.print("Enter task ID to delete: ");
        int id = scanner.nextInt();

        Task taskToDelete = findTaskById(id);
        if (taskToDelete != null) {
            tasks.remove(taskToDelete);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Task not found.");
        }
    }

    private static Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}
