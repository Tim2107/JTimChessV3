package utils;

import gameLogic.analyzationTools.tacticDTOs.*;
import gameLogic.patterns.ChessPattern;
import gameLogic.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class ChessField {

    Position position;
    Piece isOccupiedBy = null;

    private List<KingTacticDto> kingTacticDtos = new ArrayList<>();
    private List<QueenTacticDto> queenTacticDtos = new ArrayList<>();
    private List<RookTacticDto> rookTacticDtos = new ArrayList<>();
    private List<KnightTacticDto> knightTacticDtos = new ArrayList<>();
    private List<BishopTacticDto> bishopTacticDtos = new ArrayList<>();
    private List<PawnTacticDto> pawnTacticDtos = new ArrayList<>();

    private int executionEvaluationLevel;
    private int involvementEvaluationLevel;

    List<Piece> isAttackedBy;
    List<Piece> isDefendedBy;

    int isAttackedCounter;
    int isDefendedCounter;

    Piece isRailroadForPiece;
    ChessPattern railroad;

    Piece isPinnedByPiece;
    ChessPattern pin;

    private Alliance tacticalOverlayAlliance;
    private ChessPattern tacticalOverlayPattern;


    public ChessField(Position position, Piece piece){
        this.position = position;
        this.isOccupiedBy = piece;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Piece getIsOccupiedBy() {
        return isOccupiedBy;
    }

    public void setIsOccupiedBy(Piece isOccupiedBy) {
        this.isOccupiedBy = isOccupiedBy;
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

    public List<KingTacticDto> getKingTacticDtos() {
        return kingTacticDtos;
    }

    public void setKingTacticDtos(KingTacticDto kingTacticDto) {
        this.kingTacticDtos.add(kingTacticDto);
    }

    public List<QueenTacticDto> getQueenTacticDtos() {
        return queenTacticDtos;
    }

    public void setQueenTacticDtos(QueenTacticDto queenTacticDto) {
        this.queenTacticDtos.add(queenTacticDto);
    }

    public List<RookTacticDto> getRookTacticDtos() {
        return rookTacticDtos;
    }

    public void setRookTacticDtos(RookTacticDto rookTacticDto) {
        this.rookTacticDtos.add(rookTacticDto);
    }

    public List<KnightTacticDto> getKnightTacticDtos() {
        return knightTacticDtos;
    }

    public void setKnightTacticDtos(KnightTacticDto knightTacticDto) {
        this.knightTacticDtos.add(knightTacticDto);
    }

    public List<BishopTacticDto> getBishopTacticDtos() {
        return bishopTacticDtos;
    }

    public void setBishopTacticDtos(BishopTacticDto bishopTacticDto) {
        this.bishopTacticDtos.add(bishopTacticDto);
    }

    public List<PawnTacticDto> getPawnTacticDtos() {
        return pawnTacticDtos;
    }

    public void setPawnTacticDtos(PawnTacticDto pawnTacticDto) {
        this.pawnTacticDtos.add(pawnTacticDto);
    }

    public int getExecutionEvaluationLevel() {
        return executionEvaluationLevel;
    }

    public void setExecutionEvaluationLevel(int executionEvaluationLevel) {
        this.executionEvaluationLevel = executionEvaluationLevel;
    }

    public int getInvolvementEvaluationLevel() {
        return involvementEvaluationLevel;
    }

    public void setInvolvementEvaluationLevel(int involvementEvaluationLevel) {
        this.involvementEvaluationLevel = involvementEvaluationLevel;
    }
}
