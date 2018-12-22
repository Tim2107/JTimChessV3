package gameLogic.analyzationTools.tacticDTOs;

import com.google.common.collect.Multimap;
import gameLogic.pieces.Piece;
import utils.Move;
import utils.Position;

import java.util.List;

public abstract class TacticDtoBase {

    List<Position> fieldsInvolved;
    List<Position> executionPoints;
    List<Piece> eligiblePieces;
    Multimap<Piece, Move> movesPieceToExecutionPoint;
    int evaluationLevel = 0;
    List<String>counterMeasures;
    //patternsAffected?


    public List<Position> getFieldsInvolved() {
        return fieldsInvolved;
    }

    public void setFieldsInvolved(List<Position> fieldsInvolved) {
        this.fieldsInvolved = fieldsInvolved;
    }

    public List<Position> getExecutionPoints() {
        return executionPoints;
    }

    public void setExecutionPoints(List<Position> executionPoints) {
        this.executionPoints = executionPoints;
    }

    public List<Piece> getEligiblePieces() {
        return eligiblePieces;
    }

    public void setEligiblePieces(List<Piece> eligiblePieces) {
        this.eligiblePieces = eligiblePieces;
    }

    public Multimap<Piece, Move> getMovesPieceToExecutionPoint() {
        return movesPieceToExecutionPoint;
    }

    public void setMovesPieceToExecutionPoint(Multimap<Piece, Move> movesPieceToExecutionPoint) {
        this.movesPieceToExecutionPoint = movesPieceToExecutionPoint;
    }

    public int getEvaluationLevel() {
        return evaluationLevel;
    }

    public void setEvaluationLevel(int evaluationLevel) {
        this.evaluationLevel = evaluationLevel;
    }

    public List<String> getCounterMeasures() {
        return counterMeasures;
    }

    public void setCounterMeasures(List<String> counterMeasures) {
        this.counterMeasures = counterMeasures;
    }
}
