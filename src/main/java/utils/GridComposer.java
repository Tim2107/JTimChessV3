package utils;

public class GridComposer {

    int [][]inputGridOne;
    int [][]inputGridTwo;
    int [][]composedGrid;

    public GridComposer(int[][] inputGridOne, int [][]inputGridTwo){
        this.inputGridOne = inputGridOne;
        this.inputGridTwo = inputGridTwo;
        this.composedGrid = composeGrid(inputGridOne,inputGridTwo);
    }

    private int[][] composeGrid(int[][] inputGridOne, int[][] inputGridTwo) {
        int[][] composedGrid = new int[inputGridOne.length][inputGridOne[0].length];
            for(int i = 0; i < inputGridOne.length; i++){
                for(int j = 0; j < inputGridOne[0].length; j++){
                    composedGrid[i][j]=inputGridOne[i][j]+inputGridTwo[i][j];
                }
            }
        return composedGrid;
    }

    public int[][] getComposedGrid() {
        return composedGrid;
    }

}

