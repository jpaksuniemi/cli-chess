package pksn.janne.model;

public interface MovementType {
    boolean isValidMove(int startRow, char startColumn, int endRow, char endColumn);
}
