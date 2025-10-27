import java.io.File;

public class FolderDemo {
    public static void main(String[] args) {
        try {
            File dir = new File("Student");
            if (!dir.exists()) {
                dir.mkdir();
                System.out.println("Folder created");
            } else{
                System.out.println("Folder already exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while creating file...");
        }
    }
}
