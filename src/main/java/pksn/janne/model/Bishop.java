package pksn.janne.model;

public class Bishop extends ChessPiece {

    public Bishop(int row, Character column, Color color) {
        super(row, column, color, new DiagonalMovement());
    }

    @Override
    public boolean isValidMove(int row, Character column) {
        return movementType.isValidMove(currRow, currColumn, row, column);
    }

    @Override
    public String toString() {
        return "Bishop";
    }
}
