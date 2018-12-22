package gameLogic.patterns;

import utils.Alliance;
import utils.Position;

public class RookPattern extends ChessPatternBase implements ChessPattern  {

    @Override
    public void setChessPatternForPosition(Position position, Alliance alliance) {

        int column = position.convertPositionToColumn();
        int row = position.convertPositionToRow();

        for (int i = 0; i < 8; i++) {
            if (i != row) {
                grid[column][i] = alliance.indicator;
            }
            if (i != column) {
                grid[i][row] = alliance.indicator;
            }
        }
    }

    @Override
    public int[][] getChessPattern(Position position, Alliance alliance) {
        setChessPatternForPosition(position,alliance);
        return this.grid;
    }
}
