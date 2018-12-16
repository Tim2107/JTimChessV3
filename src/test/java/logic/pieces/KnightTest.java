package logic.pieces;

import logic.Alliance;
import logic.Position;
import logic.patterns.BishopPattern;
import org.junit.jupiter.api.Test;

class KnightTest {

    @Test
    public void printPotentialMoves() {
        Knight testKnight = new Knight("white knight", Position.F5);

        for (int j = 7; j > -1; j--) {
            for (int i = 0; i < 8; i++) {
                System.out.print(testKnight.getPotentialMoves()[i][j]);
            }
            System.out.println();
        }
    }

    @Test
    public void printTacticalOverlayPattern(){
        Knight testKing = new Knight("black knight",Position.C8);

       testKing.setTacticalOverlayAlliance(Alliance.WHITE);
       testKing.setTacticalOverlayPatternType(new BishopPattern());

        for (int j = 7; j > -1; j--) {
            for (int i = 0; i < 8; i++) {
                System.out.print(testKing.getTacticalOverlayPattern()[i][j]);
            }
            System.out.println();
        }

    }

}