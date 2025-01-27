package pksn.janne.util;

public class BoardHelper {

    public static int asInteger(char c) {
        return (isValidColumn(c)) ? c - ConstantValues.UPPERCASE_A_ASCII_VALUE : -1;
    }

    public static boolean isInBounds(int row, char col) {
        return isValidRow(row) && isValidColumn(col);
    }

    public static boolean isValidRow(int i) {
        return 0 < i && i <= ConstantValues.DEFAULT_BOARD_SIZE; 
    }

    public static boolean isValidColumn(char c) {
        return ConstantValues.UPPERCASE_A_ASCII_VALUE <= c && c <= ConstantValues.UPPERCASE_H_ASCII_VALUE;
    }
}
