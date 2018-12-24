package utils;

import gameLogic.analyzationTools.tacticDTOs.*;
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

    public void elevateExecutionEvaluationLevelInField(Position position){
        PositionTranslator positionTranslator = new PositionTranslator(position, null, null, null);
        ChessField chessFieldToManipulate = boardGrid[positionTranslator.getColumnInLogicGrid()][positionTranslator.getRowInLogicGrid()];
        int executionEvaluationLevel = chessFieldToManipulate.getExecutionEvaluationLevel();
        executionEvaluationLevel = executionEvaluationLevel +1;
        chessFieldToManipulate.setExecutionEvaluationLevel(executionEvaluationLevel);
    }

    public void elevateInvolvementEvaluationLevelInField(Position position){
        PositionTranslator positionTranslator = new PositionTranslator(position, null, null, null);
        ChessField chessFieldToManipulate = boardGrid[positionTranslator.getColumnInLogicGrid()][positionTranslator.getRowInLogicGrid()];
        int involvementEvaluationLevel = chessFieldToManipulate.getInvolvementEvaluationLevel();
        involvementEvaluationLevel = involvementEvaluationLevel + 1;
        chessFieldToManipulate.setInvolvementEvaluationLevel(involvementEvaluationLevel);
    }

    public void setTacticDtoOnField(Position position, ChessTacticDto tacticDto, String typeSwitch){

        PositionTranslator fieldChosen = new PositionTranslator(position,null,null,null);

        ChessField chessFieldToManipulate = boardGrid[fieldChosen.getColumnInLogicGrid()][fieldChosen.getRowInLogicGrid()];

             if (typeSwitch.equalsIgnoreCase("king")){
                chessFieldToManipulate.setKingTacticDtos((KingTacticDto)tacticDto);
            }

            else if (typeSwitch.equalsIgnoreCase("queen")){
               chessFieldToManipulate.setQueenTacticDtos((QueenTacticDto)tacticDto);
            }
            else if (typeSwitch.equalsIgnoreCase("rook")){
                 chessFieldToManipulate.setRookTacticDtos((RookTacticDto)tacticDto);
            }
            else if (typeSwitch.equalsIgnoreCase("knight")){
                chessFieldToManipulate.setKnightTacticDtos((KnightTacticDto)tacticDto);
            }
            else if (typeSwitch.equalsIgnoreCase("bishop")){
                chessFieldToManipulate.setBishopTacticDtos((BishopTacticDto)tacticDto);
            }

            else if (typeSwitch.equalsIgnoreCase("pawn")){
                chessFieldToManipulate.setPawnTacticDtos((PawnTacticDto)tacticDto);
            }
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
