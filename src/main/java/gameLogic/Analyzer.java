package gameLogic;

import gameLogic.pieces.Piece;
import utils.Board;

import java.util.ArrayList;
import java.util.List;

public class Analyzer {

    Board boardToAnalyze = new Board();
    List<Piece>piecesOnBoard = new ArrayList<>();
    int[][] initialGrid;

    public Analyzer(List<Piece> piecesToAnalyze){
        initializeGrid();
        piecesOnBoard = piecesToAnalyze;
        piecesOnBoard.forEach(piece -> boardToAnalyze.putPieceOnField(piece));
    }

    private void initializeGrid() {
        int[][] initialGrid = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                initialGrid[i][j] = 0;
            }
        }
    }

    public Board getBoardToAnalyze() {
        return boardToAnalyze;
    }
}
