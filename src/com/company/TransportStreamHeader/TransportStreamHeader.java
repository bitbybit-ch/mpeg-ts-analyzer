package com.company.TransportStreamHeader;


import com.company.ByteParser.ByteParser;
import com.company.ByteParser.ByteParserBitMask;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

public class TransportStreamHeader {


    int PID,syncByte,transportErrorIndicator,payloadUnitStartIndicator,transportPriority,trasportScramblingControl,adaptionFieldControl,continuityCounter;

    public TransportStreamHeader(byte[] bytes, ByteParser byteParser) {
        this.syncByte = byteParser.getValueOfBytes(bytes, 0,8,0xff);
        this.transportErrorIndicator = byteParser.getValueOfBytes(bytes, 8,1,0x80);
        this.payloadUnitStartIndicator = byteParser.getValueOfBytes(bytes, 9,1,0x40);
        this.transportPriority = byteParser.getValueOfBytes(bytes, 10,1,0x20);
        this.PID = byteParser.getValueOfBytes(bytes, 11,13,0x1fff);
        this.trasportScramblingControl = byteParser.getValueOfBytes(bytes, 24,2,0xc0);
        this.continuityCounter = byteParser.getValueOfBytes(bytes, 28,4,0xf);
    }


    public int getPID() {
        return this.PID;
    }
}
