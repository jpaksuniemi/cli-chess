package pksn.janne.model;

public class LTypeMovement implements MovementType {

    private final int[] rowMoves = {-2, -2, -1, -1, 1, 1, 2, 2};
    private final int[] colMoves = {-1, 1, -2, 2, -2, 2, -1, 1};

    @Override
    public boolean isValidMove(int startRow, char startColumn, int endRow, char endColumn) {
        for (int i = 0; i < rowMoves.length; i++) {
            int newRow = startRow + rowMoves[i];
            int newCol = startColumn + colMoves[i];

            if (newRow == endRow && newCol == endColumn) {
                return true;
            }
        }
        return false;
    }
}
