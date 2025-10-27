import java.io.File;

public class FileHandling {
    public static void main(String[] args) {
        //CREATING AN INSTANCE OF A FILE CLASS BEING IMPORTED   
        try {
            File f1 = new File("newFile.txt");
            if (f1.createNewFile()) System.out.println("Created the file: "+f1.getName());
        } catch (Exception e) {
            System.err.println("An error occured while creating the file");
            e.printStackTrace();
        }

        // File f2 = new File("C:/Users/DANIEL/Document", "empty.txt");
        // File folder = new File("C:/Users/DANIEL/Document/emptyFolder");
    }    
}