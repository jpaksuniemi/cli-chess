package pksn.janne.model;

import pksn.janne.util.BoardHelper;

public class Rook extends ChessPiece {

    public Rook(int row, Character column, Color color) {
        super(row, column, color);
    }

    @Override
    public boolean isValidMove(int row, Character column) {
        if (!BoardHelper.isValidColumn(column) || !BoardHelper.isValidRow(row)) {
            return false; 
        }
        if ( (getCurrColumn() == column && getCurrRow() != row) || (getCurrColumn() != column && getCurrRow() == row) ) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Rook";
    }
}
