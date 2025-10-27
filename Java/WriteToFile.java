import java.io.FileWriter;

public class WriteToFile {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("note.txt")) {
            writer.write("Hello, this is my first writing.");
            System.out.println("Data written successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
