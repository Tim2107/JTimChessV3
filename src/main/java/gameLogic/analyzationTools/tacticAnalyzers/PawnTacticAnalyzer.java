package gameLogic.analyzationTools.tacticAnalyzers;

import utils.Alliance;
import utils.ChessField;

import java.util.List;

public class PawnTacticAnalyzer extends TacticAnalyzerBase implements TacticAnalyzer {

    public PawnTacticAnalyzer(List<ChessField> fieldsToAnalyze, Alliance alliance){
        super(fieldsToAnalyze,alliance,"pawn");
    }
}
