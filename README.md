# MPEG transport stream Analyzer
*My first opensource project*


## Note

The MPEG transport stream analyzer is a live ongoing open-source project that just started February 2021.
It isn't nearly finished.

It is a learning project for me and the folks in the world.
For me it is the "hello word" opensource project ;)
I would be happy about ratings!
info@bitbybit.ch

## Description
The MPEG transport stream analyzer reads an MPEG input stream and parses the data.
The goal is to collect the PSI/SI data out of the transport stream (TS) like an SDT or EIT (EPG).
I'd like to build up my own EPG by a UDP Multicast MPEG Transport Stream.

#What is a MPEG transport stream - MPEG-TS:

1. A MPEG-TS can come from a file or from a live source (e.g multicast).
2. A MPEG-TS exists of TS-packets with a size of 188 bytes.
3. Every TS-packet starts with the SyncByte 0x47 => dec 71.
4. The first 4 bytes in the TS-packet are reserved for the ts-packet header.
5. The other 184 bytes contain sections of audio video or metadata, but not mixed.
6. The content of the TS-packet is described by the PID. These are 13 bits inside every TS-packet.
6. Audio, video are Elementary Streams.
7. DVB-Tables like PAT, PMT,NIT and CAT are PSI Tables.
    PAT: Programm Association Table, PID=0, used to identify actual stream
    PMT: Programm Map Table, PID is defined in PAT, contains info about other PIDs
    NIT: Network Information Table: Network parameter from tv-operator
    CAT: Conditional Access Table: information about descrambling
8. Tables like SDT & EIT SI-Tables
   SDT: Service Description Table, contains service name and info about the tv-channel
   EIT: Event Information Table, contains the EPG (Electronic Program Guide) data


                                   MPEG- Transport Stream
     ________________________________________________________________________________________________
     
            ___________        ___________      ___________       ___________       ___________
           | TS-packet |      | TS-packet |    | TS-packet |     | TS-packet |     | TS-packet |   
           |           |      |           |    |           |     |           |     |           |   
           |  PID=0    |      |  PID=8190 |    |  PID=21   |     |  PID=8190 |     |   PID=21  |   
           |___________|      |___________|    |___________|     |___________|     |___________|          .................. Endless
        _________________
             188 bytes


