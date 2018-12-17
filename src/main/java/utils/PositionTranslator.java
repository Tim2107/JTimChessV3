package utils;

import static java.lang.Math.abs;

public class PositionTranslator {

    private Position humanReadablePosition;
    private int columnInLogicGrid;
    private int rowInLogicGrid;
    private int guiTileId;

    public PositionTranslator(Position position, Integer column, Integer row, Integer tileId){

        if(position != null){
            this.humanReadablePosition = position;
            convertPositionToLogicLayerGridColumn(position);
            convertPositionToLogicLayerGridRow(position);
            convertLogicLayerGridToGuiTileId(getColumnInLogicGrid(),getRowInLogicGrid());
        }

        if(row != null && column != null){
            this.columnInLogicGrid = column;
            this.rowInLogicGrid = row;
            convertLogicLayerGridToGuiTileId(column, row);
            convertLogicLayerGridToPosition(column,row);
        }

        if(tileId != null){
            this.guiTileId = tileId;
            convertGuiTileIdToLogicLayerGrid(tileId);
            convertLogicLayerGridToPosition(getColumnInLogicGrid(),getRowInLogicGrid());

        }
    }

    public void convertPositionToLogicLayerGridColumn(Position humanReadablePosition) {
        String[] parsedPosition = humanReadablePosition.toString().split("");
        Character column = parsedPosition[0].charAt(0);
        columnInLogicGrid = column - 'A';
    }

    public void convertPositionToLogicLayerGridRow(Position humanReadablePosition) {
        String[] parsedPosition = humanReadablePosition.toString().split("");
        int row = Integer.parseInt(parsedPosition[1]);
        rowInLogicGrid = row - 1;
    }

    public void convertLogicLayerGridToGuiTileId(int columnInGrid, int rowInGrid){
        int rowConversion = abs(rowInGrid - 7) * 8;
        guiTileId = rowConversion + columnInGrid;
    }

    public void convertLogicLayerGridToPosition(int columnInGrid, int rowInGrid){
        String positionColumn = Character.toString ((char) (columnInGrid + 65));
        String positionRow = Integer.toString(rowInGrid + 1);
        humanReadablePosition = Position.valueOf(positionColumn + positionRow);
    }

    public void convertGuiTileIdToLogicLayerGrid(int tileId){
        columnInLogicGrid = tileId%8;
        rowInLogicGrid = 7 -((tileId - columnInLogicGrid)/8);
    }

    public Position getHumanReadablePosition() {
        return humanReadablePosition;
    }

    public int getColumnInLogicGrid() {
        return columnInLogicGrid;
    }

    public int getRowInLogicGrid() {
        return rowInLogicGrid;
    }

    public int getGuiTileId() {
        return guiTileId;
    }
}
