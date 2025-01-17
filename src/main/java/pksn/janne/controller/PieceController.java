package pksn.janne.controller;

import pksn.janne.model.*;

public class PieceController {

    private static ChessBoard board;

    public static void moveChessPiece(ChessPiece piece, int row, Character column) throws InvalidMoveException {
        if (!piece.isValidMove(row, column)) {
            throw new InvalidMoveException("", row, column, InvalidMoveException.NOT_A_VALID_MOVE);
        }
        if (!isClear(piece, row, column)) {
            throw new InvalidMoveException("", row, column, InvalidMoveException.CHESS_PIECE_IN_THE_WAY);
        }
        if (board.get(row, column) != null && !canTakePiece(piece, board.get(row, column))) {
            throw new InvalidMoveException("", row, column, InvalidMoveException.CHESS_PIECE_IS_SAME_COLOR);
        }
        board.add(null, piece.getCurrRow(), piece.getCurrColumn());
        board.add(piece, row, column);
        piece.setCurrRow(row);
        piece.setCurrColumn(column);
    }

    private static boolean isClear(ChessPiece piece, int row, Character column) {
        MovementType type = piece.getMovementType();
        if (type instanceof OrthogonalMovement || type instanceof ForwardMovement) {
            boolean isHorizontal = piece.getCurrRow() == row;
            boolean isVertical = piece.getCurrColumn() == column;
            if (isHorizontal) { return isHorizontallyClear(piece, row, column); }
            if (isVertical) { return isVerticallyClear(piece, row, column); }
        }
        return false;
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
