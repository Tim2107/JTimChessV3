package utils;

import gameLogic.pieces.King;
import gameLogic.pieces.Piece;
import gameLogic.pieces.Queen;
import gameLogic.pieces.Rook;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

class BoardTest {

    @Test
    void boardFieldSetUpTest(){
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

    @Test
    void boardPieceSettingFromListTest() {

        Board testBoard = new Board();

        King whiteKing = new King("white king", Position.D1);
        King blackKing = new King("black king", Position.D8);
        Queen whiteQueen = new Queen("white queen", Position.E1);
        Queen blackQueen = new Queen("black queen", Position.E8);
        Rook whiteRook1 = new Rook("white rook", Position.A1);
        Rook whiteRook2 = new Rook("white rook", Position.H1);
        Rook blackRook1 = new Rook("black rook", Position.A8);
        Rook blackRook2 = new Rook("black rook", Position.H8);

        testBoard.putPieceOnField(whiteKing);
        testBoard.putPieceOnField(blackKing);
        testBoard.putPieceOnField(whiteQueen);
        testBoard.putPieceOnField(blackQueen);
        testBoard.putPieceOnField(whiteRook1);
        testBoard.putPieceOnField(whiteRook2);
        testBoard.putPieceOnField(blackRook1);
        testBoard.putPieceOnField(blackRook2);


        List<Piece> activePiecesFromFields = testBoard.getActivePiecesFromFields();
        Stream<Piece> stream = activePiecesFromFields.stream();
        stream.map(piece -> piece.getName()).forEach(System.out::println);


    }
}