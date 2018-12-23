package gameLogic.analyzationTools.tacticAnalyzers;

import utils.Alliance;
import utils.ChessField;

import java.util.List;

public class QueenTacticAnalyzer extends TacticAnalyzerBase implements TacticAnalyzer {

    public QueenTacticAnalyzer(List<ChessField> fieldsToAnalyze, Alliance alliance){
        super(fieldsToAnalyze,alliance,"queen");
    }

}
