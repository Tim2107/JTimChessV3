package gameLogic.analyzationTools;

import org.junit.jupiter.api.Test;
import utils.ChessField;
import utils.Position;

import java.util.ArrayList;
import java.util.List;

class TacticDtoBuilderBlueprintTest {



    @Test
    void fieldCombinationTest(){

        ChessField fieldA1 = new ChessField(Position.A1,null);
        ChessField fieldB2 = new ChessField(Position.B2,null);
        ChessField fieldC3 = new ChessField(Position.C3,null);
        ChessField fieldD4 = new ChessField(Position.D4,null);
        ChessField fieldE5 = new ChessField(Position.E5,null);


        List<ChessField> testList = new ArrayList<>();

        testList.add(fieldA1);
        testList.add(fieldB2);
        testList.add(fieldC3);
        testList.add(fieldD4);
        testList.add(fieldE5);

        TacticDtoBuilderBlueprint testBuilder = new TacticDtoBuilderBlueprint();

        testBuilder.goThroughListAndMakeSmallCombinationLists(testList);
        System.out.println(testBuilder.combinationsToAnalyzeList.get(2).get(0).getPosition());

        System.out.println(testBuilder.combinationsToAnalyzeList.get(2).get(1).getPosition());
    }

}