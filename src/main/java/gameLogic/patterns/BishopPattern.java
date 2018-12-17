package gameLogic.patterns;

import utils.Alliance;
import utils.Position;

public class BishopPattern extends ChessPatternBase implements ChessPattern {

    @Override
    public void setChessPatternForPosition(Position position, Alliance alliance) {

        int column = position.convertPositionToColumn();
        int row = position.convertPositionToRow();

        grid[column][row] = PIECE_DUMMY;

        for (int j = row + 1, i = column + 1; j < 8 && i < 8; j++, i++) {
            grid[i][j] = alliance.indicator;
        }

        for (int j = row - 1, i = column + 1; j > -1 && i < 8; j--, i++) {
            grid[i][j] = alliance.indicator;
        }

        for (int j = row - 1, i = column - 1; j > -1 && i > -1; j--, i--) {
            grid[i][j] = alliance.indicator;
        }

        for (int j = row + 1, i = column - 1; j < 8 && i > -1; j++, i--) {
            grid[i][j] = alliance.indicator;
        }
    }

    @Override
    public int[][] getChessPattern(Position position, Alliance alliance) {
        setChessPatternForPosition(position,alliance);
        return this.grid;
    }
}
