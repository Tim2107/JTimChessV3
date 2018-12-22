package gameLogic.analyzationTools.tacticAnalyzers;

import utils.Alliance;
import utils.ChessField;

import java.util.List;

public class RookTacticAnalyzer extends TacticAnalyzerBase {

    public RookTacticAnalyzer(List<ChessField> fieldsToAnalyze, Alliance alliance){
        super(fieldsToAnalyze,alliance,"rook");
    }
}
