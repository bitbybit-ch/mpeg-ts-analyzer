package com.company.TransportStreamReader;

public interface ITransportStreamReaderObserver {

    /** Get updated for new byte-array
     * @param bytes next byte-array with size of 188 (MPEG-TS packet)
     */
    void onNext188Bytes(byte[] bytes);


    /** Stream ends
     * @param processedPackets Returns the ammount of readed packets
     */
    void onEnd(int processedPackets);
}
