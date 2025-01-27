package pksn.janne.model;

import pksn.janne.util.BoardHelper;

public class CheckDetector {

    // directions for sliding pieces (rooks, bishops, queens, pawns)
    private static final int[][] DIRECTIONS = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},  // up, down, left, right (rook, queen)
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1} // diagonals (bishop, queen, pawn)
    };

    // L-shaped offsets for knight
    private static final int[][] KNIGHT_MOVES = {
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
    };

    public static boolean detectCheck(int startRow, char startCol, ChessPiece.Color color, ChessBoard board) {
        // check for sliding pieces
        for (int[] direction : DIRECTIONS) {
            if (isThreatInDirection(startRow, startCol, color, board, direction)) {
                return true;
            }
        }

        // check for knight
        for (int[] move : KNIGHT_MOVES) {
            int targetRow = startRow + move[0];
            char targetCol = (char) (startCol + move[1]);
            if (isKnightThreat(targetRow, targetCol, color, board)) {
                return true;
            }
        }

        // check for king (one step to all directions)
        for (int[] direction : DIRECTIONS) {
            int targetRow = startRow + direction[0];
            char targetCol = (char) (startCol + direction[1]);
            if (isKingThreat(targetRow, targetCol, color, board)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isThreatInDirection(int startRow, char startCol, ChessPiece.Color color, ChessBoard board, int[] direction) {
        int row = startRow;
        char col = startCol;

        while (BoardHelper.isInBounds(row, col)) {
            row += direction[0];
            col += (char) direction[1];

            if (!BoardHelper.isInBounds(row, col)) {
                break;
            }

            ChessPiece piece = board.get(row, col);
            if (piece != null) {
                // stop at the first piece and check if it poses a threat
                if     (piece.getColor() != color && (piece instanceof Rook && (direction[0] == 0 || direction[1] == 0) ||
                        piece instanceof Bishop && Math.abs(direction[0]) == Math.abs(direction[1]) ||
                        piece instanceof Pawn && Math.abs(direction[0]) == Math.abs(direction[1]) && Math.abs(startRow - row) == Math.abs(startCol - col) ||
                        piece instanceof Queen)) {
                    return true;
                }
                break; // break if blocked by another piece
            }
        }
        return false;
    }

    private static boolean isKnightThreat(int row, char col, ChessPiece.Color color, ChessBoard board) {
        if (BoardHelper.isInBounds(row, col)) {
            ChessPiece piece = board.get(row, col);
            return piece != null && piece.getColor() != color && piece instanceof Knight;
        }
        return false;
    }

    private static boolean isKingThreat(int row, char col, ChessPiece.Color color, ChessBoard board) {
        if (BoardHelper.isInBounds(row, col)) {
            ChessPiece piece = board.get(row, col);
            return piece != null && piece.getColor() != color && piece instanceof King;
        }
        return false;
    }
}