package gameLogic.analyzationTools.tacticAnalyzers;

import gameLogic.analyzationTools.tacticDTOs.RookTacticDto;
import org.junit.jupiter.api.Test;
import utils.Alliance;
import utils.ChessField;
import utils.Position;

import java.util.ArrayList;
import java.util.List;

class RookTacticAnalyzerTest {

   @Test
   void dtoTest() {
       ChessField chessFieldA8 = new ChessField(Position.C8, null);
       ChessField chessFieldA1 = new ChessField(Position.A1, null);
       List<ChessField> testList = new ArrayList<>();

       testList.add(chessFieldA8);
       testList.add(chessFieldA1);

       RookTacticAnalyzer testAnalyzer = new RookTacticAnalyzer(testList, Alliance.WHITE);

       RookTacticDto testChessTacticDto = (RookTacticDto) testAnalyzer.getChessTacticDto();

       System.out.println(testChessTacticDto.getExecutionPoints());
       System.out.println(testChessTacticDto.getFieldsInvolved());
   }
}