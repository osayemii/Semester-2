import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        File myFile = new File("student.txt");
        try {
            // boolean fileIsCreated = myFile.createNewFile();
            if (!myFile.exists()) {
                myFile.createNewFile();
                System.out.println("File has been created: "+myFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
