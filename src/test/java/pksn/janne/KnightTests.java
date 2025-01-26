package pksn.janne;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pksn.janne.factories.ChessPieceFactory;
import pksn.janne.model.ChessPiece;
import pksn.janne.model.Knight;
import pksn.janne.util.ConstantValues;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTests {

    private static final int[] rowMoves = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static final int[] colMoves = {-1, 1, -2, 2, -2, 2, -1, 1};

    @Test
    @DisplayName("Testing knight move validation")
    void testKnightMoveValidation() {
        Knight knight = (Knight) ChessPieceFactory.createKnight(ChessPiece.Color.WHITE, 4, 'D');
        int[] possibleRowTiles = Arrays.stream(rowMoves).map(row -> row + knight.getCurrRow()).toArray();
        int[] possibleColTiles = Arrays.stream(colMoves).map(col -> col + knight.getCurrColumn()).toArray();
        boolean isValid = false;

        // there must be a better way...
        for (int row = 1; row <= ConstantValues.DEFAULT_BOARD_SIZE; row++) {
            for (char col = 'A'; col <= ConstantValues.UPPERCASE_H_ASCII_VALUE; col++) {
                isValid = false;
                for (int index = 0; index < possibleRowTiles.length; index++) {
                    if (possibleRowTiles[index] == row && possibleColTiles[index] == col) {
                        assertTrue(knight.isValidMove(row, col), "Knight should be able to move in an L-shape");
                        isValid = true;
                        break;
                    }
                }
                if (!isValid) {
                    assertFalse(knight.isValidMove(row, col), "Knight should be able to only move in an L-shape");
                }

            }
        }
    }
}
