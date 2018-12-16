package logic.pieces;

import logic.Alliance;
import logic.patterns.ChessPattern;
import logic.Position;

public class Piece {

    String name;
    Position position;
    Alliance alliance;
    Alliance tacticalOverlayAlliance;
    ChessPattern movePattern;
    ChessPattern tacticalOverlayPattern;


    public Piece(){}

    public Piece(String name, Position position, ChessPattern movePattern) {	this.name = name;
        setAllianceFromName(name);
        this.position = position;
        this.movePattern = movePattern;
        this.tacticalOverlayPattern = movePattern;
        this.tacticalOverlayAlliance = this.getAlliance();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Alliance getAlliance() {
        return alliance;
    }

    public void setAllianceFromName(String pieceName) {
        String parsedName[] = pieceName.split(" ");
        if (parsedName[0].equals("white")) {
            this.alliance = Alliance.WHITE;
        } else if
                (parsedName[0].equals("black")){
            this.alliance = Alliance.BLACK;
        } else{
            throw new IllegalArgumentException("Alliance must be either black or white ;) ");
        }

        this.alliance = alliance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[][]getPotentialMoves(){
       return movePattern.getChessPattern(this.position,this.alliance);
    }

    public void setTacticalOverlayAlliance(Alliance alliance){
        this.tacticalOverlayAlliance = alliance;
    }

    public int[][] getTacticalOverlayPattern(){
        return tacticalOverlayPattern.getChessPattern(this.position,this.tacticalOverlayAlliance);
    }

   public void setTacticalOverlayPatternType(ChessPattern tacticalPattern){
        this.tacticalOverlayPattern = tacticalPattern;
   }
}
