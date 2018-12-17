package gameLogic.pieces;

import utils.Position;
import gameLogic.patterns.QueenPattern;

public class Queen extends Piece{
    public Queen(String name, Position position){
        super(name,position,new QueenPattern());
    }
}
