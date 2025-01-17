package pksn.janne;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pksn.janne.controller.InvalidMoveException;
import pksn.janne.controller.PieceController;
import pksn.janne.factories.ChessPieceFactory;
import pksn.janne.model.ChessBoard;
import pksn.janne.model.ChessPiece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PieceControllerTests {

    @Test
    @DisplayName("Testing moveChessPiece() validity")
    void testMoveValidity() throws Exception {
        ChessBoard board = new ChessBoard();
        PieceController.setBoard(board);
        ChessPiece rook1 = ChessPieceFactory.createRook(ChessPiece.Color.WHITE, 1, 'A');
        ChessPiece rook2 = ChessPieceFactory.createRook(ChessPiece.Color.WHITE, 1, 'H');
        ChessPiece rook3 = ChessPieceFactory.createRook(ChessPiece.Color.BLACK, 1, 'D');
        ChessPiece rook4 = ChessPieceFactory.createRook(ChessPiece.Color.BLACK, 3, 'A');
        ChessPiece rook5 = ChessPieceFactory.createRook(ChessPiece.Color.WHITE, 5, 'A');

        board.add(rook1, rook1.getCurrRow(), rook1.getCurrColumn());
        board.add(rook2, rook2.getCurrRow(), rook2.getCurrColumn());
        board.add(rook3, rook3.getCurrRow(), rook3.getCurrColumn());
        board.add(rook4, rook4.getCurrRow(), rook4.getCurrColumn());
        board.add(rook5, rook5.getCurrRow(), rook5.getCurrColumn());

        InvalidMoveException e = assertThrows(InvalidMoveException.class, () ->
                PieceController.moveChessPiece(rook1, 1, 'H'));

        assertEquals(InvalidMoveException.CHESS_PIECE_IN_THE_WAY, e.code, "Should throw error regarding chess piece in the way");

        PieceController.moveChessPiece(rook3, 2,'D');

        e = assertThrows(InvalidMoveException.class, () ->
                PieceController.moveChessPiece(rook1, 1, 'H'));

        assertEquals(InvalidMoveException.CHESS_PIECE_IS_SAME_COLOR, e.code, "Should throw error regarding taking chess piece of same color");

        e = assertThrows(InvalidMoveException.class, () ->
                PieceController.moveChessPiece(rook1, 5, 'A'));

        assertEquals(InvalidMoveException.CHESS_PIECE_IN_THE_WAY, e.code, "Should throw error regarding chess piece in the way");

        PieceController.moveChessPiece(rook4, 3, 'B');

        e = assertThrows(InvalidMoveException.class, () ->
                PieceController.moveChessPiece(rook1, 5, 'A'));

        assertEquals(InvalidMoveException.CHESS_PIECE_IS_SAME_COLOR, e.code, "Should throw error regarding chess piece in the way");
    }
}
