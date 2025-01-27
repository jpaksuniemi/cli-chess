package pksn.janne.model;

public class Rook extends ChessPiece {

    public Rook(int row, char column, Color color) {
        super(row, column, color, new OrthogonalMovement());
    }

    @Override
    public boolean isValidMove(int row, char column) {
        return movementType.isValidMove(currRow, currColumn, row, column);
    }

    @Override
    public String toString() {
        return "R";
    }
}
