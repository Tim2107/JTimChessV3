package gameLogic.patterns;

import utils.Alliance;
import utils.Position;

public interface ChessPattern {

   void setChessPatternForPosition(Position position, Alliance alliance);
   int [][] getChessPattern(Position position, Alliance alliance);
}
