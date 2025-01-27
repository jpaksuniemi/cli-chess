package pksn.janne.model;

public abstract class ChessPiece {

    protected int currRow;
    protected char currColumn;
    protected final Color color;
    protected final MovementType movementType;

    public enum Color {
        WHITE, BLACK
    }

    public ChessPiece(int currRow, char currColumn, Color color, MovementType movementType) {
        this.currRow = currRow;
        this.currColumn = currColumn;
        this.color = color;
        this.movementType = movementType;
    }

    public Color getColor() {
        return color;
    }

    public int getCurrRow() {
        return currRow;
    }

    public void setCurrRow(int currRow) {
        this.currRow = currRow;
    }

    public char getCurrColumn() {
        return currColumn;
    }

    public void setCurrColumn(char currColumn) {
        this.currColumn = currColumn;
    }
    
    public abstract boolean isValidMove(int row, char column);

    public MovementType getMovementType() {
        return movementType;
    }
}
