package gameLogic.analyzationTools.tacticAnalyzers;

import utils.Alliance;
import utils.ChessField;

import java.util.List;

public class KingTacticAnalyzer extends TacticAnalyzerBase implements TacticAnalyzer {

    public KingTacticAnalyzer(List<ChessField> fieldsToAnalyze, Alliance alliance){
        super(fieldsToAnalyze,alliance,"king");
    }
}
