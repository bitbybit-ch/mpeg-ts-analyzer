package com.company.MPEGChecker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MPEGValidatorTest {

    @Test
    @DisplayName("Process null as input.")
    public void nullTest() {
        byte[] byteArray = null;
        assertEquals(false, MPEGValidator.isMpegConform(byteArray));
    }

    @Test
    @DisplayName("Process a empty byte[] as input.")
    public void emptyArrayTest() {
        byte[] byteArray = new byte[]{};
        assertEquals(false, MPEGValidator.isMpegConform(byteArray));
    }

    @Test
    @DisplayName("Process a byte[] with size 1.")
    public void toSmallArrayTest() {
        byte[] byteArray = new byte[]{1};
        assertEquals(false, MPEGValidator.isMpegConform(byteArray));
    }

    @Test
    @DisplayName("Process a byte[] with size 189.")
    public void toLargeArrayTest() {
        byte[] byteArray = new byte[189];
        assertEquals(false, MPEGValidator.isMpegConform(byteArray));
    }

    @Test
    @DisplayName("Process a byte[] with correct size, but missing Sync-Flag(0x47).")
    public void missingSyncByteTest() {
        byte[] byteArray = new byte[188];
        assertEquals(false, MPEGValidator.isMpegConform(byteArray));
    }

    @Test
    @DisplayName("Process a byte[] with correct size, and the Sync-Flag(0x47). Packet MPEG conform!")
    public void PassTest() {
        byte[] byteArray = new byte[188];
        byteArray[0] = 0x47;
        assertEquals(true, MPEGValidator.isMpegConform(byteArray));
    }

}