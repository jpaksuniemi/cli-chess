package pksn.janne;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pksn.janne.factories.ChessPieceFactory;
import pksn.janne.model.ChessPiece;
import pksn.janne.model.Queen;
import pksn.janne.util.ConstantValues;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueenTests {

    @Test
    @DisplayName("Testing queen move validation")
    void testQueenMoveValidation() {
        Queen q = (Queen) ChessPieceFactory.createQueen(ChessPiece.Color.WHITE, 4, 'D');
        for (int row = 1; row < ConstantValues.DEFAULT_BOARD_SIZE; row++) {
            for (char col = 'A'; col < ConstantValues.UPPERCASE_H_ASCII_VALUE; col++) {
                if (q.getCurrColumn() == col || q.getCurrRow() == row || Math.abs(q.getCurrColumn() - col) == Math.abs(q.getCurrRow() - row)) {
                    assertTrue(q.isValidMove(row, col), "Queen should be able to move orthogonally or diagonally");
                } else {
                    assertFalse(q.isValidMove(row, col), "Queen should only be able to move orthogonally or diagonally");
                }
            }
        }
    }
}
