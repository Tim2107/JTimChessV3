package gameLogic.pieces;

import utils.Alliance;
import utils.Position;
import gameLogic.patterns.KnightPattern;
import org.junit.jupiter.api.Test;

class PawnTest {

    @Test
    public void printPotentialMoves() {
        Pawn testPawn = new Pawn("white pawn", Position.D6);
        for (int j = 7; j > -1; j--) {
            for (int i = 0; i < 8; i++) {
                System.out.print(testPawn.getPotentialMoves()[i][j]);
            }
            System.out.println();
        }
    }

    @Test
    public void printTacticalOverlayPattern(){
        Pawn testPawn = new Pawn("black pawn",Position.H6);

       testPawn.setTacticalOverlayAlliance(Alliance.BLACK);
       testPawn.setTacticalOverlayPatternType(new KnightPattern());

        for (int j = 7; j > -1; j--) {
            for (int i = 0; i < 8; i++) {
                System.out.print(testPawn.getTacticalOverlayPattern()[i][j]);
            }
            System.out.println();

        }
    }

}