package utils;

import gameLogic.pieces.Rook;
import org.junit.jupiter.api.Test;

class BoardTest {

    @Test
    void boardFieldTest(){
        Board testBoard = new Board();
        System.out.println(testBoard.boardGrid[4][4].getPosition());
    }

    @Test
    void boardPieceSettingTest(){
        Board testBoard = new Board();

        Rook testRook = new Rook("white rook", Position.D4);
        testBoard.putPieceOnField(testRook);

        System.out.println(testBoard.getChessfield(Position.D4).getIsOccupiedBy().getName());
    }

}