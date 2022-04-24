public class Position {

    int x;
    int y;

    public Position(int line, int column){

        this.x = line;
        this.y = column;

    }

    public String stringPosition(){

        return (x +";"+ y);

    }
}