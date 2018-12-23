package gameLogic.analyzationTools.tacticAnalyzers;

import utils.Alliance;
import utils.ChessField;

import java.util.List;

public class TacticAnalyzerFactory {

    public TacticAnalyzer instantiateTacticAnalyzer(List<ChessField> fieldsToAnalyze, Alliance alliance, String patternType){
        if (patternType==null){
            return null;
        }

        else if (patternType.equalsIgnoreCase("king")){
            return new KingTacticAnalyzer(fieldsToAnalyze, alliance);
        }

        else if (patternType.equalsIgnoreCase("queen")){
            return new QueenTacticAnalyzer(fieldsToAnalyze,alliance);
        }
        else if (patternType.equalsIgnoreCase("rook")){
            return new RookTacticAnalyzer(fieldsToAnalyze,alliance);
        }
        else if (patternType.equalsIgnoreCase("knight")){
            return new KnightTacticAnalyzer(fieldsToAnalyze,alliance);
        }
        else if (patternType.equalsIgnoreCase("bishop")){
            return new BishopTacticAnalyzer(fieldsToAnalyze, alliance);
        }

        else if (patternType.equalsIgnoreCase("pawn")){
            return new PawnTacticAnalyzer(fieldsToAnalyze, alliance);
        }

        return null;
    }
}
