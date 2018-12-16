package logic.pieces;

import logic.Position;
import logic.patterns.PawnPattern;

public class Pawn extends Piece {
    public Pawn(String name, Position position){
        super(name, position,new PawnPattern());
    }
}
