package gameLogic;

import gameLogic.analyzationTools.Analyzer;
import gameLogic.pieces.Piece;
import gameLogic.pieces.Queen;
import org.junit.jupiter.api.Test;
import utils.Position;

import java.util.ArrayList;
import java.util.List;

class AnalyzerTest {


    @Test
    void analyzerBoardTest(){
        Queen whiteQueen = new Queen("white queen", Position.E1);
        Queen blackQueen = new Queen("black queen", Position.E8);
        List<Piece> testList = new ArrayList<>();
        testList.add(whiteQueen);
        testList.add(blackQueen);

        Analyzer testAnalyzer = new Analyzer(testList);
        String name = testAnalyzer.getBoardToAnalyze().getChessfield(Position.E8).getIsOccupiedBy().getName();
        System.out.println(name);
    }

    @Test
    void compositionTest(){

        Queen whiteQueen = new Queen("white queen", Position.E1);
        Queen blackQueen = new Queen("black queen", Position.E8);
        List<Piece> testList = new ArrayList<>();
        testList.add(whiteQueen);
        testList.add(blackQueen);

        Analyzer testAnalyzer = new Analyzer(testList);
        int[][]analysedGrid = testAnalyzer.getCompositionGrid();

        for (int j = 7; j > -1; j--) {
            for (int i = 0; i < 8; i++) {
                System.out.print(analysedGrid[i][j]);
            }
            System.out.println();
        }

    }
}