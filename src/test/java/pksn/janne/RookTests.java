package pksn.janne;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pksn.janne.factories.ChessPieceFactory;
import pksn.janne.model.ChessPiece;
import pksn.janne.model.Rook;
import pksn.janne.util.ConstantValues;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RookTests {

    @Test
    @DisplayName("Testing rook move validation")
    void testRookMoveValidation() {
        Rook rook = (Rook) ChessPieceFactory.createRook(ChessPiece.Color.WHITE, 4, 'D');

        for (int row = 1; row <= ConstantValues.DEFAULT_BOARD_SIZE; row++) {
            for (char col = 'A'; col <= ConstantValues.UPPERCASE_H_ASCII_VALUE; col++) {
                if (rook.getCurrRow() == row || rook.getCurrColumn() == col) {
                    assertTrue(rook.isValidMove(row, col), "Rook should be able to move orthogonally");
                } else {
                    assertFalse(rook.isValidMove(row, col), "Rook should be able to only move orthogonally");
                }
            }
        }
    }
}
