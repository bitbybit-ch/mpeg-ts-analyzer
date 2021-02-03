package com.company;

import com.company.Timer.TimerWithDate;
import com.company.ByteParser.ByteParserDefault;
import com.company.TransportStreamAnalyzer.TransportStreamAnalyzer;
import com.company.TransportStreamReader.TransportStreamReader;
import com.company.TransportStreamReader.TransportStreamReaderFromFile;

public class Main {


    public static void main(String[] args)  {

        TransportStreamReader tsReader = new TransportStreamReaderFromFile("E:/SRF1_HD.ts");
        TransportStreamAnalyzer tsAnalyzer = new TransportStreamAnalyzer(tsReader, new TimerWithDate(), new ByteParserDefault());
        tsAnalyzer.start();

    }

}
