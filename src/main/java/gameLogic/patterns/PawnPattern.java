package gameLogic.patterns;

import utils.Alliance;
import utils.Position;

public class PawnPattern extends ChessPatternBase implements ChessPattern {

    @Override
    public void setChessPatternForPosition(Position position, Alliance alliance) {

        int column = position.convertPositionToColumn();
        int row = position.convertPositionToRow();

        grid[column][row] = PIECE_DUMMY;

        if (alliance == Alliance.WHITE) {
            if (row != 7 && column != 0) {
                grid[column - 1][row + 1] = alliance.indicator;
            }
            if (row != 7 && column != 7) {
                grid[column + 1][row + 1] = alliance.indicator;
            }
        }

		if (alliance == Alliance.BLACK) {
            if (row != 0 && column != 0) {
                grid[column - 1][row + alliance.indicator] = alliance.indicator;
            }
            if (row != 0 && column != 7) {
                grid[column + 1][row + alliance.indicator] = alliance.indicator;
            }
        }
    }

    @Override
    public int[][] getChessPattern(Position position, Alliance alliance) {
        setChessPatternForPosition(position,alliance);
        return this.grid;
    }
}

