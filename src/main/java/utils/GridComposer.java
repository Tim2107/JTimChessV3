package utils;

public class GridComposer {

  /*  Object[][]inputGridOne;
    Object[][]inputGridTwo;
    Object[][]composedGrid;

   public Object[][] convertIntToObjectArray(int[][] inputGrid){
       Object[][] objectArray = new Object[inputGrid.length][inputGrid[0].length];
       for(int i = 0; i < inputGrid.length; i++){
           for(int j = 0; j < inputGrid[0].length; j++){
               objectArray[i][j]=inputGrid[i][j];
           }
       }
       return objectArray;
   }

    public Object[][] getInputGridOne() {
        return inputGridOne;
    }

    public void setInputGridOne(Object[][] inputGridOne) {
        this.inputGridOne = inputGridOne;
    }

    public Object[][] getInputGridTwo() {
        return inputGridTwo;
    }

    public void setInputGridTwo(Object[][] inputGridTwo) {
        this.inputGridTwo = inputGridTwo;
    }

    public Object[][] getComposedGrid() {
        return composedGrid;
    }

    public void setComposedGrid() {
        this.composedGrid = composedGrid;
    }

*/

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

