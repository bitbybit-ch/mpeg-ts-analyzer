package com.company.Table;

import com.company.ByteParser.ByteParser;
import com.company.TransportStreamPacket.TransportStreamPacket;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class PAT extends Section {

    private final static int PAT_HEADER_LENGTH = 5;

    int TsStreamId, reserved, versionNo, currentNextIndicator, sectionNumber, lastSectionNumer;
    // TODO PID Mapping

    public PAT(TransportStreamPacket transportStreamPacket, ByteParser byteParser) {
        super(transportStreamPacket, byteParser, PAT_HEADER_LENGTH);
        this.TsStreamId = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 0, 16, 0xFFFF);
        this.reserved = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 16, 2, 0xC0);
        this.versionNo = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 18, 5, 0x3E);
        this.currentNextIndicator = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 23, 1, 0x01);
        this.sectionNumber = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 24, 8, 0xff);
        this.lastSectionNumer = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 32, 8, 0xff);

    }

    private void attach(byte[] bytes) {
        System.out.println(new String(bytes, StandardCharsets.UTF_8));

    }

}
