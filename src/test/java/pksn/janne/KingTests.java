package pksn.janne;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pksn.janne.factories.ChessPieceFactory;
import pksn.janne.model.ChessPiece;
import pksn.janne.model.King;
import pksn.janne.util.ConstantValues;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KingTests {
    @Test
    @DisplayName("Testing king move validity")
    void testKingMoveValidity() {
        King king = (King) ChessPieceFactory.createKing(ChessPiece.Color.WHITE, 4, 'D');
        for (int row = 1; row <= ConstantValues.DEFAULT_BOARD_SIZE; row++) {
            for (char col = 'A'; col <= ConstantValues.UPPERCASE_H_ASCII_VALUE; col++) {
                int moveDistance = Math.max(Math.abs(row - king.getCurrRow()), Math.abs(col - king.getCurrColumn()));
                if (moveDistance == 1 && (row == king.getCurrRow() || col == king.getCurrColumn() || Math.abs(row - king.getCurrRow()) == Math.abs(col - king.getCurrColumn()))) {
                    assertTrue(king.isValidMove(row, col), "King should be able to move 1 tile in any direction orthogonally or diagonally");
                } else {
                    assertFalse(king.isValidMove(row, col), "King should not be able to move more than 1 tile in any direction");
                }
            }
        }
    }
}
