package gameLogic.pieces;

import utils.Position;
import gameLogic.patterns.KnightPattern;

public class Knight extends Piece {
    public Knight(String name, Position position){
        super(name, position,new KnightPattern());
    }
}
