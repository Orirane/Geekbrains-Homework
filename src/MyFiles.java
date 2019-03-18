import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.file.Files;

public class MyFiles {
    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");
        File file2 = new File("copyfile.txt");

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("file.txt")));


    }
}
