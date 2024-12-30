package pksn.janne.model;

public abstract class ChessPiece {

    private int currRow;
    private Character currColumn;
    private final Color color;

    public enum Color {
        WHITE, BLACK
    }

    public ChessPiece(int currRow, Character currColumn, Color color) {
        this.currRow = currRow;
        this.currColumn = currColumn;
        this.color = color;
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
}
