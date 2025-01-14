package pksn.janne.factories;

import pksn.janne.model.ChessPiece;
import pksn.janne.model.Rook;

public class ChessPieceFactory {

    private ChessPieceFactory() {}

    public static ChessPiece createRook(ChessPiece.Color color, int row, Character column) {
        return new Rook(row, column, color);
    }

}
