import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Aravind on 3/31/15.
 */
public class Minimax {


    public MinimaxObject MinimaxSearch(Board board, int depth, String Color) {
        int count = 0;
        ArrayList<AlphaBetaObject> min = new ArrayList<AlphaBetaObject>();
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                if(board.board[i][j].color == "n") {
                    Board copy = new Board(board);
                    copy.takeOver(i, j, Color);
                    if(Color == "blue") {
                        min.add(new AlphaBetaObject(MiniMaxHelper(copy, depth - 1, "green", i, j, false, count), i, j));
                    }
                    else {
                        min.add(new AlphaBetaObject(MiniMaxHelper(copy, depth - 1, "blue", i, j, false, count), i, j));
                    }
                }
            }
        }
        ArrayList<Integer> minRet = new ArrayList<Integer>();
        for(int k = 0; k < min.size(); k++) {
            minRet.add(min.get(k).temp);
        }
        int retval = Collections.max(minRet);
        return new MinimaxObject(retval, count);

    }

    public int MiniMaxHelper(Board board, int depth, String Color, int x, int y, boolean mm, int count) {
        if (depth == 0) {
            count++;
            if(mm) {
                if(Color == "blue") return board.blueScore - board.greenScore;
                else return board.greenScore - board.blueScore;
            }
            else {
                if(Color == "blue") return board.greenScore - board.blueScore;
                else return board.blueScore - board.greenScore;
            }
        }
        ArrayList<Integer> min = new ArrayList<Integer>();
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                if(board.board[i][j].color == "n") {
                    Board copy = new Board(board);
                    copy.takeOver(i, j, Color);
                    if(!mm) {
                        if(Color == "blue") min.add(MiniMaxHelper(copy, depth - 1, "green", i, j, true, count));
                        else min.add(MiniMaxHelper(copy, depth - 1, "blue", i, j, true, count));
                    }
                    else {
                        if(Color == "blue") min.add(MiniMaxHelper(copy, depth - 1, "green", i, j, false, count));
                        else min.add(MiniMaxHelper(copy, depth - 1, "blue", i, j, false, count));
                    }
                }
            }
        }
        if(!mm) return Collections.min(min);
        else return Collections.max(min);
    }
}
