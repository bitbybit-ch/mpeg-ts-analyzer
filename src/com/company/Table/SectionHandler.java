package com.company.Table;

import com.company.ByteParser.ByteParser;
import com.company.TransportStreamHeader.TransportStreamHeader;
import com.company.TransportStreamPacket.TransportStreamPacket;

public class SectionHandler {

    boolean sectionsAreReady, PATisReady, SDTisReady, EITisReady;

    public static Section handleTableByPID(TransportStreamPacket transportStreamPacket, ByteParser byteParser) {

        int PID = transportStreamPacket.getTransportStreamHeader().getPID();

        if(PID<20){
            switch (PID){
                case 0:                 // PAT
                    return new PAT(transportStreamPacket,byteParser);
                case 1:                 // CAT
                    break;
                case 2:                 // TSDT
                    break;
                case 16:                 // NIT
                    break;
                case 17:                 // SDT
                    return new SDT(transportStreamPacket,byteParser);
                case 0x12:                 // EIT
                    return new EIT(transportStreamPacket,byteParser);
                case 20:                 // TDT

                default:
                    System.out.println("No PSI SI");
            }
            //System.out.println(PID);
        }

        return null;
    }


}
