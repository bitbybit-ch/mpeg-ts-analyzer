package com.company.Table;

import com.company.ByteParser.ByteParser;
import com.company.TransportStreamPacket.TransportStreamPacket;

import java.util.Arrays;


public class SectionHeader {

    int tableId, sectionSyntaxIndicator, reservedFutureUse, reserved, sectionLength;

    public SectionHeader(TransportStreamPacket transportStreamPacket, ByteParser byteParser) {

        // Section header
        this.tableId = byteParser.getValueOfBytes(transportStreamPacket.getSectionHeaderBytes(), 0, 8, 0xff);
        this.sectionSyntaxIndicator = byteParser.getValueOfBytes(transportStreamPacket.getSectionHeaderBytes(), 8, 1, 0x80);
        this.reservedFutureUse = byteParser.getValueOfBytes(transportStreamPacket.getSectionHeaderBytes(), 9, 1, 0x40);
        this.reserved = byteParser.getValueOfBytes(transportStreamPacket.getSectionHeaderBytes(), 10, 2, 0x10);
        this.sectionLength = byteParser.getValueOfBytes(transportStreamPacket.getSectionHeaderBytes(), 12, 12, 0x0FFF);

    }

}
