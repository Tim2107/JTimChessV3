package utils;

import gameLogic.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {

    ChessField[][] boardGrid = new ChessField[8][8];
    List<Piece> activePieces = new ArrayList<>();


    public Board(){
        initBoardGrid();
    }

    public ChessField getChessfield(Position position) {
        return boardGrid[position.convertPositionToColumn()][position.convertPositionToRow()];
    }

    public List<Piece> getActivePiecesFromFields(){
        List<Piece> activePieces = new ArrayList<>();

        List<ChessField> fieldList = this.getListOfChessFieldsOnBoard();
            this.getListOfChessFieldsOnBoard()
              .stream()
              .map(field -> field.getIsOccupiedBy())
          .forEach(piece ->
                  {if (piece != null){
                      activePieces.add(piece);
                      }
                  }
          );
        return activePieces;
    }

    public List<ChessField> getListOfChessFieldsOnBoard(){
        List<ChessField> fieldList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                fieldList.add(boardGrid[i][j]);
            }
        }
        return fieldList;
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

    public void putPieceOnField(Piece piece){
        PositionTranslator setBoardTranslator = new PositionTranslator(piece.getPosition(),null,null,null);
        boardGrid[setBoardTranslator.getColumnInLogicGrid()][setBoardTranslator.getRowInLogicGrid()].setIsOccupiedBy(piece);
    }
}
