package com.company.Table;

import com.company.ByteParser.ByteParser;
import com.company.TransportStreamPacket.TransportStreamPacket;

public class EIT extends Section {

    private final static int EIT_HEADER_LENGTH = 11;

    int serviceId, reserved, versionNo, currentNextIndicator, sectionNumber, lastSectionNumer, transportStreamId, originalNetworkId, segmentLastSectionNumber, lastTableId;
    // TODO PID Mapping

    public EIT(TransportStreamPacket transportStreamPacket, ByteParser byteParser) {

        super(transportStreamPacket, byteParser, EIT_HEADER_LENGTH);

        this.serviceId = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 0, 16, 0xFFFF);
        this.reserved = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 16, 2, 0xC0);
        this.versionNo = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 18, 5, 0x3E);
        this.currentNextIndicator = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 23, 1, 0x01);
        this.sectionNumber = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 24, 8, 0xff);
        this.lastSectionNumer = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 32, 8, 0xff);
        this.transportStreamId = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 40, 16, 0xff);
        this.originalNetworkId = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 56, 16, 0xff);
        this.segmentLastSectionNumber = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 72, 8, 0xff);
        this.lastTableId = byteParser.getValueOfBytes(transportStreamPacket.getSectionBytes(), 80, 8, 0xff);

    }

    private void attach(byte[] bytes) {


    }

}
