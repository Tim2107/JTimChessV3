package gameLogic.patterns;

import utils.Alliance;
import utils.Position;

public class KingPattern extends ChessPatternBase implements ChessPattern {

    @Override
    public void setChessPatternForPosition(Position position, Alliance alliance) {

        int column = position.convertPositionToColumn();
        int row = position.convertPositionToRow();

        grid[column][row] = PIECE_DUMMY;

        if (column != 0 && row != 0) {
            grid[column - 1][row - 1] = alliance.indicator;
        }
        if (column != 0 && row != 7) {
            grid[column - 1][row + 1] = alliance.indicator;
        }

        if (column != 7 && row != 0) {
            grid[column + 1][row - 1] = alliance.indicator;
        }
        if (column != 7 && row != 7) {
            grid[column + 1][row + 1] = alliance.indicator;
        }

        if (column != 0) {
            grid[column - 1][row] = alliance.indicator;
        }

        if (column != 7) {
            grid[column + 1][row] = alliance.indicator;
        }

        if (row != 0) {
            grid[column][row - 1] = alliance.indicator;
        }

        if (row != 7) {
            grid[column][row + 1] = alliance.indicator;
        }

        }

    @Override
    public int[][] getChessPattern(Position position, Alliance alliance) {
        setChessPatternForPosition(position,alliance);
        return this.grid;
    }
}
