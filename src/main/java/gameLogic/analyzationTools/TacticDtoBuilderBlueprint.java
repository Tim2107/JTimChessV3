package gameLogic.analyzationTools;

import gameLogic.pieces.Piece;
import utils.Board;
import utils.ChessField;
import utils.Position;

import java.util.ArrayList;
import java.util.List;

public class TacticDtoBuilderBlueprint {

    Board board;
    List<Piece> activePieces;
    List<Position> positionsToAnalyze;
    List<ChessField> fieldsToAnalyze;
    List<List<ChessField>> combinationsToAnalyzeList =new ArrayList();


    public void goThroughListAndMakeSmallCombinationLists(List<ChessField> fieldsToAnalyze){
        for(int firstIndexInList = 0; firstIndexInList < fieldsToAnalyze.size()-1;firstIndexInList++){
            for(int secondIndexInList = firstIndexInList + 1; secondIndexInList < fieldsToAnalyze.size();secondIndexInList++){
                List<ChessField> combiList = new ArrayList<>();
                combiList.add(fieldsToAnalyze.get(firstIndexInList));
                combiList.add(fieldsToAnalyze.get(secondIndexInList));
                combinationsToAnalyzeList.add(combiList);
            }
        }
    }
}
