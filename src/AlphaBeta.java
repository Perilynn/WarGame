import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Aravind on 3/31/15.
 */
public class AlphaBetaSearch {

    public AlphaBetaObject AlphaBeta(Board board, int depth, String Color, int alpha, int beta) {
        ArrayList<AlphaBetaObject> min = new ArrayList<AlphaBetaObject>();
        int count = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (board.board[i][j].color == "n") {
                    Board copy = new Board(board);
                    copy.takeOver(i, j, Color);
                    AlphaBetaObject temp;
                    if (Color == "blue") {
                        temp = new AlphaBetaObject(AlphaBetaHelper(board, depth - 1, "green", i, j, alpha, beta, false, count), i, j);
                    } else {
                        temp = new AlphaBetaObject(AlphaBetaHelper(board, depth - 1, "blue", i, j, alpha, beta, false, count), i, j);
                    }
                    alpha = Math.max(alpha, temp.temp);
                    min.add(temp);
                    count++;
                    if (beta <= alpha) {
                        return new AlphaBetaObject(alpha, i, j);
                    }
                }
            }
        }
        ArrayList<Integer> minRet = new ArrayList<Integer>();
        for(int k = 0; k < min.size(); k++) {
            minRet.add(min.get(k).temp);
        }
        int ret = Collections.max(minRet);
        return new AlphaBetaObject(ret, count, 0);
        
    }

    public int AlphaBetaHelper(Board board, int depth, String Color, int x, int y, int alpha, int beta, boolean mm, int count) {
        if (depth == 0) {
            if(mm) {
                if(Color == "blue") return board.blueScore - board.greenScore;
                else return board.greenScore - board.blueScore;
            }
            else {
                if(Color == "blue") return board.greenScore - board.blueScore;
                else return board.blueScore - board.greenScore;
            }
        }
        ArrayList<AlphaBetaObject> min = new ArrayList<AlphaBetaObject>();
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                if(board.board[i][j].color == "n") {
                    Board copy = new Board(board);
                    copy.takeOver(i, j, Color);
                    count++;
                    if(!mm) {
                        int temp;
                        if(Color == "blue") {
                            temp = AlphaBetaHelper(board, depth - 1, "green", i, j, alpha, beta, true, count);
                        }
                        else {
                            temp = AlphaBetaHelper(board, depth - 1, "blue", i, j, alpha, beta, true, count);
                        }
                    }
                }
            }
        }
    }
}