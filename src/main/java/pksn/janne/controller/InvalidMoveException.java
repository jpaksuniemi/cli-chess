package pksn.janne.controller;

public class InvalidMoveException extends Exception {
    public static final int CHESS_PIECE_IN_THE_WAY = -1;
    public static final int CHESS_PIECE_IS_SAME_COLOR = -2;
    public static final int NOT_A_VALID_MOVE = -3;

    public final int code;
    private final int row;
    private final char column;

    public InvalidMoveException(String message, int row, char column, int code) {
        super(message);
        this.row = row;
        this.column = column;
        this.code = code;
    }

    private String codeAsString() {
        return switch (code) {
            case CHESS_PIECE_IN_THE_WAY -> "Another chess piece obstructs the move";
            case CHESS_PIECE_IS_SAME_COLOR -> "Chess piece can't be taken since it is of the same color";
            case NOT_A_VALID_MOVE -> "Not a valid move for the chess piece";
            default -> "Unknown error";
        };
    }

    @Override
    public String getMessage() {
        return String.format("%s, in %c%d", codeAsString(), column, row);
    }
}
