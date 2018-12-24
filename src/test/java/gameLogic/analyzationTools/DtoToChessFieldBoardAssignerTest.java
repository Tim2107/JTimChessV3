package gameLogic.analyzationTools;

import gameLogic.pieces.Bishop;
import gameLogic.pieces.Piece;
import gameLogic.pieces.Queen;
import gameLogic.pieces.Rook;
import org.junit.jupiter.api.Test;
import utils.Board;
import utils.BoardCreator;
import utils.ChessField;
import utils.Position;

import java.util.ArrayList;
import java.util.List;

class DtoToChessFieldBoardAssignerTest {


    @Test
    void dtoTest() {
        List<Piece> piecesOnBoard = new ArrayList<>();

        Queen whiteQueen = new Queen("white queen", Position.C8);
        Queen whiteQueen2 = new Queen("white queen", Position.B6);
        Rook blackRook1 = new Rook("black rook", Position.F5);
        Bishop whiteBishop1 = new Bishop("white bishop", Position.D5);

        piecesOnBoard.add(whiteQueen);
        piecesOnBoard.add(whiteQueen2);
        piecesOnBoard.add(blackRook1);
        piecesOnBoard.add(whiteBishop1);

        Board board = new BoardCreator().createBoard(piecesOnBoard);

        DtoToChessFieldBoardAssigner testAssigner = new DtoToChessFieldBoardAssigner(board);
        testAssigner.generateTacticDtosForGivenBoard();
        testAssigner.takeDtosAndStoreThemInFields();

        Position[] values = Position.values();

        for (int i = 0; i < (values.length - 1); i++){
        testAssigner.getBoard().getChessfield(values[i]).getKingTacticDtos().forEach(
                kingTacticDto -> {
                    System.out.println(kingTacticDto.getExecutionPoints());
                    System.out.println(kingTacticDto.getFieldsInvolved());
                    System.out.println();
                }
        );

            for (int j = 0; j < (values.length - 1); j++){
                testAssigner.getBoard().getChessfield(values[j]).getRookTacticDtos().forEach(
                        rookTacticDto -> {
                            System.out.println(rookTacticDto.getExecutionPoints());
                            System.out.println(rookTacticDto.getFieldsInvolved());
                            System.out.println();
                        }
                );
            }

            for (int j = 0; j < (values.length - 1); j++){
                testAssigner.getBoard().getChessfield(values[j]).getQueenTacticDtos().forEach(
                        queenTacticDto -> {
                            System.out.println(queenTacticDto.getExecutionPoints());
                            System.out.println(queenTacticDto.getFieldsInvolved());
                            System.out.println();
                        }
                );
            }

            for (int j = 0; j < (values.length - 1); j++){
                testAssigner.getBoard().getChessfield(values[j]).getKnightTacticDtos().forEach(
                        knightTacticDto -> {
                            System.out.println(knightTacticDto.getExecutionPoints());
                            System.out.println(knightTacticDto.getFieldsInvolved());
                            System.out.println();
                        }
                );
            }

            for (int j = 0; j < (values.length - 1); j++){
                testAssigner.getBoard().getChessfield(values[j]).getBishopTacticDtos().forEach(
                        bishopTacticDto -> {
                            System.out.println(bishopTacticDto.getExecutionPoints());
                            System.out.println(bishopTacticDto.getFieldsInvolved());
                            System.out.println();
                        }
                );
            }

            for (int j = 0; j < (values.length - 1); j++){
                testAssigner.getBoard().getChessfield(values[j]).getPawnTacticDtos().forEach(
                        pawnTacticDto -> {
                            System.out.println(pawnTacticDto.getExecutionPoints());
                            System.out.println(pawnTacticDto.getFieldsInvolved());
                            System.out.println();
                        }
                );
            }


            for (int j = 0; j < (values.length - 1); j++){
                ChessField chessfield = testAssigner.getBoard().getChessfield(values[j]);

            System.out.println(chessfield.getExecutionEvaluationLevel());
            System.out.println(chessfield.getInvolvementEvaluationLevel());
            }



            }
        }
    }

