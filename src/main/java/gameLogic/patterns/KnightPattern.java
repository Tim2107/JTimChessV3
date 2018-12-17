package gameLogic.patterns;

import utils.Alliance;
import utils.Position;

public class KnightPattern extends ChessPatternBase implements ChessPattern {
    @Override
    public void setChessPatternForPosition(Position position, Alliance alliance) {

        int column = position.convertPositionToColumn();
        int row = position.convertPositionToRow();

        grid[column][row] = PIECE_DUMMY;

        if (column - 2 > -1 && row - 1 > -1) {
            grid[column - 2][row - 1] = alliance.indicator;
        }
        if (column - 2 > -1 && row + 1 < 8) {
            grid[column - 2][row + 1] = alliance.indicator;
        }
        if (column + 2 < 8 && row - 1 > -1) {
            grid[column + 2][row - 1] = alliance.indicator;
        }
        if (column + 2 < 8 && row + 1 < 8) {
            grid[column + 2][row + 1] = alliance.indicator;
        }
        if (column - 1 > -1 && row - 2 > -1) {
            grid[column - 1][row - 2] = alliance.indicator;
        }
        if (column - 1 > -1 && row + 2 < 8) {
            grid[column - 1][row + 2] = alliance.indicator;
        }
        if (column + 1 < 8 && row - 2 > -1) {
            grid[column + 1][row - 2] = alliance.indicator;
        }
        if (column + 1 < 8 && row + 2 < 8) {
            grid[column + 1][row + 2] = alliance.indicator;
        }
    }

    @Override
    public int[][] getChessPattern(Position position, Alliance alliance) {
        setChessPatternForPosition(position,alliance);
        return this.grid;
    }
}
