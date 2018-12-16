package logic.pieces;

import logic.patterns.KingPattern;
import logic.Position;

public class King extends Piece {

    public King(String name, Position position){
        super(name, position,new KingPattern());
    }
}
