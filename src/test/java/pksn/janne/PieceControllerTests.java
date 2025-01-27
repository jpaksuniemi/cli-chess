package pksn.janne;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pksn.janne.controller.InvalidMoveException;
import pksn.janne.controller.PieceController;
import pksn.janne.factories.ChessPieceFactory;
import pksn.janne.model.ChessBoard;
import pksn.janne.model.ChessPiece;

import static org.junit.jupiter.api.Assertions.*;

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

        // Horizontal clear check
        InvalidMoveException e = assertThrows(InvalidMoveException.class, () ->
                PieceController.moveChessPiece(rook1, 1, 'H'));

        assertEquals(InvalidMoveException.CHESS_PIECE_IN_THE_WAY, e.code, "Should throw error regarding chess piece in the way");

        PieceController.moveChessPiece(rook3, 2,'D');

        e = assertThrows(InvalidMoveException.class, () ->
                PieceController.moveChessPiece(rook1, 1, 'H'));

        assertEquals(InvalidMoveException.CHESS_PIECE_IS_SAME_COLOR, e.code, "Should throw error regarding capturing chess piece of same color");

        e = assertThrows(InvalidMoveException.class, () ->
                PieceController.moveChessPiece(rook1, 5, 'A'));

        assertEquals(InvalidMoveException.CHESS_PIECE_IN_THE_WAY, e.code, "Should throw error regarding chess piece in the way");

        PieceController.moveChessPiece(rook4, 3, 'B');

        e = assertThrows(InvalidMoveException.class, () ->
                PieceController.moveChessPiece(rook1, 5, 'A'));

        assertEquals(InvalidMoveException.CHESS_PIECE_IS_SAME_COLOR, e.code, "Should throw error regarding capturing chess piece of the same color");

        e = assertThrows(InvalidMoveException.class, () ->
                PieceController.moveChessPiece(rook1, 5, 'I'));

        assertEquals(InvalidMoveException.OUT_OF_BOUNDS, e.code, "Should throw error regarding moving piece out of bounds");
    }

    @Test
    @DisplayName("Testing horizontal capturing")
    void testHorizontalCapturing() throws Exception {
        ChessBoard board = new ChessBoard();
        PieceController.setBoard(board);
        ChessPiece rook1 = ChessPieceFactory.createRook(ChessPiece.Color.WHITE, 1, 'C');
        board.add(rook1, rook1.getCurrRow(), rook1.getCurrColumn());
        ChessPiece rook2 = ChessPieceFactory.createRook(ChessPiece.Color.BLACK, 1, 'G');
        board.add(rook2, rook2.getCurrRow(), rook2.getCurrColumn());
        ChessPiece rook3 = ChessPieceFactory.createRook(ChessPiece.Color.BLACK, 1, 'A');

        assertTrue(PieceController.moveChessPiece(rook1, rook2.getCurrRow(), rook2.getCurrColumn()));
        assertTrue(PieceController.moveChessPiece(rook1, rook3.getCurrRow(), rook3.getCurrColumn()));
    }

    @Test
    @DisplayName("Testing vertical capturing")
    void testVerticalCapturing() throws Exception {
        ChessBoard board = new ChessBoard();
        PieceController.setBoard(board);

        ChessPiece rook1 = ChessPieceFactory.createRook(ChessPiece.Color.WHITE, 4, 'A');
        board.add(rook1, rook1.getCurrRow(), rook1.getCurrColumn());
        ChessPiece rook2 = ChessPieceFactory.createRook(ChessPiece.Color.BLACK, 7, 'A');
        board.add(rook2, rook2.getCurrRow(), rook2.getCurrColumn());
        ChessPiece rook3 = ChessPieceFactory.createRook(ChessPiece.Color.BLACK, 1, 'A');

        assertTrue(PieceController.moveChessPiece(rook1, rook2.getCurrRow(), rook2.getCurrColumn()));
        assertTrue(PieceController.moveChessPiece(rook1, rook3.getCurrRow(), rook3.getCurrColumn()));
    }

    @Test
    @DisplayName("Testing diagonal capturing")
    void testDiagonalCapturing() throws Exception {
        ChessBoard board = new ChessBoard();
        PieceController.setBoard(board);

        ChessPiece queen = ChessPieceFactory.createQueen(ChessPiece.Color.WHITE, 4, 'D');
        ChessPiece queen2 = ChessPieceFactory.createQueen(ChessPiece.Color.BLACK, 2, 'B');
        ChessPiece queen3 = ChessPieceFactory.createQueen(ChessPiece.Color.BLACK, 6, 'F');
        ChessPiece queen4 = ChessPieceFactory.createQueen(ChessPiece.Color.BLACK, 7, 'E');
        ChessPiece queen5 = ChessPieceFactory.createQueen(ChessPiece.Color.BLACK, 5, 'G');

        board.add(queen, queen.getCurrRow(), queen.getCurrColumn());
        board.add(queen2, queen2.getCurrRow(), queen2.getCurrColumn());
        board.add(queen3, queen3.getCurrRow(), queen3.getCurrColumn());
        board.add(queen4, queen4.getCurrRow(), queen4.getCurrColumn());
        board.add(queen5, queen5.getCurrRow(), queen5.getCurrColumn());

        assertTrue(PieceController.moveChessPiece(queen, queen2.getCurrRow(), queen2.getCurrColumn()));
        assertTrue(PieceController.moveChessPiece(queen, queen3.getCurrRow(), queen3.getCurrColumn()));
        assertTrue(PieceController.moveChessPiece(queen, queen4.getCurrRow(), queen4.getCurrColumn()));
        assertTrue(PieceController.moveChessPiece(queen, queen5.getCurrRow(), queen5.getCurrColumn()));
    }

    @Test
    @DisplayName("Testing L-Movement capturing")
    void testLMovementCapturing() throws Exception {
        ChessBoard board = new ChessBoard();
        PieceController.setBoard(board);

        ChessPiece knight = ChessPieceFactory.createKnight(ChessPiece.Color.WHITE, 4, 'D');
        ChessPiece knight2 = ChessPieceFactory.createKnight(ChessPiece.Color.BLACK, 2, 'C');
        ChessPiece knight3 = ChessPieceFactory.createKnight(ChessPiece.Color.BLACK, 3, 'E');

        board.add(knight, knight.getCurrRow(), knight.getCurrColumn());
        board.add(knight2, knight2.getCurrRow(), knight2.getCurrColumn());
        board.add(knight3, knight3.getCurrRow(), knight3.getCurrColumn());

        assertTrue(PieceController.moveChessPiece(knight, knight2.getCurrRow(), knight2.getCurrColumn()));
        assertTrue(PieceController.moveChessPiece(knight, knight3.getCurrRow(), knight3.getCurrColumn()));
    }

    @Test
    @DisplayName("Testing knight moving over other pieces")
    void testKnightMovingOverOtherPieces() {
        ChessBoard board = new ChessBoard();
        PieceController.setBoard(board);
        ChessPiece knight = ChessPieceFactory.createKnight(ChessPiece.Color.WHITE, 1, 'A');
        ChessPiece obstacle = ChessPieceFactory.createPawn(ChessPiece.Color.BLACK, 1, 'B');
        board.add(knight, knight.getCurrRow(), knight.getCurrColumn());
        board.add(obstacle, obstacle.getCurrRow(), obstacle.getCurrColumn());

        assertDoesNotThrow(() -> PieceController.moveChessPiece(knight, 2, 'C'), "Knight should be able to move over other troops");
    }
}
