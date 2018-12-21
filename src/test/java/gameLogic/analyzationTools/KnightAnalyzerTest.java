package gameLogic.analyzationTools;

import org.junit.jupiter.api.Test;
import utils.Alliance;
import utils.ChessField;
import utils.Position;

import java.util.ArrayList;
import java.util.List;

class KnightAnalyzerTest {

    @Test
    void analyseFindingsTest(){

        ChessField FieldA8 = new ChessField(Position.A8,null);
        ChessField FieldD5 = new ChessField(Position.E4,null);
        List<ChessField>testList =new ArrayList<>();

        testList.add(FieldA8);
        testList.add(FieldD5);

        KnightAnalyzer testAnalyzer = new KnightAnalyzer(testList, Alliance.WHITE);

        KnightTacticDto knightTacticDto = testAnalyzer.getKnightTacticDto();

       knightTacticDto.getFieldsInvolved().forEach(System.out::println);
    }

}