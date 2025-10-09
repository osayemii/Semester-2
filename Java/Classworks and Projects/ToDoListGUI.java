import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

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

class ToDoList {
    ArrayList<Task> tasks;
    String filename;

    public ToDoList(String filename) {
        this.tasks = new ArrayList<>();
        this.filename = filename;
        loadTasks();
    }

    void addTask(String description) {
        if (description.startsWith("[ ]") || description.startsWith("[]")) {
            JOptionPane.showMessageDialog(null, "Sorry, you can't start naming your task with [ ].", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            tasks.add(new Task(description));
            saveTasks();
        }
    }

    void markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
            saveTasks();
        }
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
                writer.write(task.toString() + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving tasks", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

public class ToDoListGUI {
    private ToDoList toDoList;
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField taskInput;

    public ToDoListGUI() {
        toDoList = new ToDoList("tasks.txt");

        JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
 
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        taskInput = new JTextField();
        JButton addButton = new JButton("Add Task");
        JButton completeButton = new JButton("Mark Completed");
        JButton exitButton = new JButton("Exit");

        addButton.addActionListener(e -> {
            String desc = taskInput.getText().trim();
            if (!desc.isEmpty()) {
                toDoList.addTask(desc);
                taskInput.setText("");
                refreshList();
            }
        });

        completeButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index >= 0) {
                toDoList.markTaskCompleted(index);
                refreshList();
            }
        });

        exitButton.addActionListener(e -> { 
            toDoList.saveTasks();
            System.exit(0);
        });

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInput, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(completeButton);
        buttonPanel.add(exitButton);

        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        refreshList();
        frame.setVisible(true);
    }

    private void refreshList() {
        listModel.clear();
        for (Task task : toDoList.tasks) {
            listModel.addElement(task.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoListGUI::new);
    }
}