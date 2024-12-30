package pksn.janne.model;

import java.util.EnumMap;
import java.util.Map;

public class ChessBoard {

    private static final int DEFAULT_SIZE = 8; 
    private ChessPiece[][] board;
    private int count;

    private static final Map<Column, Integer> columnIndexMap = new EnumMap<>(Column.class);

    public enum Column {
        A,
        B,
        C,
        D,
        E,
        F,
        G,
        H
    }

    static {
        columnIndexMap.put(Column.A, 0);
        columnIndexMap.put(Column.B, 1);
        columnIndexMap.put(Column.C, 2);
        columnIndexMap.put(Column.D, 3);
        columnIndexMap.put(Column.E, 4);
        columnIndexMap.put(Column.F, 5);
        columnIndexMap.put(Column.G, 6);
        columnIndexMap.put(Column.H, 7);
    }

    public ChessBoard() {
        board = new ChessPiece[DEFAULT_SIZE][DEFAULT_SIZE];
        count = 0;
    }

    public boolean add(ChessPiece piece, Column column, int row) {
        if (null == piece || !isValidRow(row) || !columnIndexMap.containsKey(column)) {
            return false;
        }
        board[row - 1][columnIndexMap.get(column)] = piece;
        ++count;
        return true;
    }

    public ChessPiece get(Column column, int row) {
        if (!isValidRow(row) || !columnIndexMap.containsKey(column)) {
            return null;
        }
        return board[row][columnIndexMap.get(column)];
    }

    public boolean remove(ChessPiece piece, Column column, int row) {
        if (null == piece || !isValidRow(row) || !columnIndexMap.containsKey(column)) {
            return false;
        }
        board[row - 1][columnIndexMap.get(column)] = null;
        --count;
        return true;
    }

    private boolean isValidRow(int row) {
        return 0 < row && row <= DEFAULT_SIZE;
    }

    public void clear() {
        board = new ChessPiece[DEFAULT_SIZE][DEFAULT_SIZE];
        count = 0;
    }

    public int size() {
        return count;
    }

    public Object[] toArray() {
        return board;
    }
}