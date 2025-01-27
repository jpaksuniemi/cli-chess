package pksn.janne.controller;

import pksn.janne.model.*;
import pksn.janne.model.CheckDetector;
import pksn.janne.util.ConstantValues;

public class PieceController {

    private static ChessBoard board;

    public static boolean moveChessPiece(ChessPiece piece, int row, Character column) throws InvalidMoveException {
        validateMove(piece, row, column);
        if (piece instanceof Pawn pawn) {
            pawn.setHasMoved(true);
        }

        board.add(null, piece.getCurrRow(), piece.getCurrColumn());
        board.add(piece, row, column);
        piece.setCurrRow(row);
        piece.setCurrColumn(column);
        return true;
    }

    private static void validateMove(ChessPiece piece, int row, Character column) throws InvalidMoveException {
        if (!isInBounds(row, column)) {
            throw new InvalidMoveException(piece, piece.getCurrRow(), piece.getCurrColumn(), row, column, InvalidMoveException.OUT_OF_BOUNDS);
        }
        if (!piece.isValidMove(row, column)) {
            throw new InvalidMoveException(piece, piece.getCurrRow(), piece.getCurrColumn(), row, column, InvalidMoveException.NOT_A_VALID_MOVE);
        }
        if (!isDirectionClear(piece, row, column) && !(piece instanceof Knight)) {
            throw new InvalidMoveException(piece, piece.getCurrRow(), piece.getCurrColumn(), row, column, InvalidMoveException.CHESS_PIECE_IN_THE_WAY);
        }
        if (board.get(row, column) != null && !canCapturePiece(piece, board.get(row, column))) {
            throw new InvalidMoveException(piece, piece.getCurrRow(), piece.getCurrColumn(), row, column, InvalidMoveException.CHESS_PIECE_IS_SAME_COLOR);
        }
        if (piece instanceof King king) {
            if (CheckDetector.detectCheck(row, column, king.getColor(), board)) {
                throw new InvalidMoveException(king, king.getCurrRow(), king.getCurrColumn(), row, column, InvalidMoveException.CHECKED_TILE);
            }
        }
    }

    private static boolean isInBounds(int row, int column) {
        return row > 0 && row <= ConstantValues.DEFAULT_BOARD_SIZE && column >= ConstantValues.UPPERCASE_A_ASCII_VALUE && column <= ConstantValues.UPPERCASE_H_ASCII_VALUE;
    }

    private static boolean isDirectionClear(ChessPiece piece, int row, Character column) {
        char tempCol = piece.getCurrColumn();
        int tempRow = piece.getCurrRow();
        while (tempCol != column || tempRow != row) {
            if (tempCol < column) {
                tempCol++;
            } else if (tempCol > column) {
                tempCol--;
            }
            if (tempRow < row) {
                tempRow++;
            } else if (tempRow > row) {
                tempRow--;
            }
            if (Math.abs(tempCol - column) == 0 && Math.abs(tempRow - row) == 0) {
                break;
            }
            if (board.get(tempRow, tempCol) != null) {
                return false;
            }
        }
        return true;
    }

    private static boolean canCapturePiece(ChessPiece taker, ChessPiece toBeTaken) {
        return taker.getColor() != toBeTaken.getColor();
    }

    public static void setBoard(ChessBoard chessBoard) {
        board = chessBoard;
    }

}
