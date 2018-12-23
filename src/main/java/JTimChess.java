import gameLogic.pieces.*;
import gui.Table;
import utils.Board;
import utils.BoardCreator;
import utils.InitializeGame;
import utils.Position;

import java.util.ArrayList;
import java.util.List;

public class JTimChess {

    public static void main(String[] args){


        InitializeGame newGame = new InitializeGame();
        Board startingBoard = newGame.getStartingBoard();

        List<Piece> piecesOnBoard = new ArrayList<>();
        //King whiteKing = new King("white king", Position.D1);
        //King blackKing = new King("black king",Position.D8);
       // Queen whiteQueen = new Queen("white queen", Position.C8);
       // Queen whiteQueen2 = new Queen("white queen", Position.A1);
        //Queen blackQueen = new Queen("black queen", Position.E8);
        //Rook whiteRook1 = new Rook("white rook",Position.A1);
        //Rook whiteRook2 = new Rook("white rook",Position.H1);
        //Rook blackRook1 = new Rook("black rook",Position.A8);
        //Rook blackRook2 = new Rook("black rook", Position.H8);
        Piece testPiece1 = new Bishop("white king",Position.A7);
        Piece testPiece2 = new Bishop("white knight",Position.D5);
        Piece testPiece3 = new Bishop("white knight",Position.C8);
        Piece testPiece4 = new Bishop("white knight",Position.B4);



        //Knight blackKnight1 = new Knight("black knight",Position.B8);
        //Knight blackKnight2 = new Knight("black knight",Position.G8);
        //Bishop whiteBishop1 = new Bishop("white bishop",Position.C1);
        //Bishop whiteBishop2 = new Bishop("white bishop",Position.F1);
        //Bishop blackBishop1 = new Bishop("black bishop",Position.C8);
        //Bishop blackBishop2 = new Bishop("black bishop",Position.F8);
        //Pawn whitePawn1 = new Pawn("white pawn",Position.A2);
        //Pawn whitePawn2 = new Pawn("white pawn",Position.B2);
        //Pawn whitePawn3 = new Pawn("white pawn",Position.C2);
        //Pawn whitePawn4 = new Pawn("white pawn",Position.D2);
        //Pawn whitePawn5 = new Pawn("white pawn",Position.E2);
        //Pawn whitePawn6 = new Pawn("white pawn",Position.F2);
        //Pawn whitePawn7 = new Pawn("white pawn",Position.G2);
        //Pawn whitePawn8 = new Pawn("white pawn",Position.H2);
        //Pawn blackPawn1 = new Pawn("black pawn",Position.A7);
        //Pawn blackPawn2 = new Pawn("black pawn",Position.B7);
        //Pawn blackPawn3 = new Pawn("black pawn",Position.C7);
        //Pawn blackPawn4 = new Pawn("black pawn",Position.D7);
        //Pawn blackPawn5 = new Pawn("black pawn",Position.E7);
        //Pawn blackPawn6 = new Pawn("black pawn",Position.F7);
        //Pawn blackPawn7 = new Pawn("black pawn",Position.G7);
        //Pawn blackPawn8 = new Pawn("black pawn",Position.H7);


        piecesOnBoard.add(testPiece1);
        piecesOnBoard.add(testPiece2);
        piecesOnBoard.add(testPiece3);
        piecesOnBoard.add(testPiece4);

        Board board = new BoardCreator().createBoard(piecesOnBoard);

        Table table = new Table(board);
    }
}
