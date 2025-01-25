package pksn.janne.model;

public class King extends ChessPiece {

    public King(int row, char col, Color color) {
        super(row, col, color, new CompoundMovement(
                new OrthogonalMovement(), new DiagonalMovement()));
    }

    @Override
    public boolean isValidMove(int row, Character column) {
        if (!movementType.isValidMove(currRow, currColumn, row, column)) {
            return false;
        }
        return Math.abs(row - currRow) == 1 || Math.abs(column - currColumn) == 1;
    }
}
