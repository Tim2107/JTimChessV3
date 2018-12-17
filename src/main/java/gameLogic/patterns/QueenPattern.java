package gameLogic.patterns;

import utils.Alliance;
import utils.Position;

public class QueenPattern extends ChessPatternBase implements ChessPattern {

   BishopPattern bishopPartQueenPattern = new BishopPattern();
   RookPattern rookPartQueenPattern = new RookPattern();

    @Override
    public void setChessPatternForPosition(Position position, Alliance alliance) {
        composeQueenPattern(bishopPartQueenPattern.getChessPattern(position, alliance));
        composeQueenPattern(rookPartQueenPattern.getChessPattern(position,alliance));
        }

    @Override
    public int[][] getChessPattern(Position position, Alliance alliance) {
        setChessPatternForPosition(position,alliance);
        return this.grid;
    }

    private void composeQueenPattern(int[][] queenPatternPart){
        for (int row = 7; row > -1; row--) {
            for (int column = 0; column < 8; column++) {
                if(queenPatternPart[column][row] != 0)
                this.grid[column][row]=queenPatternPart[column][row];
                }
        }
    }
}
