package com.company.ByteParser;


import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class ByteParserBitMask extends ByteParser {


    /**
     * This is my own ByteParser, there may be quicker ByteParser.
     *
     * @param bytes         Byte-array where to get the Value from
     * @param startBit      Position of the first bit
     * @param ammountOfBits How many bits
     * @param bitmask       How many bits
     * @return
     */


    @Override
    public int getValueOfBytes(byte[] bytes, int startBit, int ammountOfBits, int bitmask) {

        int startByte = (startBit) / 8;
        int endByte = ((startBit + ammountOfBits - 1) / 8);

        // Get Integer from involved bytes
        byte[] involvedBytes = Arrays.copyOfRange(bytes, startByte, endByte + 1);
        int bigInteger = new BigInteger(involvedBytes).intValue();

        // How many bits are not used
        int shift = involvedBytes.length * 8 - startBit % 8 - ammountOfBits;

        //bit selection by bitmask
        bigInteger = bigInteger & bitmask;
        // shift these bits out
        bigInteger = bigInteger >> shift;
        return bigInteger;

    }
}





