package pksn.janne;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pksn.janne.controller.PieceController;
import pksn.janne.factories.ChessPieceFactory;
import pksn.janne.model.ChessBoard;
import pksn.janne.model.ChessPiece;
import pksn.janne.util.ConstantValues;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BishopTests {

    @Test
    @DisplayName("Testing bishop move validation")
    void testBishopMoveValidation() {
        ChessPiece bishop = ChessPieceFactory.createBishop(ChessPiece.Color.WHITE, 5, 'D');

        for (int i = 1; i <= ConstantValues.DEFAULT_BOARD_SIZE; i++) {
            for (char c = 'A'; c <= ConstantValues.UPPERCASE_H_ASCII_VALUE; c++) {
                if (Math.abs(bishop.getCurrRow() - i) == Math.abs(bishop.getCurrColumn() - c)) {
                    assertTrue(bishop.isValidMove(i, c), "Diagonal movement should be valid");
                } else {
                    assertFalse(bishop.isValidMove(i, c), "Non-diagonal movement should be invalid");
                }
            }
        }

    }
}
