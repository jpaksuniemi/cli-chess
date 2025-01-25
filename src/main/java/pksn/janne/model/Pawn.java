package pksn.janne.model;

public class Pawn extends ChessPiece {

    private boolean hasMoved = false;
    // TODO: en passant

    public Pawn(int row, Character column, Color color) {
        super(row, column, color, new ForwardMovement());
    }

    @Override
    public boolean isValidMove(int row, Character column) {
        if (!movementType.isValidMove(currRow, currColumn, row, column)) {
            return false;
        }
        int moveDistance = Math.abs(row - currRow);
        int moveDirection = row - currRow;
        if (moveDistance > 2 || moveDistance == 2 && hasMoved) {
            return false;
        }
        return color == Color.BLACK && moveDirection < 0 || color == Color.WHITE && moveDirection > 0;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    @Override
    public String toString() {
        return "P";
    }
}
