package com.company.TransportStreamReader;

public abstract class TransportStreamReader {


    String path;
    ITransportStreamReaderObserver observer;

    /**
     * Create a StreamReader to read MPEG-ts files
     * @param path path to the source file. Depends on the Streamreader.
     *             Could be multicast, file or http
     */
    public TransportStreamReader(String path) {
        this.path = path;
    }


    /**
     * Attach an Observer to the Reader, for updating on new bytes
     * @param observer Object that can get updated.
     */
    public void attachObserver(ITransportStreamReaderObserver observer) {
        this.observer = observer;
    }


    /**
     * Start reading TransportStream
     */
    abstract public void startReading();


}
