package pksn.janne.model;

import java.util.Arrays;

import pksn.janne.util.BoardHelper;
import pksn.janne.util.ConstantValues;

public class ChessBoard {

    private ChessPiece[][] board;
    private int count;

    public ChessBoard() {
        board = new ChessPiece[ConstantValues.DEFAULT_BOARD_SIZE][ConstantValues.DEFAULT_BOARD_SIZE];
        count = 0;
    }

    public boolean add(ChessPiece piece, int row, Character column) {
        if (!BoardHelper.isValidRow(row) || !BoardHelper.isValidColumn(column)) {
            return false;
        }
        board[row - 1][BoardHelper.asInteger(column)] = piece;
        ++count;
        return true;
    }

    public ChessPiece get(int row, Character column) {
        if (!BoardHelper.isValidRow(row) || !BoardHelper.isValidColumn(column)) {
            return null;
        }
        return board[row - 1][BoardHelper.asInteger(column)];
    }

    public boolean remove(ChessPiece piece, int row, Character column) {
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
            sb.append(rowIndex).append(". ").append(Arrays.toString(board[i])).append("\n");
            --rowIndex;
        }
        sb.append("    A.    B.    C.    D.    E.    F.    G.    H.");
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