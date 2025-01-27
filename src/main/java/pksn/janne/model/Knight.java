package pksn.janne.model;

public class Knight extends ChessPiece{

    public Knight(int row, char col, Color color) {
        super(row, col, color, new LTypeMovement());
    }

    @Override
    public boolean isValidMove(int row, char column) {
        return movementType.isValidMove(currRow, currColumn, row, column);
    }

    @Override
    public String toString() {
        return "K";
    }
}
