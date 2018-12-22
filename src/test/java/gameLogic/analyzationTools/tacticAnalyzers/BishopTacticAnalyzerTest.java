package gameLogic.analyzationTools.tacticAnalyzers;

import gameLogic.analyzationTools.tacticDTOs.BishopTacticDto;
import org.junit.jupiter.api.Test;
import utils.Alliance;
import utils.ChessField;
import utils.Position;

import java.util.ArrayList;
import java.util.List;

class BishopTacticAnalyzerTest {

    @Test
    void dtoTest() {
        ChessField chessFieldA8 = new ChessField(Position.E3, null);
        ChessField chessFieldA1 = new ChessField(Position.F4, null);
        List<ChessField> testList = new ArrayList<>();

        testList.add(chessFieldA8);
        testList.add(chessFieldA1);

        BishopTacticAnalyzer testAnalyzer = new BishopTacticAnalyzer(testList, Alliance.WHITE);
        BishopTacticDto testChessTacticDto = (BishopTacticDto) testAnalyzer.getChessTacticDto();

        System.out.println(testChessTacticDto.getExecutionPoints());
        System.out.println(testChessTacticDto.getFieldsInvolved());
    }

}