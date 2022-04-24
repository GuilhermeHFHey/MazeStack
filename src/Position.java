
// Criando posicoes x e y que sera a posicao na matriz
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
