package com.company.Table;

import com.company.ByteParser.ByteParser;
import com.company.TransportStreamPacket.TransportStreamPacket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


public class Section {

    TransportStreamPacket transportStreamPacket;
    SectionHeader sectionHeader;

    private static List<Section> sectionList = new ArrayList<>();      // A array for each table, like PAT or EIT


    public Section(TransportStreamPacket transportStreamPacket, ByteParser byteParser, int tableHeaderLength) {
        this.transportStreamPacket = transportStreamPacket;
        sectionHeader = new SectionHeader(transportStreamPacket, byteParser);
    }


    public void handleSectionData(TransportStreamPacket transportStreamPacket, ByteParser byteParser) {
        if (PIDalreadyExists(this.getPid())) {
            addNewDatatoSection(transportStreamPacket.getSectionBytes());
        } else {
            System.out.println("New Section found: PID = " + transportStreamPacket.getTransportStreamHeader().getPID());
            sectionList.add(this);
        }
    }


    private boolean PIDalreadyExists(int pid) {
        for (Section section : this.sectionList) {
            if (section.getPid() == pid) {
                return true;
            }
        }
        return false;
    }


    private int getPid() {
        return transportStreamPacket.getTransportStreamHeader().getPID();
    }

    private void addNewDatatoSection(byte[] sectionData) {

    }


}
