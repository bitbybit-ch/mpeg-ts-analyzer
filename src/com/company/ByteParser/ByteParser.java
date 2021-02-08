package com.company.ByteParser;


public abstract class ByteParser {


    /**
     * Get a demcimal integer from a binarystring inside of byte-array by the position of startbit and the number of bits.
     * Byte-array convert to binary string, startbit will cut binarystring in length of ammountOfBits
     *
     * @param bytes         Byte-array where to get the Value from
     * @param startBit      Position of the first bit
     * @param ammountOfBits How many bits
     * @param bitMask       The Bitmask for the array-bytes to filter the value
     * @return Returns a decimal number from specific bit positions
     */

    public abstract int getValueOfBytes(byte[] bytes, int startBit, int ammountOfBits, int bitMask);


}





