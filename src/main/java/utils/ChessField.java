package utils;

import gameLogic.patterns.ChessPattern;
import gameLogic.pieces.Piece;

import java.util.List;

public class ChessField {

    Position position;
    Piece isOccupiedBy = null;

    List<Piece> isAttackedBy;
    List<Piece> isDefendedBy;

    int isAttackedCounter;
    int isDefendedCounter;

    Piece isRailroadForPiece;
    ChessPattern railroad;

    Piece isPinnedByPiece;
    ChessPattern pin;

    private Alliance tacticalOverlayAlliance;
    private ChessPattern tacticalOverlayPattern;


    public ChessField(Position position, Piece piece){
        this.position = position;
        this.isOccupiedBy = piece;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Piece getIsOccupiedBy() {
        return isOccupiedBy;
    }

    public void setIsOccupiedBy(Piece isOccupiedBy) {
        this.isOccupiedBy = isOccupiedBy;
    }

    public void setTacticalOverlayAlliance(Alliance alliance){
        this.tacticalOverlayAlliance = alliance;
    }

    public int[][] getTacticalOverlayPattern(){
        return tacticalOverlayPattern.getChessPattern(this.position,this.tacticalOverlayAlliance);
    }

    public void setTacticalOverlayPatternType(ChessPattern tacticalPattern){
        this.tacticalOverlayPattern = tacticalPattern;
    }
}
