package pksn.janne.controller;

import pksn.janne.model.ChessBoard;
import pksn.janne.model.ChessPiece;

public class PieceController {

    private static ChessBoard board;

    public static boolean moveChessPiece(ChessPiece piece, int row, Character column) {
        if (!piece.isValidMove(row, column)) { return false; }
        boolean test = canTakePiece(piece, board.get(row, column));
        if (board.get(row, column) != null && !canTakePiece(piece, board.get(row, column))) { return false; }
        board.add(null, piece.getCurrRow(), piece.getCurrColumn());
        board.add(piece, row, column);
        piece.setCurrRow(row);
        piece.setCurrColumn(column);
        return true;
    }

    private static boolean canTakePiece(ChessPiece taker, ChessPiece toBeTaken) {
        return toBeTaken != null && taker.getColor() != toBeTaken.getColor();
    }

    public static void setBoard(ChessBoard chessBoard) {
        board = chessBoard;
    }

}
