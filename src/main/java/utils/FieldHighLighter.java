package utils;

import java.util.HashMap;

public class FieldHighLighter {

   Board board;
   HashMap<Position,Integer> executionPointsLevelMap;
   HashMap<Position, Integer> fieldsInvolvedLevelMap;

    public FieldHighLighter(Board board){

        this.board = board;
        executionPointsLevelMap = createPositionExecPointLevelMap(board);
        fieldsInvolvedLevelMap = createFieldsInvolvedLevelMap(board);

    }

    public HashMap<Position, Integer> createPositionExecPointLevelMap(Board board){

        HashMap<Position, Integer> executionPositionMap = new HashMap<>();
        Position[] positions = Position.values();

        for (int i = 0; i < (positions.length - 1); i++) {
        executionPositionMap.put(positions[i],board.getChessfield(positions[i]).getExecutionEvaluationLevel());
        }
        return executionPositionMap;
    }

    public HashMap<Position, Integer> createFieldsInvolvedLevelMap(Board board){

        HashMap<Position, Integer> fieldsPositionMap = new HashMap<>();
        Position[] positions = Position.values();

        for (int i = 0; i < (positions.length - 1); i++) {
            fieldsPositionMap.put(positions[i],board.getChessfield(positions[i]).getInvolvementEvaluationLevel());
        }
        return fieldsPositionMap;
    }

    public HashMap<Position, Integer> getExecutionPointsLevelMap() {
        return executionPointsLevelMap;
    }

    public HashMap<Position, Integer> getFieldsInvolvedLevelMap() {
        return fieldsInvolvedLevelMap;
    }
}
