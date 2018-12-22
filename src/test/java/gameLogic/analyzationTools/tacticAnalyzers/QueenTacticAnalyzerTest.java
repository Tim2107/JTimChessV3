package gameLogic.analyzationTools.tacticAnalyzers;

import gameLogic.analyzationTools.tacticDTOs.QueenTacticDto;
import org.junit.jupiter.api.Test;
import utils.Alliance;
import utils.ChessField;
import utils.Position;

import java.util.ArrayList;
import java.util.List;

class QueenTacticAnalyzerTest {

    @Test
    void dtoTest() {
        ChessField chessFieldA8 = new ChessField(Position.C8, null);
        ChessField chessFieldA1 = new ChessField(Position.A1, null);
        List<ChessField> testList = new ArrayList<>();

        testList.add(chessFieldA8);
        testList.add(chessFieldA1);

        QueenTacticAnalyzer testAnalyzer = new QueenTacticAnalyzer(testList, Alliance.WHITE);

        QueenTacticDto testChessTacticDto = (QueenTacticDto) testAnalyzer.getChessTacticDto();

        System.out.println(testChessTacticDto.getExecutionPoints());
        System.out.println(testChessTacticDto.getFieldsInvolved());
    }

}