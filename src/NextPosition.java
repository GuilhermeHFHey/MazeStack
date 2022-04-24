import java.util.Objects;

public class NextPosition {

    private Position presentPosition;
    private String[][] maze;

    public NextPosition(Position currentPosition, String[][] maze) {
        this.presentPosition = currentPosition;
        this.maze = maze;
    }


    private String checkNeighbors(Position neighbor) {

        String freeNeighbor;

        if (!Objects.equals(maze[neighbor.x][neighbor.y], "S")) {
            if (Objects.equals(maze[neighbor.x][neighbor.y], " ")) {
                maze[neighbor.x][neighbor.y] = "-";
                return freeNeighbor = neighbor.stringPosition();
            }
            return freeNeighbor = "occupiedNeighbor";
        }
        return freeNeighbor = neighbor.stringPosition();
    }


    public String searchExit () {

        String command;

        Position neighborUp = new Position(presentPosition.x - 1, presentPosition.y);
        Position neighborRight = new Position(presentPosition.x, presentPosition.y + 1);
        Position neighborDown = new Position(presentPosition.x + 1, presentPosition.y);
        Position neighborLeft = new Position(presentPosition.x, presentPosition.y - 1);

        if (!checkNeighbors(neighborUp).equals("occupiedNeighbor")) {

            return command = neighborUp.stringPosition() + ";UP";

        }
        else if (!checkNeighbors(neighborRight).equals("occupiedNeighbor")) {

            return command = neighborRight.stringPosition() + ";Right";

        }
        else if (!checkNeighbors(neighborDown).equals("occupiedNeighbor")) {

            return command = neighborDown.stringPosition() + ";Down";

        }
        else if (!checkNeighbors(neighborLeft).equals("occupiedNeighbor")) {

            return command = neighborLeft.stringPosition() + ";Left";

        }
        else {
            return command = "Exit Not Found";
        }


    }
}






