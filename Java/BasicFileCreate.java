import java.io.File;

public class BasicFileCreate {
    public static void main(String[] args) {
        File file = new File("example.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File Name: " + file.getAbsolutePath());
                System.out.println("File Name: " + file.getName());
            }
        } catch (Exception e) {
            System.err.println("There was an error creating your file!!!");
        }

        //FILE INSPECTION
        if (file.exists()) System.out.println("File exist: "+file.getName());
        else System.out.println("File not created");

        long fileSizeInByte = file.length();
        System.out.println("File Name: "+file.getName() +", Size in byte: "+(fileSizeInByte/1024));

        //CHECK READ AND WRITE CAPABILITIES
        System.out.println("Readability: "+file.canRead()+", Writability "+file.canWrite());

        //CHECKING IF IT IS A FILE OR A DIRECTORY
        if (file.isFile()) System.out.println("This is a file!");
        else if (file.isDirectory()) System.out.println("This is a directory!");
        else System.out.println("Unknown file type.");

        //RENAMING A FILE
        File file2 = new File("example2.txt");
        file.renameTo(file2);
        System.out.println("The file has been renamed to: "+file2.getName());
    }
}
