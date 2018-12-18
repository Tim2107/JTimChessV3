package utils;

import gameLogic.pieces.*;

public class InitializeGame {

    Board board = new Board();

    King whiteKing = new King("white king",Position.D1);
    King blackKing = new King("black king",Position.D8);
    Queen whiteQueen = new Queen("white queen", Position.E1);
    Queen blackQueen = new Queen("black queen", Position.E8);
    Rook whiteRook1 = new Rook("white rook",Position.A1);
    Rook whiteRook2 = new Rook("white rook",Position.H1);
    Rook blackRook1 = new Rook("black rook",Position.A8);
    Rook blackRook2 = new Rook("black rook", Position.H8);
    Knight whiteKnight1 = new Knight("white knight",Position.B1);
    Knight whiteKnight2 = new Knight("white knight",Position.G1);
    Knight blackKnight1 = new Knight("black knight",Position.B8);
    Knight blackKnight2 = new Knight("black knight",Position.G8);
    Bishop whiteBishop1 = new Bishop("white bishop",Position.C1);
    Bishop whiteBishop2 = new Bishop("white bishop",Position.F1);
    Bishop blackBishop1 = new Bishop("black bishop",Position.C8);
    Bishop blackBishop2 = new Bishop("black bishop",Position.F8);
    Pawn whitePawn1 = new Pawn("white pawn",Position.A2);
    Pawn whitePawn2 = new Pawn("white pawn",Position.B2);
    Pawn whitePawn3 = new Pawn("white pawn",Position.C2);
    Pawn whitePawn4 = new Pawn("white pawn",Position.D2);
    Pawn whitePawn5 = new Pawn("white pawn",Position.E2);
    Pawn whitePawn6 = new Pawn("white pawn",Position.F2);
    Pawn whitePawn7 = new Pawn("white pawn",Position.G2);
    Pawn whitePawn8 = new Pawn("white pawn",Position.H2);
    Pawn blackPawn1 = new Pawn("black pawn",Position.A7);
    Pawn blackPawn2 = new Pawn("black pawn",Position.B7);
    Pawn blackPawn3 = new Pawn("black pawn",Position.C7);
    Pawn blackPawn4 = new Pawn("black pawn",Position.D7);
    Pawn blackPawn5 = new Pawn("black pawn",Position.E7);
    Pawn blackPawn6 = new Pawn("black pawn",Position.F7);
    Pawn blackPawn7 = new Pawn("black pawn",Position.G7);
    Pawn blackPawn8 = new Pawn("black pawn",Position.H7);

    public InitializeGame(){
     this.board.putPieceOnField(whiteKing);
     this.board.putPieceOnField(blackKing);
     this.board.putPieceOnField(whiteQueen);
     this.board.putPieceOnField(blackQueen);
     this.board.putPieceOnField(whiteRook1);
     this.board.putPieceOnField(whiteRook2);
     this.board.putPieceOnField(whiteKnight1);
     this.board.putPieceOnField(whiteKnight2);
     this.board.putPieceOnField(whiteBishop1);
     this.board.putPieceOnField(whiteBishop2);
     this.board.putPieceOnField(blackRook1);
     this.board.putPieceOnField(blackRook2);
     this.board.putPieceOnField(blackKnight1);
     this.board.putPieceOnField(blackKnight2);
     this.board.putPieceOnField(blackBishop1);
     this.board.putPieceOnField(blackBishop2);
     this.board.putPieceOnField(whitePawn1);
     this.board.putPieceOnField(whitePawn2);
     this.board.putPieceOnField(whitePawn3);
     this.board.putPieceOnField(whitePawn4);
     this.board.putPieceOnField(whitePawn5);
     this.board.putPieceOnField(whitePawn6);
     this.board.putPieceOnField(whitePawn7);
     this.board.putPieceOnField(whitePawn8);
     this.board.putPieceOnField(blackPawn1);
     this.board.putPieceOnField(blackPawn2);
     this.board.putPieceOnField(blackPawn3);
     this.board.putPieceOnField(blackPawn4);
     this.board.putPieceOnField(blackPawn5);
     this.board.putPieceOnField(blackPawn6);
     this.board.putPieceOnField(blackPawn7);
     this.board.putPieceOnField(blackPawn8);
    }

    public Board getStartingBoard(){
        return this.board;
    }
}
