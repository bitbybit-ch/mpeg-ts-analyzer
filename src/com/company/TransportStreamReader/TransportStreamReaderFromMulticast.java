package com.company.TransportStreamReader;


import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class TransportStreamReaderFromMulticast extends TransportStreamReader{


    public TransportStreamReaderFromMulticast(String path) {
        super(path);
    }

    /**
     * TODO Multicast Streamreader needs to be implementet
     * Status:Untetsted, quick, raw and dirty
     */

    @Override
    public void startReading() {

        try {
            InetAddress group = InetAddress.getByName("udp://@239.0.0.1");
            MulticastSocket multicastSocket = new MulticastSocket(5004);
            multicastSocket.joinGroup(group);
            byte[] buffer = new byte[188];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                multicastSocket.receive(packet);
                String str = new String(packet.getData(), 0, packet.getLength());
                System.out.println(str);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }




}
