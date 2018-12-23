package gameLogic.analyzationTools.tacticAnalyzers;

import gameLogic.analyzationTools.tacticDTOs.ChessTacticDto;
import utils.ChessField;
import utils.Position;

import java.util.ArrayList;
import java.util.List;

public interface TacticAnalyzer {

    int[][] compositionGrid = new int[8][8];

    List<ChessField> fieldsToAnalyze = new ArrayList<>();
    List<Position> fieldsInvolved = new ArrayList<>();
    List<Position> executionPoints = new ArrayList<>();

    ChessTacticDto chessTacticDto = null;


    public List<ChessField> getFieldsToAnalyze();
    
    public List<Position> getFieldsInvolved();

    public List<Position> getExecutionPoints();

    public ChessTacticDto getChessTacticDto();
}
