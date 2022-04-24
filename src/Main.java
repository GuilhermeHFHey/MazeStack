import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String path = "/Users/guilh/IdeaProjects/Maze/src/SimpleMaze.txt";

        ImportMaze.importMaze(path);

        System.out.println();

        ReadMaze ReadMaze = new ReadMaze();
        ReadMaze.ConvertMazeToArray(path);
        ReadMaze.solvingMaze();

    }
}
