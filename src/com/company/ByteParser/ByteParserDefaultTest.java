package com.company.ByteParser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ByteParserDefaultTest {
    //    0x47           0x01          0x04           0x18
    // 0100 0111      0000 0001      0000 0100      0001 1000
    //      71            1              4              24
    byte[] bytes = new byte[]{0x47, 0x01, 0x04, 0x18};
    ByteParserDefault byteParser = new ByteParserDefault();


    @Test
    @DisplayName("Proof to pick the value of the first bit")
    public void getValueofFirstBit() {

        assertEquals(0, byteParser.getValueOfBytes(bytes, 0, 1), "new byte[188]");
    }


    @Test
    @DisplayName("Proof to pick the value of the first two bits")
    public void getValueofFirstTwoBit() {
        assertEquals(1, byteParser.getValueOfBytes(bytes, 0, 2), "new byte[188]");
    }


    @Test
    @DisplayName("Proof to pick the value of the first six bits")
    public void getValueofFirstSixBit() {
        assertEquals(17, byteParser.getValueOfBytes(bytes, 0, 6), "new byte[188]");
    }


    @Test
    @DisplayName("Proof to pick the value of the first eight bits")
    public void getValueofFirstEightBit() {
        assertEquals(71, byteParser.getValueOfBytes(bytes, 0, 8), "new byte[188]");
    }


    @Test
    @DisplayName("Proof to pick the value of the first twelve  bits")
    public void getValueofFirstTwelveBit() {
        assertEquals(2272, byteParser.getValueOfBytes(bytes, 0, 13), "new byte[188]");
    }


    @Test
    @DisplayName("Proof to pick the value of the first Fifteen  bits")
    public void getValueofFirstFifteenBit() {
        assertEquals(9088, byteParser.getValueOfBytes(bytes, 0, 15), "new byte[188]");
    }


    @Test
    @DisplayName("Proof to pick the value of the first sixteen bits")
    public void getValueofFirstSixteenBit() {
        assertEquals(18177, byteParser.getValueOfBytes(bytes, 0, 16), "new byte[188]");
    }


    @Test
    @DisplayName("Proof to pick the value of the first seventeen bits")
    public void getValueofFirstSeventeenBit() {
        assertEquals(36354, byteParser.getValueOfBytes(bytes, 0, 17), "new byte[188]");
    }


    @Test
    @DisplayName("Proof to pick the value of 4bit over two")
    public void getValueFromSecondByteFromTwoBits() {
        assertEquals(0, byteParser.getValueOfBytes(bytes, 8, 2), "new byte[188]");
    }


    @Test
    @DisplayName("Proof to pick the value of 4bit over two")
    public void getValueFromSecondByteFromThreeBits() {
        assertEquals(0, byteParser.getValueOfBytes(bytes, 8, 3), "new byte[188]");
    }

    @Test
    @DisplayName("Proof to pick the value of 4bit over two")
    public void getValueFromSecondByteFromAByte() {
        assertEquals(1, byteParser.getValueOfBytes(bytes, 8, 8), "new byte[188]");
    }


    @Test
    @DisplayName("Proof to pick the value of 4bit over two")
    public void getValueFromSecondByteFromTwoByte() {
        assertEquals(260, byteParser.getValueOfBytes(bytes, 8, 16), "new byte[188]");
    }


}

