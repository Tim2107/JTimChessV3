package logic.pieces;

import logic.Alliance;
import logic.Position;
import logic.patterns.RookPattern;
import org.junit.jupiter.api.Test;

class BishopTest {

    @Test
    public void printPotentialMoves() {
    Bishop testBishop = new Bishop("white rook", Position.C6);
    for (int j = 7; j > -1; j--) {
        for (int i = 0; i < 8; i++) {
            System.out.print(testBishop.getPotentialMoves()[i][j]);
        }
        System.out.println();
    }
}

    @Test
    public void printTacticalOverlayPattern(){
        Bishop testBishop = new Bishop("white Bishop",Position.G5);

        testBishop.setTacticalOverlayAlliance(Alliance.BLACK);
        testBishop.setTacticalOverlayPatternType(new RookPattern());

        for (int j = 7; j > -1; j--) {
            for (int i = 0; i < 8; i++) {
                System.out.print(testBishop.getTacticalOverlayPattern()[i][j]);
            }
            System.out.println();

        }
    }
}