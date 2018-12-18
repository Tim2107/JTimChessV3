package gui;

import gameLogic.pieces.Bishop;
import gameLogic.pieces.Knight;
import gameLogic.pieces.Rook;
import org.junit.jupiter.api.Test;
import utils.Board;
import utils.GridComposer;
import utils.Position;

class TableTest {


    @Test
    void displayTest() {


        Rook testPiece = new Rook("white rook", Position.C6);
        Bishop testPiece2 = new Bishop("black bishop", Position.A1);
        Knight testPiece3 = new Knight("black knight", Position.G4);

        GridComposer testComposer = new GridComposer(testPiece.getPotentialMoves(), testPiece2.getPotentialMoves());
        GridComposer testComposer2 = new GridComposer(testComposer.getComposedGrid(), testPiece3.getPotentialMoves());

        Board testBoard = new Board();
        testBoard.putPieceOnField(testPiece);
        testBoard.putPieceOnField(testPiece2);
        testBoard.putPieceOnField(testPiece3);


    }
}