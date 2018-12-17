package utils;

import org.junit.jupiter.api.Test;

class PositionTranslatorTest {

    @Test
    void positionKnownConversion(){
        PositionTranslator positionKnownTranslation = new PositionTranslator(Position.H1,null, null, null);
        int columnInLogicGrid = positionKnownTranslation.getColumnInLogicGrid();
        int rowInLogicGrid = positionKnownTranslation.getRowInLogicGrid();
        int guiTileId = positionKnownTranslation.getGuiTileId();
        Position position = positionKnownTranslation.getHumanReadablePosition();

        System.out.println("Position: " + position + " Grid: " + columnInLogicGrid + " " + rowInLogicGrid + " , TileID: " +  guiTileId);
    }

    @Test
    void gridLayerKnownConversion(){
        PositionTranslator positionKnownTranslation = new PositionTranslator(null,7, 7, null);

        int columnInLogicGrid = positionKnownTranslation.getColumnInLogicGrid();
        int rowInLogicGrid = positionKnownTranslation.getRowInLogicGrid();
        int guiTileId = positionKnownTranslation.getGuiTileId();
        Position position = positionKnownTranslation.getHumanReadablePosition();

        System.out.println("Position: " + position + " Grid: " + columnInLogicGrid + " " + rowInLogicGrid + " , TileID: " +  guiTileId);

    }

    @Test
    void TileIdKnownConversion(){
        PositionTranslator positionKnownTranslation = new PositionTranslator(null,null, null, 8);

        int columnInLogicGrid = positionKnownTranslation.getColumnInLogicGrid();
        int rowInLogicGrid = positionKnownTranslation.getRowInLogicGrid();
        int guiTileId = positionKnownTranslation.getGuiTileId();
        Position position = positionKnownTranslation.getHumanReadablePosition();

        System.out.println("Position: " + position + " Grid: " + columnInLogicGrid + " " + rowInLogicGrid + " , TileID: " +  guiTileId);

    }


    @Test
    void convertPositionToLogicLayerGridColumn() {
    }

    @Test
    void convertPositionToLogicLayerGridRow() {
    }

    @Test
    void convertLogicLayerGridToGuiTileId() {
    }

    @Test
    void convertLogicLayerGridToPosition() {
    }

    @Test
    void convertGuiTileIdToLogicLayerGrid() {
    }
}