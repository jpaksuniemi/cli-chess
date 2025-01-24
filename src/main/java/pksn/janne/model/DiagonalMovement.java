package pksn.janne.model;

public class DiagonalMovement implements MovementType {

    @Override
    public boolean isValidMove(int startRow, char startColumn, int endRow, char endColumn) {
        return Math.abs(startRow - endRow) == Math.abs(startColumn - endColumn);
    }
}
