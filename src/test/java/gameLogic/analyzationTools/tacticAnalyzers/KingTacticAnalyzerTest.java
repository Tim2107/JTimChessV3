package gameLogic.analyzationTools.tacticAnalyzers;

import gameLogic.analyzationTools.tacticDTOs.KingTacticDto;
import org.junit.jupiter.api.Test;
import utils.Alliance;
import utils.ChessField;
import utils.Position;

import java.util.ArrayList;
import java.util.List;

class KingTacticAnalyzerTest {

    @Test
    void dtoTest() {
        ChessField chessFieldA8 = new ChessField(Position.D4, null);
        ChessField chessFieldA1 = new ChessField(Position.F4, null);
        List<ChessField> testList = new ArrayList<>();

        testList.add(chessFieldA8);
        testList.add(chessFieldA1);

        KingTacticAnalyzer testAnalyzer = new KingTacticAnalyzer(testList, Alliance.WHITE);
        KingTacticDto testChessTacticDto = (KingTacticDto) testAnalyzer.getChessTacticDto();

        System.out.println(testChessTacticDto.getExecutionPoints());
        System.out.println(testChessTacticDto.getFieldsInvolved());
    }

}