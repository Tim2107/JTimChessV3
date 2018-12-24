package utils;

import gameLogic.analyzationTools.DtoToChessFieldBoardAssigner;
import gameLogic.pieces.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FieldHighLighterTest {

    @Test
    void analyzePositionAndPutOutImportantFields(){
        List<Piece> piecesOnBoard = new ArrayList<>();

        //Queen whiteQueen = new Queen("white queen", Position.C8);
        //Queen whiteQueen2 = new Queen("white queen", Position.B6);
        //Rook blackRook1 = new Rook("black rook", Position.F5);
        //Bishop whiteBishop1 = new Bishop("white bishop", Position.D5);

        Piece testPiece1 = new Pawn("white king",Position.A8);
        Piece testPiece2 = new Pawn("white knight",Position.A7);
        Piece testPiece3 = new Pawn("white knight",Position.B8);
        Piece testPiece4 = new Pawn("white knight",Position.B7);
        Piece testPiece5 = new Pawn("white king",Position.B6);
        Piece testPiece6 = new Pawn("white knight",Position.C6);
        Piece testPiece7 = new Pawn("white knight",Position.D5);
        Piece testPiece8 = new Pawn("white knight",Position.D8);
        Piece testPiece9 = new Pawn("white king",Position.E8);
        Piece testPiece10 = new Pawn("white knight",Position.E6);
        Piece testPiece11 = new Pawn("white knight",Position.F8);
        Piece testPiece12 = new Pawn("white knight",Position.F7);
        Piece testPiece13 = new Pawn("white knight",Position.H4);


        piecesOnBoard.add(testPiece1);
        piecesOnBoard.add(testPiece2);
        piecesOnBoard.add(testPiece3);
        piecesOnBoard.add(testPiece4);
        piecesOnBoard.add(testPiece5);
        piecesOnBoard.add(testPiece6);
        piecesOnBoard.add(testPiece7);
        piecesOnBoard.add(testPiece8);
        piecesOnBoard.add(testPiece9);
        piecesOnBoard.add(testPiece10);
        piecesOnBoard.add(testPiece11);
        piecesOnBoard.add(testPiece12);
        piecesOnBoard.add(testPiece13);

        Board board = new BoardCreator().createBoard(piecesOnBoard);

        DtoToChessFieldBoardAssigner testAssigner = new DtoToChessFieldBoardAssigner(board);
        testAssigner.generateTacticDtosForGivenBoard();
        testAssigner.takeDtosAndStoreThemInFields();

        FieldHighLighter testFieldHighLighter = new FieldHighLighter(testAssigner.getBoard());
        HashMap<Position, Integer> executionPointsLevelMap = testFieldHighLighter.getExecutionPointsLevelMap();
        HashMap<Position, Integer> fieldsInvolvedLevelMap = testFieldHighLighter.getFieldsInvolvedLevelMap();

        printMap(executionPointsLevelMap);

        System.out.println();
        System.out.println();

        printMap(fieldsInvolvedLevelMap);


    }

    public static void printMap(Map map) {
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
        }
    }


