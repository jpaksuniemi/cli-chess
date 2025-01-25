package pksn.janne;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import pksn.janne.factories.ChessPieceFactory;
import pksn.janne.model.ChessPiece;
import pksn.janne.model.Pawn;
import pksn.janne.util.ConstantValues;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PawnTests {

    @DisplayName("Testing pawn move validation")
    @RepeatedTest(2)
    void testPawnMoveValidation(RepetitionInfo repetitionInfo) {
        Pawn pawn = (Pawn) ChessPieceFactory.createPawn(ChessPiece.Color.WHITE, 2, 'D');
        int maxRowDifference = 2;

        if (repetitionInfo.getCurrentRepetition() == 2) {
            pawn.setHasMoved(true);
            System.out.println("Pawn has moved");
            maxRowDifference = 1;
        }

        System.out.println("White pawn tests");
        for (int row = 1; row <= ConstantValues.DEFAULT_BOARD_SIZE; row++) {
            for (char col = 'A'; col <= ConstantValues.UPPERCASE_H_ASCII_VALUE; col++) {
                int moveDistance = row - pawn.getCurrRow();
                if (moveDistance > 0 && moveDistance <= maxRowDifference && pawn.getCurrColumn() == col) {
                    String message = (maxRowDifference == 2)
                            ? "White pawn should be able to move max 2 tiles before having moved at all"
                            : "White pawn can move only 1 tile forward after moving once";
                    assertTrue(pawn.isValidMove(row, col), message);
                    continue;
                }
                assertFalse(pawn.isValidMove(row, col), "White pawn shouldn't be able to move anywhere else than up the board");
            }
        }

        pawn = (Pawn) ChessPieceFactory.createPawn(ChessPiece.Color.BLACK, 6, 'D');
        if (repetitionInfo.getCurrentRepetition() == 2) {
            pawn.setHasMoved(true);
        }

        System.out.println("Black pawn tests");
        for (int row = 1; row <= ConstantValues.DEFAULT_BOARD_SIZE; row++) {
            for (char col = 'A'; col <= ConstantValues.UPPERCASE_H_ASCII_VALUE; col++) {
                int moveDistance = pawn.getCurrRow() - row;
                if (moveDistance > 0 && moveDistance <= maxRowDifference && pawn.getCurrColumn() == col) {
                    String message = (maxRowDifference == 2)
                            ? "Black pawn should be able to move max 2 tiles before having moved at all"
                            : "Black pawn can move only 1 tile forward after moving once";
                    assertTrue(pawn.isValidMove(row, col), message);
                    continue;
                }
                assertFalse(pawn.isValidMove(row, col), "Black pawn shouldn't be able to move anywhere else than down the board");
            }
        }
    }
}
