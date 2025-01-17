package pksn.janne.model;

public class ForwardMovement implements MovementType {

    @Override
    public boolean isValidMove(int startRow, char startColumn, int endRow, char endColumn) {
        return (startRow != endRow && startColumn == endColumn);
    }
}
