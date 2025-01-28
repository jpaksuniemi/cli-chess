package pksn.janne.model;

public class PawnMovement implements MovementType {

    @Override
    public boolean isValidMove(int startRow, char startColumn, int endRow, char endColumn) {
        return (startRow != endRow && startColumn == endColumn) || Math.abs(startRow - endRow) == Math.abs(startColumn - endColumn);
    }
}
