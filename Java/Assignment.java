// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class Assignment {
//   public static void main(String[] args) {
//     JFrame frame = new JFrame("Hello World");
//     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     frame.setLayout(new FlowLayout());

//     JLabel label = new JLabel("Enter your name:");
//     JTextField textField = new JTextField(20);
//     JButton button = new JButton("Say Hello");

//     button.addActionListener(new ActionListener() {
//       public void actionPerformed(ActionEvent e) {
//         String name = textField.getText();
//         JOptionPane.showMessageDialog(null, "Hello, " + name);
//       }
//     });

//     frame.add(label);
//     frame.add(textField);
//     frame.add(button);

//     frame.pack();
//     frame.setVisible(true);
//   }
// }

import java.util.ArrayList;
import java.util.Scanner;

class Task {
  String description;
  boolean completed;

  Task(String description) {
    this.description = description;
    this.completed = false;
  }

  void markCompleted() {
    this.completed = true;
  }

  @Override
  public String toString() {
    return (completed ? "[X] " : "[ ] ") + description;
  }
}

public class Assignment {
  ArrayList<Task> tasks;
  Scanner scanner;

  public Assignment() {
    this.tasks = new ArrayList<>();
    this.scanner = new Scanner(System.in);
  }

  void addTask() {
    System.out.print("Enter task description: ");
    String description = scanner.nextLine();
    tasks.add(new Task(description));
  }

  void viewTasks() {
    System.out.println("To-Do List:");
    for (int i = 0; i < tasks.size(); i++) {
      System.out.println((i + 1) + ". " + tasks.get(i));
    }
  }

  void markTaskCompleted() {
    viewTasks();
    System.out.print("Enter task number to mark completed: ");
    int taskNumber = scanner.nextInt();
    scanner.nextLine(); // Consume newline left-over
    if (taskNumber > 0 && taskNumber <= tasks.size()) {
      tasks.get(taskNumber - 1).markCompleted();
    } else {
      System.out.println("Invalid task number");
    }
  }

  public static void main(String[] args) {
    Assignment toDoList = new Assignment();
    Scanner scanner = new Scanner(System.in);
    while (true) {
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
          System.exit(0);
          break;
        default:
          System.out.println("Invalid option");
      }
    }
  }
}