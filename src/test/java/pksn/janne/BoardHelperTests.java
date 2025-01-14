package pksn.janne;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pksn.janne.util.ConstantValues;

import static org.junit.jupiter.api.Assertions.*;
import static pksn.janne.util.BoardHelper.*;

class BoardHelperTests {

    @Test
    @DisplayName("Testing isValidRow()")
    void testRowValidity() {
        for (int i = -100; i < 100; i++) {
            if (i > 0 && i <= ConstantValues.DEFAULT_BOARD_SIZE) {
                assertTrue(isValidRow(i), "Should return true when 0 < i <= BoardSize");
            } else {
                assertFalse(isValidRow(i), "Should return false when i <= 0 or i > BoardSize");
            }
        }
    }

    @Test
    @DisplayName("Testing isValidColumn()")
    void testIsValidColumn() {
        for (char i = 'A'; i < 'z'; i++) {
            if (i >= ConstantValues.UPPERCASE_A_ASCII_VALUE && i <= ConstantValues.UPPERCASE_H_ASCII_VALUE) {
                assertTrue(isValidColumn(i), "Should be true when ABCDEFGH");
            } else {
                assertFalse(isValidColumn(i), "Should be false when not ABCDEFGH");
            }
        }
    }

    @Test
    @DisplayName("Testing asInteger()")
    void testAsInteger() {
        int zeroToSevenCounter = 0;
        for (char c = 'A'; c < 'z'; c++) {
            if (c >= ConstantValues.UPPERCASE_A_ASCII_VALUE && c <= ConstantValues.UPPERCASE_H_ASCII_VALUE) {
                assertEquals(zeroToSevenCounter++, asInteger(c), "Should be true when ABCDEFGH");
            } else {
                assertEquals(-1, asInteger(c), "Should only return -1 if not a valid column character");
            }
        }
    }

}
