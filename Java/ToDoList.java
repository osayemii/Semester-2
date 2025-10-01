import java.util.*;
import java.io.*;

class Task {
  String description;
  boolean completed;

  public final static String RED = "\u001B[31m";
  public final static String GREEN = "\u001B[32m";
  public final static String YELLOW = "\u001B[33m";
  public final static String RESET = "\u001B[0m";

  Task(String description) {
    this.description = description;
    this.completed = false;
  }

  void markCompleted() {
    this.completed = true;
  }

  @Override
  public String toString() {
    return (completed ? GREEN + "[X]" + RESET : "[ ] ") + description;
  }
}

public class ToDoList {
  ArrayList<Task> tasks;
  Scanner scanner;
  String filename;

  public ToDoList(String filename) {
    this.tasks = new ArrayList<>();
    this.scanner = new Scanner(System.in);
    this.filename = filename;
    loadTasks();
  }

  void addTask() {
    System.out.print("Enter task description: ");
    String description = scanner.nextLine();
    if (description.startsWith("[ ]") || description.startsWith("[]")) {
      System.out.println(Task.YELLOW + "Sorry, you can't start naming your task with [ ]." + Task.RESET);
    } else {
      tasks.add(new Task(description));
      saveTasks();
      System.out.println(Task.GREEN + "Task added: " + description + Task.RESET + "\n");
    }
  }

  void viewTasks() {
    if (tasks.isEmpty()) {
      System.out.println(Task.YELLOW + "\nNo tasks available" + Task.RESET);
    } else {
      System.out.println("\nTo-Do List:");
      for (int i = 0; i < tasks.size(); i++) {
        System.out.println((i + 1) + ". " + tasks.get(i));
      }
    }
  }

  void markTaskCompleted() {
    if (!(tasks.isEmpty())) {
      viewTasks();
      System.out.print("\nEnter task number to mark completed: ");
      int taskNumber = scanner.nextInt();
      scanner.nextLine(); // Consume newline left-over
      
      if (taskNumber > 0 && taskNumber <= tasks.size()) {
        Task task = tasks.get(taskNumber - 1);
        task.markCompleted();
        saveTasks();
        System.out.println(Task.GREEN + "Task marked completed: " + task.description + Task.RESET);
      } else {
        System.out.println(Task.RED + "Invalid task number" + Task.RESET);
      }
    } else {
      System.out.println(Task.YELLOW + "\nNo tasks available to mark completed" + Task.RESET);
    }
  }

  void exit(int code) {
    System.out.println(Task.YELLOW + "Exiting...");
    saveTasks();
    System.exit(code);
  }

  void loadTasks() {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.startsWith("[X] ")) {
          Task task = new Task(line.substring(4));
          task.markCompleted();
          tasks.add(task);
        } else {
          tasks.add(new Task(line.substring(3)));
        }
      }
    } catch (IOException e) {
      System.out.println("No existing tasks file found");
    }
  }

  void saveTasks() {
    try (FileWriter writer = new FileWriter(filename)) {
      for (Task task : tasks) {
        writer.write((task.completed ? "[X] " : "[ ] ") + task.description + "\n");
      }
    } catch (IOException e) {
      System.out.println(Task.RED + "Error saving tasks" + Task.RESET);
    }
  }

  public static void main(String[] args) {
    ToDoList toDoList = new ToDoList("tasks.txt");
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println(Task.GREEN + "\n===SIMPLE TO-DO LIST===" + Task.RESET);
      System.out.println("1. Add task");
      System.out.println("2. View tasks");
      System.out.println("3. Mark task completed");
      System.out.println("4. Exit");
      System.out.print("Choose an option: ");
      int option = scanner.nextInt();
      scanner.nextLine(); // Consume newline left-over
      switch (option) {
        case 1:
          toDoList.addTask();
          break;
        case 2:
          toDoList.viewTasks();
          break;
        case 3:
          toDoList.markTaskCompleted();
          break;
        case 4:
          toDoList.exit(0);
          break;
        default:
          System.out.println(Task.RED + "Invalid option" + Task.RESET);
          break;
        }
    }
  }
}