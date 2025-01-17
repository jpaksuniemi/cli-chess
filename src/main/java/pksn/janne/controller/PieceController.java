package pksn.janne.controller;

import pksn.janne.model.ChessBoard;
import pksn.janne.model.ChessPiece;

public class PieceController {

    private static ChessBoard board;

    public static boolean moveChessPiece(ChessPiece piece, int row, Character column) {
        if (!piece.isValidMove(row, column)) { return false; }
        if (!isHorizontallyClear(piece, row, column)) { return false; }
        if (board.get(row, column) != null && !canTakePiece(piece, board.get(row, column))) { return false; }
        board.add(null, piece.getCurrRow(), piece.getCurrColumn());
        board.add(piece, row, column);
        piece.setCurrRow(row);
        piece.setCurrColumn(column);
        return true;
    }

    private static boolean isHorizontallyClear(ChessPiece piece, int row, Character column) {
        char tempCol = piece.getCurrColumn();
        while (tempCol != column) {
            if (tempCol < column) {
                tempCol++;
            } else {
                tempCol--;
            }
            if (Math.abs(tempCol - column) == 0) {
                break;
            }
            if (board.get(row, tempCol) != null) {
                return false;
            }
        }
        return true;
    }

    private static boolean isVerticallyClear(ChessPiece piece, int row, Character column) {
        int tempRow  = piece.getCurrRow();
        while (tempRow != row) {
            if (tempRow < row) {
                tempRow++;
            } else {
                tempRow--;
            }
            if (Math.abs(tempRow - row) == 0) {
                break;
            }
            if (board.get(tempRow, column) != null) {
                return false;
            }
        }
        return true;
    }

    private static boolean canTakePiece(ChessPiece taker, ChessPiece toBeTaken) {
        return taker.getColor() != toBeTaken.getColor();
    }

    public static void setBoard(ChessBoard chessBoard) {
        board = chessBoard;
    }

}
