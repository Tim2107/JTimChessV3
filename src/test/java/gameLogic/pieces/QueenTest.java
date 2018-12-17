package gameLogic.pieces;

import utils.Alliance;
import utils.Position;
import gameLogic.patterns.BishopPattern;
import org.junit.jupiter.api.Test;

class QueenTest {

    @Test
    public void printPotentialMoves() {
        Queen testQueen = new Queen("white queen", Position.E4);
        for (int j = 7; j > -1; j--) {
            for (int i = 0; i < 8; i++) {
                System.out.print(testQueen.getPotentialMoves()[i][j]);
            }
            System.out.println();
        }
    }

    @Test
    public void printTacticalOverlayPattern(){
        Queen testQueen = new Queen("white queen",Position.A8);

        testQueen.setTacticalOverlayAlliance(Alliance.BLACK);
        testQueen.setTacticalOverlayPatternType(new BishopPattern());

        for (int j = 7; j > -1; j--) {
            for (int i = 0; i < 8; i++) {
                System.out.print(testQueen.getTacticalOverlayPattern()[i][j]);
            }
            System.out.println();

        }
    }

}