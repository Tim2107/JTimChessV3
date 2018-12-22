package gameLogic.analyzationTools;

import gameLogic.pieces.Bishop;
import gameLogic.pieces.Piece;
import gameLogic.pieces.Queen;
import gameLogic.pieces.Rook;
import org.junit.jupiter.api.Test;
import utils.Board;
import utils.BoardCreator;
import utils.ChessField;
import utils.Position;

import java.util.ArrayList;
import java.util.List;

class TacticDtoBuilderBlueprintTest {



    @Test
    void fieldCombinationTest(){

        ChessField fieldA1 = new ChessField(Position.A1,null);
        ChessField fieldB2 = new ChessField(Position.B2,null);
        ChessField fieldC3 = new ChessField(Position.C3,null);
        ChessField fieldD4 = new ChessField(Position.D4,null);
        ChessField fieldE5 = new ChessField(Position.E5,null);


        List<ChessField> testList = new ArrayList<>();

        testList.add(fieldA1);
        testList.add(fieldB2);
        testList.add(fieldC3);
        testList.add(fieldD4);
        testList.add(fieldE5);

        TacticDtoBuilderBlueprint testBuilder = new TacticDtoBuilderBlueprint();

        testBuilder.goThroughListAndMakeSmallCombinationLists(testList);
        System.out.println(testBuilder.combinationsToAnalyzeList.get(2).get(0).getPosition());

        System.out.println(testBuilder.combinationsToAnalyzeList.get(2).get(1).getPosition());
    }

    @Test
    void fieldsFromBoardTest(){
        TacticDtoBuilderBlueprint tacticDtoBuilderBlueprint = new TacticDtoBuilderBlueprint();

        List<Piece> piecesOnBoard = new ArrayList<>();
        //King whiteKing = new King("white king", Position.D1);
        //King blackKing = new King("black king",Position.D8);
        Queen whiteQueen = new Queen("white queen", Position.C8);
        Queen whiteQueen2 = new Queen("white queen", Position.A1);
        //Queen blackQueen = new Queen("black queen", Position.E8);
        //Rook whiteRook1 = new Rook("white rook",Position.A1);
        //Rook whiteRook2 = new Rook("white rook",Position.H1);
        Rook blackRook1 = new Rook("black rook",Position.A8);
        //Rook blackRook2 = new Rook("black rook", Position.H8);
        // Knight whiteKnight1 = new Knight("white knight",Position.A8);
        // Knight whiteKnight2 = new Knight("white knight",Position.D5);
        //Knight blackKnight1 = new Knight("black knight",Position.B8);
        //Knight blackKnight2 = new Knight("black knight",Position.G8);
        Bishop whiteBishop1 = new Bishop("white bishop",Position.C1);
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


        piecesOnBoard.add(whiteQueen);
        piecesOnBoard.add(whiteQueen2);
        piecesOnBoard.add(blackRook1);
        piecesOnBoard.add(whiteBishop1);


        Board board = new BoardCreator().createBoard(piecesOnBoard);

        tacticDtoBuilderBlueprint.getFieldsToAnalyzeFromPiecesOnBoard(board);

       tacticDtoBuilderBlueprint.getFieldsToAnalyze().forEach(field -> {System.out.println(field.getPosition());});

    }

}