package com.company.Table;

import com.company.ByteParser.ByteParser;
import com.company.TransportStreamPacket.TransportStreamPacket;

public class SDT extends Section {

    private final static int SDT_HEADER_LENGTH = 8;

    int reserved, versionNo, currentNextIndicator, sectionNumber, lastSectionNumer, transportStreamId, originalNetworkId, reserved2;
    // TODO PID Mapping

    public SDT(TransportStreamPacket transportStreamPacket, ByteParser byteParser) {

        super(transportStreamPacket, byteParser, SDT_HEADER_LENGTH);

        this.transportStreamId = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 0, 16, 0xFFFF);
        this.reserved = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 16, 2, 0xC0);
        this.versionNo = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 18, 5, 0x3E);
        this.currentNextIndicator = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 23, 1, 0x01);
        this.sectionNumber = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 24, 8, 0xff);
        this.lastSectionNumer = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 32, 8, 0xff);
        this.originalNetworkId = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 40, 16, 0xffff);
        //this.reserved2 = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 80,8,0xff);
        attach(transportStreamPacket.getSectionBytes());
    }

    private void attach(byte[] bytes) {
        //System.out.println(new String(bytes,StandardCharsets.ISO_8859_1));

    }

}
