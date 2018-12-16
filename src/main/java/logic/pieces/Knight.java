package logic.pieces;

import logic.Position;
import logic.patterns.KnightPattern;

public class Knight extends Piece {
    public Knight(String name, Position position){
        super(name, position,new KnightPattern());
    }
}
