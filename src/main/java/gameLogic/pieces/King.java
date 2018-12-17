package gameLogic.pieces;

import gameLogic.patterns.KingPattern;
import utils.Position;

public class King extends Piece {

    public King(String name, Position position){
        super(name, position,new KingPattern());
    }
}
