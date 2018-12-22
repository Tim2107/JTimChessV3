package gameLogic.analyzationTools.tacticAnalyzers;

import gameLogic.analyzationTools.tacticDTOs.ChessTacticDto;
import gameLogic.analyzationTools.tacticDTOs.TacticDtoFactory;
import gameLogic.patterns.ChessPatternFactory;
import utils.*;

import java.util.*;

import static java.lang.Math.abs;

public abstract class TacticAnalyzerBase {
    int[][] compositionGrid = new int[8][8];

    private List<ChessField> fieldsToAnalyze = new ArrayList<>();
    private List<Position> fieldsInvolved = new ArrayList<>();
    private List<Position> executionPoints = new ArrayList<>();

    ChessTacticDto chessTacticDto;

    public TacticAnalyzerBase(List<ChessField> fieldsToAnalyze, Alliance alliance, String typeSwitch){
        this.fieldsToAnalyze = fieldsToAnalyze;
        initializeGrid();
        TacticDtoFactory tacticDtoFactory = new TacticDtoFactory();
        chessTacticDto = tacticDtoFactory.instantiateTacticDto(typeSwitch);
        this.chessTacticDto = analyze(this.fieldsToAnalyze, alliance, typeSwitch);
    }

    private void initializeGrid() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                compositionGrid[i][j] = 0;
            }
        }
    }

    public ChessTacticDto analyze(List<ChessField> fieldsToAnalyze, Alliance alliance, String typeSwitch){

        Set<Position> executionPointsSet = new LinkedHashSet<>();
        Set<Position> fieldsInvolvedSet = new LinkedHashSet<>();
        ChessPatternFactory patternFactory = new ChessPatternFactory();


        fieldsToAnalyze.forEach(field
                        -> {
                    field.setTacticalOverlayAlliance(alliance);
                    field.setTacticalOverlayPatternType(patternFactory.instantiateChessPattern(typeSwitch));
                    int[][] patternGrid = field.getTacticalOverlayPattern();
                    GridComposer fieldOverlayComposer = new GridComposer(compositionGrid, patternGrid);
                    compositionGrid = fieldOverlayComposer.getComposedGrid();
                }
        );

        for (int j = 7; j > -1; j--) {
            for (int i = 0; i < 8; i++) {
                System.out.print(compositionGrid[i][j]);
            }
            System.out.println();

        }



        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(abs(compositionGrid[i][j])>1){
                    PositionTranslator markedFieldTranslator = new PositionTranslator(null,i,j,null);
                    Position markedField = markedFieldTranslator.getHumanReadablePosition();
                    executionPointsSet.add(markedField);
                    fieldsToAnalyze.forEach(field -> fieldsInvolvedSet.add(field.getPosition()));
                }
            }
        }

        executionPoints.addAll(executionPointsSet);
        fieldsInvolved.addAll(fieldsInvolvedSet);

        chessTacticDto.setExecutionPoints(executionPoints);
        chessTacticDto.setFieldsInvolved(fieldsInvolved);
        return chessTacticDto;
    }

    public ChessTacticDto getChessTacticDto() {
        return chessTacticDto;
    }
}
