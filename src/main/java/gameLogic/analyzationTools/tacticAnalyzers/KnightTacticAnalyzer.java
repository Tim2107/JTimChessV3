package gameLogic.analyzationTools.tacticAnalyzers;

import utils.Alliance;
import utils.ChessField;

import java.util.List;

public class KnightTacticAnalyzer extends TacticAnalyzerBase {


    public KnightTacticAnalyzer(List<ChessField> fieldsToAnalyze, Alliance alliance){
       super(fieldsToAnalyze,alliance,"knight");
    }


}
