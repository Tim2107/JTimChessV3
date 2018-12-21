package utils;

import gameLogic.pieces.Piece;

import java.util.List;

public class BoardCreator {


    List<Piece> piecesOnBoard;




    public Board createBoard(List<Piece> piecesOnBoard){
        Board board = new Board();
        piecesOnBoard.forEach(piece -> {board.putPieceOnField(piece);});
        return board;
    }
}
