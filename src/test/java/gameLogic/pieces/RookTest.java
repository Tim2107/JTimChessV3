package gameLogic.pieces;

import utils.Alliance;
import utils.Position;
import gameLogic.patterns.KingPattern;
import org.junit.jupiter.api.Test;

class RookTest {

    @Test
    public void printPotentialMoves() {
        Rook testRook = new Rook("white rook", Position.A8);
        for (int j = 7; j > -1; j--) {
            for (int i = 0; i < 8; i++) {
                System.out.print(testRook.getPotentialMoves()[i][j]);
            }
            System.out.println();
        }
    }

    @Test
    public void printTacticalOverlayPattern(){
        Rook testRook = new Rook("white rook",Position.H7);

        testRook.setTacticalOverlayAlliance(Alliance.BLACK);
        testRook.setTacticalOverlayPatternType(new KingPattern());

        for (int j = 7; j > -1; j--) {
            for (int i = 0; i < 8; i++) {
                System.out.print(testRook.getTacticalOverlayPattern()[i][j]);
            }
            System.out.println();
        }
    }

}