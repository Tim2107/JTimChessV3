package gameLogic.analyzationTools;

import gameLogic.patterns.KnightPattern;
import utils.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class KnightAnalyzer {

    int[][] compositionGrid = new int[8][8];

    List<ChessField> fieldsToAnalyze = new ArrayList<>();
    List<Position> fieldsInvolved = new ArrayList<>();
    List<Position> executionPoints = new ArrayList<>();

    KnightTacticDto knightTacticDto = new KnightTacticDto();

    public KnightAnalyzer(List<ChessField> fieldsToAnalyze, Alliance alliance){
        this.fieldsToAnalyze = fieldsToAnalyze;
        initializeGrid();
        knightTacticDto = analyze(this.fieldsToAnalyze, alliance);
    }

    public KnightTacticDto analyze(List<ChessField> fieldsToAnalyze, Alliance alliance){
        KnightTacticDto knightTacticDto = new KnightTacticDto();
        fieldsToAnalyze.forEach(field
                -> {
                    field.setTacticalOverlayAlliance(alliance);
                    field.setTacticalOverlayPatternType(new KnightPattern());
                    int[][] knightGrid = field.getTacticalOverlayPattern();
                    GridComposer fieldOverlayComposer = new GridComposer(compositionGrid, knightGrid);
                    compositionGrid = fieldOverlayComposer.getComposedGrid();
                    }
        );

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(abs(compositionGrid[i][j])>1){
                    PositionTranslator markedFieldTranslator = new PositionTranslator(null,i,j,null);
                    Position markedField = markedFieldTranslator.getHumanReadablePosition();
                    executionPoints.add(markedField);
                    fieldsToAnalyze.forEach(field -> fieldsInvolved.add(field.getPosition()));
                }
            }
        }

        knightTacticDto.setExecutionPoints(executionPoints);
        knightTacticDto.setFieldsInvolved(fieldsInvolved);
        return knightTacticDto;
    }

    public KnightTacticDto getKnightTacticDto() {
        return knightTacticDto;
    }

    private void initializeGrid() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                compositionGrid[i][j] = 0;
            }
        }
    }
}
