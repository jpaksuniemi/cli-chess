package pksn.janne.model;

public class Queen extends ChessPiece {

    public Queen(int row, char col, Color color) {
        super(row, col, color, new CompoundMovement(
                        new OrthogonalMovement(), new DiagonalMovement()));
    }

    @Override
    public boolean isValidMove(int row, char column) {
        return movementType.isValidMove(currRow, currColumn, row, column);
    }

    @Override
    public String toString() {
        return "Q";
    }
}
