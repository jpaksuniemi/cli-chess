package pksn.janne.model;

import pksn.janne.model.ChessBoard.Column;

public abstract class ChessPiece {

    private int currRow;
    private Column currColumn;

    public ChessPiece(int currRow, Column currColumn) {
        this.currRow = currRow;
        this.currColumn = currColumn;
    }

    public int getCurrRow() {
        return currRow;
    }

    public void setCurrRow(int currRow) {
        this.currRow = currRow;
    }

    public Column getCurrColumn() {
        return currColumn;
    }

    public void setCurrColumn(Column currColumn) {
        this.currColumn = currColumn;
    }
    
    public abstract boolean isValidMove(int row, Column column);
}
