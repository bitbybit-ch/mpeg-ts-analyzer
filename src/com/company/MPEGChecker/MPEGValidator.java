package com.company.MPEGChecker;


public class MPEGValidator {

    /**
     * Check if the byte-array is MPEG conform.
     *
     * @param bytes MPEG transportstream-packet
     * @return is MPEG conform or not
     */

    public static boolean isMpegConform(byte[] bytes) {
        if (bytes == null) {
            System.out.println("byte[] bytes array is null");
            return false;
        } else if (bytes.length != 188) {
            System.out.println("The array length needs to be 188 bytes long, like a MPEG-TS packet.The delivered array from the used TransportStreamReader is " + bytes.length + " long.");
            return false;
        } else if (bytes[0] != 0x47) {
            System.out.println("The first byte should be a sync Byte, which has a value of 0x47 => 71 in decimal. The delivered byte[0] from the used TransportStreamReader is " + bytes[0]);
            return false;
        } else {
            return true;
        }
    }

}
