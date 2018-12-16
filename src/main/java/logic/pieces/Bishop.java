package logic.pieces;

import logic.Position;
import logic.patterns.BishopPattern;

public class Bishop extends Piece{

    public Bishop(String name, Position position){
        super(name, position,new BishopPattern());
    }
}
