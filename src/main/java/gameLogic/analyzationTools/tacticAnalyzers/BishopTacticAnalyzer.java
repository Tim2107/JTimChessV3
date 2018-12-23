package gameLogic.analyzationTools.tacticAnalyzers;

import utils.Alliance;
import utils.ChessField;

import java.util.List;

public class BishopTacticAnalyzer extends TacticAnalyzerBase implements TacticAnalyzer {

    public BishopTacticAnalyzer(List<ChessField> fieldsToAnalyze, Alliance alliance){
        super(fieldsToAnalyze,alliance,"bishop");
    }

}
