package gameLogic.analyzationTools.tacticAnalyzers;

import gameLogic.analyzationTools.tacticAnalyzers.AttackAnalyzer;
import gameLogic.pieces.Piece;
import gameLogic.pieces.Queen;
import org.junit.jupiter.api.Test;
import utils.Position;

import java.util.ArrayList;
import java.util.List;

class AttackAnalyzerTest {


    @Test
    void analyzerBoardTest(){
        Queen whiteQueen = new Queen("white queen", Position.E1);
        Queen blackQueen = new Queen("black queen", Position.E8);
        List<Piece> testList = new ArrayList<>();
        testList.add(whiteQueen);
        testList.add(blackQueen);

        AttackAnalyzer testAttackAnalyzer = new AttackAnalyzer(testList);
        String name = testAttackAnalyzer.getBoardToAnalyze().getChessfield(Position.E8).getIsOccupiedBy().getName();
        System.out.println(name);
    }

    @Test
    void compositionTest(){

        Queen whiteQueen = new Queen("white queen", Position.E1);
        Queen blackQueen = new Queen("black queen", Position.E8);
        List<Piece> testList = new ArrayList<>();
        testList.add(whiteQueen);
        testList.add(blackQueen);

        AttackAnalyzer testAttackAnalyzer = new AttackAnalyzer(testList);
        int[][]analysedGrid = testAttackAnalyzer.getCompositionGrid();

        for (int j = 7; j > -1; j--) {
            for (int i = 0; i < 8; i++) {
                System.out.print(analysedGrid[i][j]);
            }
            System.out.println();
        }

    }
}