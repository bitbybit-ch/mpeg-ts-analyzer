package com.company.TransportStreamPacket;


/*
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
|                                                   4-byte Transport Stream Header
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
|   Name 	                                Number of bits 	    Bitmask (big-endian) 	    Description
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
|
|   Sync byte 	                            8 	                0xff000000 	                Bit pattern of 0x47 (ASCII char 'G')
|   Transport error indicator       	    1 	                0x800000 	                Set when a demodulator can't correct errors from FEC data; indicating the packet is corrupt.[7]
|   Payload unit start indicator        	1 	                0x400000 	                Set when a PES, PSI, or DVB-MIP packet begins immediately following the header.
|   Transport priority 	                    1 	                0x200000 	                Set when the current packet has a higher priority than other packets with the same PID.
|   PID 	                                13 	                0x1fff00 	                Packet Identifier, describing the payload data.
|   Transport scrambling control     	    2 	                0xc0 	                    '00' = Not scrambled.
|                                                                                           For DVB-CSA and ATSC DES only:[8]
|                                                                                           '01' (0x40) = Reserved for future use
|                                                                                           '10' (0x80) = Scrambled with even key
|                                                                                           '11' (0xC0) = Scrambled with odd key
|   Adaptation field control 	            2 	                0x30 	                     01 – no adaptation field, payload only,
|                                                                                            10 – adaptation field only, no payload,
|                                                                                            11 – adaptation field followed by payload,
|                                                                                            00 – RESERVED for future use [9]
|   Continuity counter 	                    4 	                0xf 	                     Sequence number of payload packets (0x00 to 0x0F) within each stream (except PID 8191)
|                                                                                            Incremented per-PID, only when a payload flag is set.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
|  OPTIONAL FIELDS
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
|  Adaptation field 	            variable 		                                        Present if adaptation field control is 10 or 11. See below for format.
|  Payload data 	                variable 		                                        Present if adaptation field control is 01 or 11. Payload may be PES packets, program specific information (below), or other data.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
|  https://en.wikipedia.org/wiki/MPEG_transport_stream
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

import com.company.ByteParser.ByteParser;
import com.company.Table.Section;
import com.company.Table.SectionHandler;
import com.company.TransportStreamHeader.TransportStreamHeader;

import java.util.Arrays;

public class TransportStreamPacket {

    // The elements of a ts packet.
    byte[] headerBytes, sectionHeaderBytes, sectionBytes;
    Section section;

    TransportStreamHeader transportStreamHeader;


    public TransportStreamPacket(byte[] bytes, ByteParser byteParser) {

        // The segments of a transport stream packet
        this.headerBytes = Arrays.copyOfRange(bytes, 0, 4);
        this.sectionHeaderBytes = Arrays.copyOfRange(bytes, 5, 8);
        this.sectionBytes = Arrays.copyOfRange(bytes, 8, 189);

        // create the objects of these segments
        transportStreamHeader = new TransportStreamHeader(headerBytes, byteParser);
        this.section = SectionHandler.handleTableByPID(this, byteParser);
        if (this.section != null) {
            this.section.handleSectionData(this, byteParser);
        }


    }


    public byte[] getSectionHeaderBytes() {
        return sectionHeaderBytes;
    }

    public byte[] getSectionBytes() {
        return sectionBytes;
    }

    public TransportStreamHeader getTransportStreamHeader() {
        return transportStreamHeader;
    }


}
