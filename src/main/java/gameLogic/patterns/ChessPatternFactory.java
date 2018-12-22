package gameLogic.patterns;

public class ChessPatternFactory {

        public ChessPattern instantiateChessPattern(String patternType){
            if (patternType==null){
                return null;
            }

            else if (patternType.equalsIgnoreCase("king")){
                return new KingPattern();
            }

            else if (patternType.equalsIgnoreCase("queen")){
                return new QueenPattern();
            }
            else if (patternType.equalsIgnoreCase("rook")){
                return new RookPattern();
            }
            else if (patternType.equalsIgnoreCase("knight")){
                return new KnightPattern();
            }
            else if (patternType.equalsIgnoreCase("bishop")){
                return new BishopPattern();
            }

            else if (patternType.equalsIgnoreCase("pawn")){
                return new PawnPattern();
            }

            return null;
        }
}
