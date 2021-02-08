package com.company.ByteParser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ByteParserBitmaskTest {
    //    0x47           0x01          0x04           0x18
    // 0100 0111      0000 0001      0000 0100      0001 1000
    //      71            1              4              24
    byte[] bytes = new byte[]{0x47, 0x01, 0x04, 0x18};
    ByteParserBitMask byteParser = new ByteParserBitMask();


    @Test
    @DisplayName("Proof to pick the value of the first bit")
    public void getValueofFirstBit() {
        assertEquals(0, byteParser.getValueOfBytes(bytes, 0, 1, 0), "new byte[188]");
    }


    @Test
    @DisplayName("Proof to pick the value of the first two bits")
    public void getValueofFirstTwoBit() {
        assertEquals(1, byteParser.getValueOfBytes(bytes, 0, 2, 0xC0), "new byte[188]");
    }


    @Test
    @DisplayName("Proof to pick the value of the first six bits")
    public void getValueofFirstSixBit() {
        assertEquals(17, byteParser.getValueOfBytes(bytes, 0, 6, 0xFC), "new byte[188]");
    }


    @Test
    @DisplayName("Proof to pick the value of the first eight bits")
    public void getValueofFirstEightBit() {
        assertEquals(71, byteParser.getValueOfBytes(bytes, 0, 8, 0xFF), "new byte[188]");
    }


    @Test
    @DisplayName("Proof to pick the value of the first twelve  bits")
    public void getValueofFirstTwelveBit() {
        assertEquals(1136, byteParser.getValueOfBytes(bytes, 0, 12, 0xFFF0), "new byte[188]");
    }


    @Test
    @DisplayName("Proof to pick the value of the first Fifteen  bits")
    public void getValueofFirstFifteenBit() {
        assertEquals(9088, byteParser.getValueOfBytes(bytes, 0, 15, 0x1FFFC), "new byte[188]");
    }


    @Test
    @DisplayName("Proof to pick the value of the first sixteen bits")
    public void getValueofFirstSixteenBit() {
        assertEquals(18177, byteParser.getValueOfBytes(bytes, 0, 16, 0xFFFF), "new byte[188]");
    }


    @Test
    @DisplayName("Proof to pick the value of the first seventeen bits")
    public void getValueofFirstSeventeenBit() {
        assertEquals(36354, byteParser.getValueOfBytes(bytes, 0, 17, 0xFFFF80), "new byte[188]");
    }


    @Test
    @DisplayName("Proof to pick the value of 4bit over two")
    public void getValueFromSecondByteFromTwoBits() {
        assertEquals(0, byteParser.getValueOfBytes(bytes, 8, 2, 0xC000), "new byte[188]");
    }


    @Test
    @DisplayName("Proof to pick the value of 4bit over two")
    public void getValueFromSecondByteFromThreeBits() {
        assertEquals(0, byteParser.getValueOfBytes(bytes, 8, 3, 0x1C000), "new byte[188]");
    }

    @Test
    @DisplayName("Proof to pick the value of 4bit over two")
    public void getValueFromSecondByteFromAByte() {
        assertEquals(1, byteParser.getValueOfBytes(bytes, 8, 8, 0xFF), "new byte[188]");
    }


    @Test
    @DisplayName("Proof to pick the value of 4bit over two")
    public void getValueFromSecondByteFromTwoByte() {
        assertEquals(260, byteParser.getValueOfBytes(bytes, 8, 16, 0xFFFF), "new byte[188]");
    }


}

