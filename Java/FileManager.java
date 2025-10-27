import java.io.File;

public class FileManager {
    public static void main(String[] args) {
        File file = new File("data/example.txt");//defining file path
        try {
            File parentDirectory = file.getParentFile();//defining parent directory of the above file
            // System.out.println(parentDirectory);
            if (parentDirectory != null /*if already defined*/) {
                parentDirectory.mkdir();//creating a directory
                System.out.println("Parent Directory Exists: " + parentDirectory.exists());
            }
            file.createNewFile();

            //alert created and log the absolute file path of the created file
            System.out.println("File created successfully, PATH: "+parentDirectory.getPath());

            //deleting file
            boolean deleted = parentDirectory.delete();
            System.out.println("File is deleted: "+deleted);
        } catch (Exception e) {
            e.printStackTrace();   
        }
    }
}
