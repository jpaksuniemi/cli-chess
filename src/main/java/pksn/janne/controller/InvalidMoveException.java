package pksn.janne.controller;

import pksn.janne.model.ChessPiece;

public class InvalidMoveException extends Exception {
    public static final int CHESS_PIECE_IN_THE_WAY = -1;
    public static final int CHESS_PIECE_IS_SAME_COLOR = -2;
    public static final int NOT_A_VALID_MOVE = -3;
    public static final int OUT_OF_BOUNDS = -4;
    public static final int CHECKED_TILE = -5;

    public final int code;
    private final ChessPiece piece;
    private final int startRow;
    private final char startCol;
    private final int endRow;
    private final char endColumn;

    public InvalidMoveException(ChessPiece piece, int startRow, char startCol, int endRow, char endColumn, int code) {
        super("");
        this.piece = piece;
        this.startRow = startRow;
        this.startCol = startCol;
        this.endRow = endRow;
        this.endColumn = endColumn;
        this.code = code;
    }

    private String codeAsString() {
        return switch (code) {
            case CHESS_PIECE_IN_THE_WAY -> "Another chess piece obstructs the move";
            case CHESS_PIECE_IS_SAME_COLOR -> "Chess piece can't be taken since it is of the same color";
            case NOT_A_VALID_MOVE -> "Not a valid move for the chess piece";
            case OUT_OF_BOUNDS -> "Out of bounds";
            case CHECKED_TILE -> "Would place king in check";
            default -> "Unknown error";
        };
    }

    @Override
    public String getMessage() {
        return String.format("%s, in move %s%c%d%c%d", codeAsString(),
                piece, Character.toLowerCase(startCol), startRow, Character.toLowerCase(endColumn), endRow);
    }
}
