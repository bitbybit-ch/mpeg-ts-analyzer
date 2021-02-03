package com.company.TransportStreamAnalyzer;


import com.company.Benchmark.Benchmark;
import com.company.ByteParser.ByteParser;
import com.company.ByteParser.ByteParserDefault;
import com.company.MPEGChecker.MPEGValidator;
import com.company.Timer.Timer;
import com.company.TransportStreamPacket.TransportStreamPacket;
import com.company.TransportStreamReader.ITransportStreamReaderObserver;
import com.company.TransportStreamReader.TransportStreamReader;


public class TransportStreamAnalyzer implements ITransportStreamReaderObserver {


    Timer timer;
    ByteParser byteParser;
    TransportStreamReader transportStreamReader;
    TransportStreamPacket transportStreamPacket;


    public TransportStreamAnalyzer(TransportStreamReader transportStreamReader) {
        this.transportStreamReader = transportStreamReader;
        this.transportStreamReader.attachObserver(this);
        byteParser = new ByteParserDefault();
    }


    public TransportStreamAnalyzer(TransportStreamReader transportStreamReader,Timer timer) {
        this.timer = timer;
        this.transportStreamReader = transportStreamReader;
        this.transportStreamReader.attachObserver(this);
        byteParser = new ByteParserDefault();
    }


    public TransportStreamAnalyzer(TransportStreamReader transportStreamReader, Timer timer, ByteParser byteParser) {
        this.timer = timer;
        this.byteParser = byteParser;
        this.transportStreamReader = transportStreamReader;
        this.transportStreamReader.attachObserver(this);
    }


    public void start() {

        if(this.timer != null){
            this.timer.start();
        }
        transportStreamReader.startReading();
    }


    @Override
    public void onNext188Bytes(byte[] bytes) {
        if (MPEGValidator.isMpegConform(bytes)) {
            transportStreamPacket = new TransportStreamPacket(bytes,byteParser);
            if(transportStreamPacket.getPid() ==0 || transportStreamPacket.getPid() ==0 || transportStreamPacket.getPid() ==0 ||transportStreamPacket.getPid() ==0){
                System.out.println("PMT");
            }
        }
    }


    @Override
    public void onEnd(int processedPackets) {
        if(this.timer != null){
            long time = this.timer.stop();
            Benchmark.calculateBandwith(processedPackets,time,true);
        }

    }


}

