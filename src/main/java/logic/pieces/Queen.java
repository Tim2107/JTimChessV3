package logic.pieces;

import logic.Position;
import logic.patterns.QueenPattern;

public class Queen extends Piece{
    public Queen(String name, Position position){
        super(name,position,new QueenPattern());
    }
}
