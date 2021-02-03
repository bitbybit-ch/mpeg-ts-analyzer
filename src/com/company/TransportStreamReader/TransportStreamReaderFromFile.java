package com.company.TransportStreamReader;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;



public class TransportStreamReaderFromFile extends TransportStreamReader {


    public TransportStreamReaderFromFile(String path) {
        super(path);
    }

    /**
     * Starts reading a File
     * Cuts file in multiple byte-arrays with a size of 188
     * loop thought arrays and update the observer on next 188bytes.
     */

    @Override
    public void startReading() {

        byte[] bytes = getByteArrayFromFile();
        int ammountOfChunkFiles = bytes.length/188;

        for(int i=0; i< ammountOfChunkFiles;i++){
            byte[] chunkFile = Arrays.copyOfRange(bytes,i*188,i*188+188);
            super.observer.onNext188Bytes(chunkFile);
        }

        super.observer.onEnd(ammountOfChunkFiles);
    }

    /**
     * Load file in a byte-array
     * On error returns empty array
     * @return content of a file in a byte-array
     *
     */

    public byte[] getByteArrayFromFile(){

        byte[] bytes = {};

        try{
            File file = new File(path);
            bytes = Files.readAllBytes(file.toPath());
        }catch (Exception e){
            System.out.println("Error while Reading File by TransportStreamReaderFromFile: " + e);
        }finally {
            return bytes;
        }
    }


}
