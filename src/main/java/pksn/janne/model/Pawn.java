package pksn.janne.model;

import pksn.janne.util.BoardHelper;

public class Pawn extends ChessPiece {

    private boolean hasMoved = false;

    public Pawn(int row, Character column, Color color) {
        super(row, column, color);
    }

    @Override
    public boolean isValidMove(int row, Character column) {
        if (!BoardHelper.isValidRow(row) || !BoardHelper.isValidColumn(column) || getCurrColumn() != column) {
            return false;
        }
        int distance = getCurrRow() - row;
        // TODO
        return true;
    }
}
