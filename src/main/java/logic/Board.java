package logic;

import logic.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {

    ChessField[][] boardGrid = new ChessField[8][8];
    List<Piece> activePieces = new ArrayList<>();

    public ChessField getChessfield(Position position) {
        return boardGrid[position.convertPositionToColumn()][position.convertPositionToRow()];
    }

    public ChessField[][] createBoardGrid() {

        initBoardGrid();

        for (Piece activePiece : activePieces) {

            //		boardGrid[activePiece.getPosition().convertPositionToColumn()][activePiece.getPosition().convertPositionToRow()] = setChessField();

        }

        return boardGrid;
    }

    private void initBoardGrid() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardGrid[i][j] = initChessfield(i, j);
            }
        }
    }

    private ChessField initChessfield(int column, int row) {
        int alpha = 65 + column;
        String rowInPosition = Integer.toString(row + 1);
        String columnInPosition = String.valueOf((char)alpha);
        String positionNotation = columnInPosition + rowInPosition;
        ChessField emptyChessField = new ChessField(Position.valueOf(positionNotation), null);
        return emptyChessField;
    }
}
