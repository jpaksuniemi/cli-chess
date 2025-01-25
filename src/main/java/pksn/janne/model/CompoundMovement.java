package pksn.janne.model;

public class CompoundMovement implements MovementType {

    private final MovementType movementType1;
    private final MovementType movementType2;

    public CompoundMovement(MovementType movementType1, MovementType movementType2) {
        this.movementType1 = movementType1;
        this.movementType2 = movementType2;
    }

    @Override
    public boolean isValidMove(int startRow, char startColumn, int endRow, char endColumn) {
        return movementType1.isValidMove(startRow, startColumn, endRow, endColumn)
                || movementType2.isValidMove(startRow, startColumn, endRow, endColumn);
    }
}
