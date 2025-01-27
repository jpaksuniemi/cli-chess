package pksn.janne.model;

import pksn.janne.util.BoardHelper;
import pksn.janne.util.ConstantValues;

public class ChessBoard {

    private ChessPiece[][] board;
    private int count;

    public ChessBoard() {
        board = new ChessPiece[ConstantValues.DEFAULT_BOARD_SIZE][ConstantValues.DEFAULT_BOARD_SIZE];
        count = 0;
    }

    /*
    * @param piece  Can be null to signify empty spot on the board
    * */
    public boolean add(ChessPiece piece, int row, char column) throws IllegalArgumentException {
        if (!BoardHelper.isValidRow(row) || !BoardHelper.isValidColumn(column)) {
            throw new IllegalArgumentException("Invalid row or column");
        }
        board[row - 1][BoardHelper.asInteger(column)] = piece;
        ++count;
        return true;
    }

    public ChessPiece get(int row, char column) throws IllegalArgumentException {
        if (!BoardHelper.isValidRow(row) || !BoardHelper.isValidColumn(column)) {
            throw new IllegalArgumentException("Invalid row or column");
        }
        return board[row - 1][BoardHelper.asInteger(column)];
    }

    public boolean remove(ChessPiece piece, int row, char column) {
        if (null == piece || !BoardHelper.isValidRow(row) || !BoardHelper.isValidColumn(column)) {
            return false;
        }
        board[row - 1][BoardHelper.asInteger(column)] = null;
        --count;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int rowIndex = 8;
        for (int i = ConstantValues.DEFAULT_BOARD_SIZE - 1; i >= 0; i--) {
            sb.append(rowIndex).append(" |");
            for (int j = 0; j < ConstantValues.DEFAULT_BOARD_SIZE; j++) {
                sb.append( (board[i][j] != null) ? " " + board[i][j] + " " : "   ");
                if (j != ConstantValues.DEFAULT_BOARD_SIZE - 1) {
                    sb.append("|");
                }
            }
            sb.append("|\n");
            --rowIndex;
        }
        sb.append("    A   B   C   D   E   F   G   H");
        return sb.toString();
    }

    public void clear() {
        board = new ChessPiece[ConstantValues.DEFAULT_BOARD_SIZE][ConstantValues.DEFAULT_BOARD_SIZE];
        count = 0;
    }

    public int size() {
        return count;
    }

    public Object[] toArray() {
        return board;
    }
}