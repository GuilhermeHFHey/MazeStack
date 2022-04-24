import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Stack;

public class ReadMaze {

    private String[][] maze;

    // Metodo que retorna labirinto lido em matriz
    public void ConvertMazeToArray(String mazePath) throws IOException {

        String[][] mazeConverted = new String[100][100];

        FileReader file = new FileReader(mazePath);
        BufferedReader readFile = new BufferedReader(file);
        String fileLine = readFile.readLine();

        int lineArray = 0;
        do{
            for(int columnArray = 0; columnArray < fileLine.length(); columnArray++){

                mazeConverted[lineArray][columnArray] = String.valueOf(fileLine.charAt(columnArray));

            }

            lineArray++;
            fileLine = readFile.readLine();

        }while (fileLine != null);
        this.maze = mazeConverted;
    }

    public Stack movements = new Stack<>();

    public Position presentPosition;
    public Position mazeEntry;
    public Position mazeExit;

    public void solvingMaze(){

        mazeEntry = searchElement("E");
        mazeExit = searchElement("S");
        presentPosition = mazeEntry;
        movements.push(mazeEntry.stringPosition() + ";Entrance; Not Found");

        do {
            NextPosition NextPosition = new NextPosition(presentPosition, maze);
            String returnPositionFree = NextPosition.searchExit();

            if (returnPositionFree.equals("There is no exit")) {

                String latestPosition = (String) movements.peek();
                String[] position = latestPosition.split(";");
                int line = Integer.parseInt(position[0]);
                int column = Integer.parseInt(position[1]);

                this.presentPosition = new Position(line, column);
                movements.pop();

            } else {

                String[] splitPosition = returnPositionFree.split(";");
                int line = Integer.parseInt(splitPosition[0]);
                int column = Integer.parseInt(splitPosition[1]);

                presentPosition = new Position(line, column);
                movements.push(returnPositionFree + "; Not found");
            }
        } while (!maze[presentPosition.x][presentPosition.y].equals(maze[mazeExit.x][mazeExit.y]));

        printMovements();

    }

    private Position searchElement(String element){

        for(int line = 0; line < maze.length; line++)
        {
            for(int column = 0; column < maze.length; column++)
            {
                if(Objects.equals(maze[line][column], element)){
                    Position elementPosition = new Position(line,column);

                    return elementPosition;
                }
            }
        }
        return new Position(-1,-1);
    }

    public void printMovements(){

        if(maze[presentPosition.x][presentPosition.y].equals("S")){

            String[] aux = movements.peek().toString().split(";");
            movements.pop();

            String aux2 = aux[0]+";"+aux[1] + ";" +aux[2] + "; Found! Maze Solved";
            movements.push(aux2);

        }

        System.out.println("Path to solve it: ");
        System.out.println();
        for (Object item: movements) {

            String[] cordMove = item.toString().split(";");
            System.out.println("Movement Made: " + cordMove[2] + " \nCurrent Position: (" + cordMove[0] + ","+cordMove[1]+ ")\n" + "Exit:"+cordMove[3]);
            System.out.println();
        }
    }

}
