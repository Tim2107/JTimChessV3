package gameLogic.pieces;

import utils.Position;
import gameLogic.patterns.PawnPattern;

public class Pawn extends Piece {
    public Pawn(String name, Position position){
        super(name, position,new PawnPattern());
    }
}
