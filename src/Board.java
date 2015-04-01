import java.awt.*;

/**
 * Created by Aravind on 3/31/15.
 */
public class Board {

    public Square[][] board = new Square[6][6];
    public int blueScore;
    public int greenScore;
    public Board() {
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                board[i][j] = new Square(0, "n");
            }
        }
        blueScore = 0;
        greenScore = 0;
    }

    public boolean takeOver(int x, int y, String newColor) {
        if ((x < 0 || x > 5) || (y < 0 || y > 5) || (board[x][y].color != "n")) return false;
        board[x][y].color = newColor;
        if (newColor == "green") greenScore++;
        else blueScore++;
        return true;
    }

    public boolean changeColor(int x, int y, String theColor) {
        if ((x < 0 || x > 5) || (y < 0 || y > 5)) return false;
        if(theColor == "green") {
            String newColor = "blue";
            if(board[x][y].color == newColor) {
                greenScore += board[x][y].number;
                blueScore -= board[x][y].number;
            }
        }
        else {
            String newColor = "green";
            if(board[x][y].color == newColor) {
                blueScore += board[x][y].number;
                greenScore += board[x][y].number;
            }
        }
        return true;
    }
    public boolean hasAdjacent(int x, int y, String Color) {
        if ((x < 0 || x > 5) || (y < 0 || y > 5)) return false;
        if(board[x][y].color == Color) return true;
        return false;
    }

}