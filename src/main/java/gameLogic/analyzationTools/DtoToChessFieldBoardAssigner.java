package gameLogic.analyzationTools;

import utils.*;

import java.util.List;

public class DtoToChessFieldBoardAssigner {

    TacticDtoBuilderBlueprint tacticDtoBuilderBlueprint;
    Board board;

    public DtoToChessFieldBoardAssigner(Board board){
        this.tacticDtoBuilderBlueprint = new TacticDtoBuilderBlueprint();
        this. board = board;
    }


    public TacticDtoBuilderBlueprint generateTacticDtosForGivenBoard(){
        List<ChessField> fieldsToAnalyze = tacticDtoBuilderBlueprint.getFieldsToAnalyzeFromPiecesOnBoard(board);
        List<List<ChessField>> combiAnalyzationList = tacticDtoBuilderBlueprint.goThroughListAndMakeSmallCombinationLists(fieldsToAnalyze);
        ChessPiece[] chessPieces = ChessPiece.values();
        for (ChessPiece chessPiece : chessPieces) {
            tacticDtoBuilderBlueprint.createAndStoreTacticDtos(combiAnalyzationList,chessPiece.toString(), Alliance.WHITE);
        }
        return  tacticDtoBuilderBlueprint;
    }

    public Board takeDtosAndStoreThemInFields(){

        tacticDtoBuilderBlueprint.getKingTacticDtos().forEach(kingTacticDto -> {

            kingTacticDto.getExecutionPoints().forEach(executionPoint -> {
                board.setTacticDtoOnField(executionPoint,kingTacticDto,"king");
                board.elevateExecutionEvaluationLevelInField(executionPoint); });

                kingTacticDto.getFieldsInvolved().forEach(fieldInvolved -> {
                board.setTacticDtoOnField(fieldInvolved,kingTacticDto,"king");
                board.elevateInvolvementEvaluationLevelInField(fieldInvolved);});

            });

        tacticDtoBuilderBlueprint.getQueenTacticDtos().forEach(queenTacticDto -> {

            queenTacticDto.getExecutionPoints().forEach(executionPoint -> {
                board.setTacticDtoOnField(executionPoint,queenTacticDto,"queen");
                board.elevateExecutionEvaluationLevelInField(executionPoint);});


            queenTacticDto.getFieldsInvolved().forEach(fieldInvolved -> {
                board.setTacticDtoOnField(fieldInvolved,queenTacticDto,"queen");
                board.elevateInvolvementEvaluationLevelInField(fieldInvolved);});


        });

        tacticDtoBuilderBlueprint.getRookTacticDtos().forEach(rookTacticDto -> {

            rookTacticDto.getExecutionPoints().forEach(executionPoint -> {
                board.setTacticDtoOnField(executionPoint,rookTacticDto,"rook");
                board.elevateExecutionEvaluationLevelInField(executionPoint);});


            rookTacticDto.getFieldsInvolved().forEach(fieldInvolved -> {
                board.setTacticDtoOnField(fieldInvolved,rookTacticDto,"rook");
                board.elevateInvolvementEvaluationLevelInField(fieldInvolved);});

        });

        tacticDtoBuilderBlueprint.getKnightTacticDtos().forEach(knightTacticDto -> {

            knightTacticDto.getExecutionPoints().forEach(executionPoint -> {
                board.setTacticDtoOnField(executionPoint,knightTacticDto,"knight");
                board.elevateExecutionEvaluationLevelInField(executionPoint);});


            knightTacticDto.getFieldsInvolved().forEach(fieldInvolved -> {
                board.setTacticDtoOnField(fieldInvolved,knightTacticDto,"knight");
                board.elevateInvolvementEvaluationLevelInField(fieldInvolved);});

        });

        tacticDtoBuilderBlueprint.getBishopTacticDtos().forEach(bishopTacticDto -> {

            bishopTacticDto.getExecutionPoints().forEach(executionPoint -> {
                board.setTacticDtoOnField(executionPoint,bishopTacticDto,"bishop");
                board.elevateExecutionEvaluationLevelInField(executionPoint); });


            bishopTacticDto.getFieldsInvolved().forEach(fieldInvolved -> {
                board.setTacticDtoOnField(fieldInvolved,bishopTacticDto,"bishop");
                board.elevateInvolvementEvaluationLevelInField(fieldInvolved);});

        });

        tacticDtoBuilderBlueprint.getPawnTacticDtos().forEach(pawnTacticDto -> {

            pawnTacticDto.getExecutionPoints().forEach(executionPoint -> {
                board.setTacticDtoOnField(executionPoint,pawnTacticDto,"pawn");
                board.elevateExecutionEvaluationLevelInField(executionPoint);});


            pawnTacticDto.getFieldsInvolved().forEach(fieldInvolved -> {
                board.setTacticDtoOnField(fieldInvolved,pawnTacticDto,"pawn");
                board.elevateInvolvementEvaluationLevelInField(fieldInvolved); });

        });

          return board;
    }

    public Board getBoard() {
        return board;
    }
}


