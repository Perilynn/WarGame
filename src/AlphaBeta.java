import java.util.ArrayList;

/**
 * Created by Aravind on 3/31/15.
 */
public class AlphaBetaSearch {

    public AlphaBetaObject AlphaBeta(Board board, int depth, String Color, int alpha, int beta) {
        ArrayList<AlphaBetaObject> min = new ArrayList<AlphaBetaObject>();
        int count = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(board.board[i][j].color == "n") {
                    Board copy = new Board(board);
                    copy.takeOver(i, j, Color);
                    AlphaBetaObject temp;
                    if (Color == "blue") {
                        temp = AlphaBetaHelper(board, depth - 1, "green", i, j, alpha, beta, false, count);
                    }
                    else {
                        temp = AlphaBetaHelper(board, depth - 1, "blue", i, j, alpha, beta, false, count);
                    }
                    alpha = Math.max(alpha, temp.temp);
                    min.add(temp);
                    if (beta <= alpha) {
                        return new AlphaBetaObject(alpha, i, j);
                    }
                }
            }
        }
        
    }

    public AlphaBetaObject AlphaBetaHelper(Board board, int depth, String Color, int x, int y, int alpha, int beta, boolean mm, int count) {

    }
}