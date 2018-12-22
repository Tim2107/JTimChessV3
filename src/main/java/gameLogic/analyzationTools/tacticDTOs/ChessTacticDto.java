package gameLogic.analyzationTools.tacticDTOs;

import gameLogic.pieces.Piece;
import utils.Position;

import java.util.List;

public interface ChessTacticDto {

    public List<Position> getFieldsInvolved();

    public void setFieldsInvolved(List<Position> fieldsInvolved);

    public List<Position> getExecutionPoints();

    public void setExecutionPoints(List<Position> executionPoints);

    public List<Piece> getEligiblePieces();

    public void setEligiblePieces(List<Piece> eligiblePieces);
}
