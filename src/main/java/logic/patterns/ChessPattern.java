package logic.patterns;

import logic.Alliance;
import logic.Position;

public interface ChessPattern {

   void setChessPatternForPosition(Position position, Alliance alliance);
   int [][] getChessPattern(Position position, Alliance alliance);
}
