package logic.patterns;

public abstract class ChessPatternBase {

    int[][]grid = new int[8][8];
    final int PIECE_DUMMY = 9;

    public ChessPatternBase(){
        this.grid = initializeGrid();
    }


    private int[][] initializeGrid() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = 0;
            }
        }
        return grid;
    }
}
