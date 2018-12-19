package gameLogic;

import gameLogic.pieces.Piece;
import utils.Board;
import utils.GridComposer;
import java.util.ArrayList;
import java.util.List;

public class Analyzer {

    Board boardToAnalyze = new Board();
    List<Piece>piecesOnBoard = new ArrayList<>();
    int[][] compositionGrid = new int[8][8];

    public Analyzer(List<Piece> piecesToAnalyze){
        initializeGrid();
        piecesOnBoard = piecesToAnalyze;
        piecesOnBoard.forEach(piece -> boardToAnalyze.putPieceOnField(piece));
        composeGridAnalyze();
    }

    public void composeGridAnalyze(){
        boardToAnalyze
                .getFieldList()
                .forEach(field ->
                            {if (field.getIsOccupiedBy() != null)
                                {GridComposer gridComposer = new GridComposer(
                                    compositionGrid,
                                    field.getIsOccupiedBy().getPotentialMoves());
                                compositionGrid = gridComposer.getComposedGrid();
                                }
                            }
                        );
    }

    private void initializeGrid() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                compositionGrid[i][j] = 0;
            }
        }
    }

    public Board getBoardToAnalyze() {
        return boardToAnalyze;
    }

    public int[][] getCompositionGrid() {
        return compositionGrid;
    }
}
