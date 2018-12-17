package gameLogic.pieces;

import utils.Position;
import gameLogic.patterns.BishopPattern;

public class Bishop extends Piece{

    public Bishop(String name, Position position){
        super(name, position,new BishopPattern());
    }
}
