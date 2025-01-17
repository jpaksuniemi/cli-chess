package pksn.janne.model;

public abstract class ChessPiece {

    protected int currRow;
    protected Character currColumn;
    protected final Color color;
    protected final MovementType movementType;

    public enum Color {
        WHITE, BLACK
    }

    public ChessPiece(int currRow, Character currColumn, Color color, MovementType movementType) {
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

    public Character getCurrColumn() {
        return currColumn;
    }

    public void setCurrColumn(Character currColumn) {
        this.currColumn = currColumn;
    }
    
    public abstract boolean isValidMove(int row, Character column);

    public MovementType getMovementType() {
        return movementType;
    }
}
