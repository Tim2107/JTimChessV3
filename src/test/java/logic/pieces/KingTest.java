package logic.pieces;

import logic.Alliance;
import logic.Position;
import logic.patterns.RookPattern;
import org.junit.jupiter.api.Test;

class KingTest {


    @Test
    public void printPotentialMoves() {
        King testKing = new King("white king", Position.D4);

        for (int j = 7; j > -1; j--) {
            for (int i = 0; i < 8; i++) {
                System.out.print(testKing.getPotentialMoves()[i][j]);
            }
            System.out.println();
        }
    }

    @Test
    public void printTacticalOverlayPattern(){
        King testKing = new King("white king",Position.D5);

        testKing.setTacticalOverlayAlliance(Alliance.WHITE);
        testKing.setTacticalOverlayPatternType(new RookPattern());

        for (int j = 7; j > -1; j--) {
            for (int i = 0; i < 8; i++) {
                System.out.print(testKing.getTacticalOverlayPattern()[i][j]);
            }
            System.out.println();
        }

    }
}