package pksn.janne.controller;

import pksn.janne.model.ChessBoard;
import pksn.janne.model.ChessPiece;

public class PieceController {

    private static ChessBoard board;

    public static boolean moveChessPiece(ChessPiece piece, int row, Character column) {
        if (!piece.isValidMove(row, column)) { return false; }
        if (board.get(row, column) != null) { return false; }
        board.add(null, piece.getCurrRow(), piece.getCurrColumn());
        board.add(piece, row, column);
        piece.setCurrRow(row);
        piece.setCurrColumn(column);
        return true;
    }

    public static void setBoard(ChessBoard chessBoard) {
        board = chessBoard;
    }

}
