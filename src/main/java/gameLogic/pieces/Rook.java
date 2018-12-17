package gameLogic.pieces;

import utils.Position;
import gameLogic.patterns.RookPattern;

public class Rook extends Piece {

    public Rook(String name, Position position){
        super(name,position,new RookPattern());
    }
}
