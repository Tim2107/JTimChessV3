package gameLogic.analyzationTools;

import gameLogic.analyzationTools.tacticAnalyzers.*;
import gameLogic.analyzationTools.tacticDTOs.*;
import gameLogic.pieces.Piece;
import utils.Alliance;
import utils.Board;
import utils.ChessField;
import utils.Position;

import java.util.ArrayList;
import java.util.List;

public class TacticDtoBuilderBlueprint {

    List<Piece> activePieces;
    List<Position> positionsToAnalyze;
    List<ChessField> fieldsToAnalyze = new ArrayList<>();
    List<List<ChessField>> combinationsToAnalyzeList =new ArrayList();
    List<KingTacticDto> kingTacticDtos = new ArrayList<>();
    List<QueenTacticDto> queenTacticDtos = new ArrayList<>();
    List<RookTacticDto> rookTacticDtos = new ArrayList<>();
    List<KnightTacticDto> knightTacticDtos = new ArrayList<>();
    List<BishopTacticDto> bishopTacticDtos = new ArrayList<>();
    List<PawnTacticDto> pawnTacticDtos = new ArrayList<>();

    public List<ChessField> getFieldsToAnalyzeFromPiecesOnBoard(Board board){
        List<Piece> activePieces = board.getActivePiecesFromFields();
        activePieces.forEach(piece -> {
            fieldsToAnalyze.add(board.getChessfield(piece.getPosition()));
        });
        return fieldsToAnalyze;
    }

    public List<List<ChessField>> goThroughListAndMakeSmallCombinationLists(List<ChessField> fieldsToAnalyze){
        for(int firstIndexInList = 0; firstIndexInList < fieldsToAnalyze.size()-1;firstIndexInList++){
            for(int secondIndexInList = firstIndexInList + 1; secondIndexInList < fieldsToAnalyze.size();secondIndexInList++){
                List<ChessField> combiList = new ArrayList<>();
                combiList.add(fieldsToAnalyze.get(firstIndexInList));
                combiList.add(fieldsToAnalyze.get(secondIndexInList));
                combinationsToAnalyzeList.add(combiList);
            }
        }
        return combinationsToAnalyzeList;
    }

    public void createAndStoreTacticDtos(List<List<ChessField>> fieldPairList, String typeswithch, Alliance alliance){

        fieldPairList.forEach(pair -> {
            TacticAnalyzerFactory analyzerFactory = new TacticAnalyzerFactory();
            TacticAnalyzer tacticAnalyzer = analyzerFactory.instantiateTacticAnalyzer(pair, alliance, typeswithch);
            if(!tacticAnalyzer.getChessTacticDto().getExecutionPoints().isEmpty()){

                ChessTacticDto tacticDto = tacticAnalyzer.getChessTacticDto();


                if (typeswithch.equalsIgnoreCase("king")){
                    kingTacticDtos.add((KingTacticDto)tacticDto);
                }

                else if (typeswithch.equalsIgnoreCase("queen")){
                    queenTacticDtos.add((QueenTacticDto)tacticDto);
                }

                else if (typeswithch.equalsIgnoreCase("rook")){
                    rookTacticDtos.add((RookTacticDto)tacticDto);
                }

                else if (typeswithch.equalsIgnoreCase("knight")){
                    knightTacticDtos.add((KnightTacticDto)tacticDto);
                }

                else if (typeswithch.equalsIgnoreCase("bishop")){
                    bishopTacticDtos.add((BishopTacticDto)tacticDto);
                }

                else if (typeswithch.equalsIgnoreCase("pawn")){
                    pawnTacticDtos.add((PawnTacticDto)tacticDto);
                }
            }
        });
    }

    public List<ChessField> getFieldsToAnalyze() {
        return fieldsToAnalyze;
    }

    public List<List<ChessField>> getCombinationsToAnalyzeList() {
        return combinationsToAnalyzeList;
    }

    public List<KnightTacticDto> getKnightTacticDtos() {
        return knightTacticDtos;
    }

    public List<KingTacticDto> getKingTacticDtos() {
        return kingTacticDtos;
    }

    public List<QueenTacticDto> getQueenTacticDtos() {
        return queenTacticDtos;
    }

    public List<RookTacticDto> getRookTacticDtos() {
        return rookTacticDtos;
    }

    public List<BishopTacticDto> getBishopTacticDtos() {
        return bishopTacticDtos;
    }

    public List<PawnTacticDto> getPawnTacticDtos() {
        return pawnTacticDtos;
    }
}
