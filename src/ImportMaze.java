import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImportMaze {
    public static String importMaze(String mazePath) throws FileNotFoundException {

        File file = new File(mazePath);
        Scanner scan = new Scanner(file);

        while(scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }
        return "That's your maze!";
    }
}
