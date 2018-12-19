package gameLogic;

import gameLogic.pieces.Piece;
import gameLogic.pieces.Queen;
import org.junit.jupiter.api.Test;
import utils.Position;

import java.util.ArrayList;
import java.util.List;

class AnalyzerTest {


    @Test
    void analyzerTest(){


        Queen whiteQueen = new Queen("white queen", Position.E1);
        Queen blackQueen = new Queen("black queen", Position.E8);
        List<Piece> testList = new ArrayList<>();
        testList.add(whiteQueen);
        testList.add(blackQueen);

        Analyzer testAnalyzer = new Analyzer(testList);
        String name = testAnalyzer.getBoardToAnalyze().getChessfield(Position.E8).getIsOccupiedBy().getName();
        System.out.println(name);
    }
}