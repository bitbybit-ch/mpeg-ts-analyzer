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

import java.util.ArrayList;
import java.util.Arrays;

public class TransportStreamPacket {

    int syncByte, pid,transportErrorIndicator,payloadUnitStartIndicator,transportPriority,transportScramblingControl,adaptionFieldControl,continuityCounter;
    byte[] payload;
    String adaptionField;

    static ArrayList<TransportStreamPacket> streamList = new ArrayList<>();

    public TransportStreamPacket(byte[] bytes, ByteParser byteParser) {
        this.syncByte = byteParser.getValueOfBytes(bytes, 0, 8);
        this.pid = byteParser.getValueOfBytes(bytes, 11, 13);
        this.payload = Arrays.copyOfRange(bytes, 3, 188);

        /* Other values, but not needed. For performance outcommented */
/*

        this.transportErrorIndicator = byteParser.getValueOfBytes(bytes, 8, 1);
        this.payloadUnitStartIndicator = byteParser.getValueOfBytes(bytes, 9, 1);
        this.transportPriority = byteParser.getValueOfBytes(bytes, 10, 1);

        this.transportScramblingControl = byteParser.getValueOfBytes(bytes, 24, 2);
        this.adaptionFieldControl = byteParser.getValueOfBytes(bytes, 26, 2);
        this.continuityCounter = byteParser.getValueOfBytes(bytes, 28, 4);


        if (this.adaptionFieldControl == 10 || this.adaptionFieldControl == 11) {
            this.adaptionField = "Adaption Field";
        }
        if (this.adaptionFieldControl == 1) {
            this.payload = Arrays.copyOfRange(bytes, 3, 188);
        }
*/
        //streamList.add(this);

    }


    public int getPid() {
        return pid;
    }



}
