package logic;

import logic.patterns.ChessPattern;
import logic.pieces.Piece;

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


    public ChessField(Position position, Piece piece){
        this.position = position;
        this.isOccupiedBy = piece;
    }

    public Piece getPiece(){
        return this.isOccupiedBy;
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
}
