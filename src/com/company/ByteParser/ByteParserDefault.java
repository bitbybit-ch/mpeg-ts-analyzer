package com.company.ByteParser;


public class ByteParserDefault extends ByteParser {


    /**
     * This is my own ByteParser, there may be quicker ByteParser.
     * Change out ByteParser by use of extending ByteParser
     *
     * Works with binary length which is bigger than a byte
     *
     * Example:
     * Input bytes[]            =           0x47           0x01          0x10
     * Input bytes in binary    =        0100 0111      0000 0001    0001 0000
     * Input bytes in dec       =           71              1            16
     *
     * complete binarystring = 010001110000000100010000
     *
     * startbit         = 0
     * ammountOfBits    = 3
     * binarystring     = 010 001110000000100010000
     *                   ^   ^
     * 010              =  2
     * return 2
     *
     * ------------------------------------------------------------------------------------------------------------
     *
     * startbit         = 9
     * ammountOfBits    = 9
     * binarystring     = 010001110 000000100 010000
     *                             ^         ^
     * 100              =               4
     * return 4
     *
     * @param bytes         Byte-array where to get the Value from
     * @param startBit      Position of the first bit
     * @param ammountOfBits How many bits
     * @return
     */

    @Override
    public int getValueOfBytes(byte[] bytes, int startBit, int ammountOfBits) {


        int startByte = startBit / 8;
        int endByte = startByte + ammountOfBits / 8 ;
        int startModulo = (startBit)%8;

        String binary = "";

        try {

            for (int i = startByte; i <= endByte; i++) {
                String s = Integer.toBinaryString((bytes[i] & 0xFF) + 0x100).substring(1);
                binary = binary + s;
            }

            binary = binary.substring(startModulo,startModulo + ammountOfBits);

            return Integer.parseInt(binary, 2);

        } catch (Exception e) {
            return 0;
        }

    }


}





