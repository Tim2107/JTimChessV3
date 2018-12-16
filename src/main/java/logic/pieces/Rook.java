package logic.pieces;

import logic.Position;
import logic.patterns.RookPattern;

public class Rook extends Piece {

    public Rook(String name, Position position){
        super(name,position,new RookPattern());
    }
}
