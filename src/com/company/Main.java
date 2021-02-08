package com.company;

import com.company.ByteParser.ByteParserBitMask;
import com.company.Timer.TimerWithDate;
import com.company.TransportStreamAnalyzer.TransportStreamAnalyzer;
import com.company.TransportStreamReader.TransportStreamReader;
import com.company.TransportStreamReader.TransportStreamReaderFromFile;


public class Main {

    public static void main(String[] args) {

        TransportStreamReader tsReader = new TransportStreamReaderFromFile("E:/SRF1_HD.ts");
        TransportStreamAnalyzer tsAnalyzer = new TransportStreamAnalyzer(tsReader, new TimerWithDate(), new ByteParserBitMask());
        tsAnalyzer.start();

    }

}
