package gameLogic.analyzationTools.tacticDTOs;

public class TacticDtoFactory {


    public ChessTacticDto instantiateTacticDto(String tacticType){
        if (tacticType==null){
            return null;
        }

        else if (tacticType.equalsIgnoreCase("king")){
            return new KingTacticDto();
        }

        else if (tacticType.equalsIgnoreCase("queen")){
            return new QueenTacticDto();
        }
        else if (tacticType.equalsIgnoreCase("rook")){
            return new RookTacticDto();
        }
        else if (tacticType.equalsIgnoreCase("knight")){
            return new KnightTacticDto();
        }
        else if (tacticType.equalsIgnoreCase("bishop")){
            return new BishopTacticDto();
        }

        else if (tacticType.equalsIgnoreCase("pawn")){
            return new PawnTacticDto();
        }

        return null;
    }

}
