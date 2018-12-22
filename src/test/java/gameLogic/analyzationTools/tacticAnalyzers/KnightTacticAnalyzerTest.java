package gameLogic.analyzationTools.tacticAnalyzers;

import gameLogic.analyzationTools.tacticDTOs.KnightTacticDto;
import org.junit.jupiter.api.Test;
import utils.Alliance;
import utils.ChessField;
import utils.Position;

import java.util.ArrayList;
import java.util.List;

class KnightTacticAnalyzerTest {

    @Test
    void dtoTest(){

        ChessField chessFieldA8 = new ChessField(Position.A8,null);
        ChessField chessFieldD5 = new ChessField(Position.D5,null);
        List<ChessField> testList = new ArrayList<>();

        testList.add(chessFieldA8);
        testList.add(chessFieldD5);

        KnightTacticAnalyzer testAnalyzer = new KnightTacticAnalyzer(testList, Alliance.WHITE);

        KnightTacticDto testChessTacticDto = (KnightTacticDto)testAnalyzer.getChessTacticDto();

        System.out.println(testChessTacticDto.getExecutionPoints());
        System.out.println(testChessTacticDto.getFieldsInvolved());
    }

}