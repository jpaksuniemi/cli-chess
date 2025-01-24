package pksn.janne.factories;

import pksn.janne.model.Bishop;
import pksn.janne.model.ChessPiece;
import pksn.janne.model.Pawn;
import pksn.janne.model.Rook;

public class ChessPieceFactory {

    private ChessPieceFactory() {}

    public static ChessPiece createRook(ChessPiece.Color color, int row, Character column) {
        return new Rook(row, column, color);
    }

    public static ChessPiece createPawn(ChessPiece.Color color, int row, Character column) {
        return new Pawn(row, column, color);
    }

    public static ChessPiece createBishop(ChessPiece.Color color, int row, Character column) {
        return new Bishop(row, column, color);
    }

}
