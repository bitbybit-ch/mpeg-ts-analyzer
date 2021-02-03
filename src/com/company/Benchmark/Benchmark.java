package com.company.Benchmark;


public class Benchmark {

    static long bandwith;


    /**
     * Returns the bandwidth throughput through the application
     * Its needed, to check if a 20Mb/s Transport-Stream can be handled.
     *
     * @param packetNumber Number of processed packets
     * @param time         Amount of time to process all packets
     * @return returns the bandwidth in Mb/s
     */

    public static long calculateBandwith(int packetNumber, long time) {
        //     byte/packet            to Kb         to MB  per second
        //          !!  no of packets    !!   to Mb   !!       !!
        //          !!      !!           !!     !!    !!  _____!!____
        bandwith = 188 * packetNumber / 1024 / 1024 * 8 * 1000 / time;
        return bandwith;
    }


    /**
     * Returns the bandwidth throughput through the application
     * Its needed, to check if a 20Mb/s Transport-Stream can be handled.
     * Its the same method like the first one, but there
     *
     * @param packetNumber Number of processed packets
     * @param time         Amount of time to process all packets
     * @param log          true will print benchmark in System.out.println
     * @return returns the bandwidth in Mb/s
     */

    public static long calculateBandwith(int packetNumber, long time, boolean log) {
        long bandwith = calculateBandwith(packetNumber, time);
        if (log) {
            print(packetNumber, time, bandwith);
        }
        return bandwith;
    }


    /**
     * Logs the benchmark in System.out.println
     *
     * @param packetNumber Number of processed packets
     * @param time         Amount of time to process all packets
     * @param bandwith     The bandwidth that the application can handle
     */

    private static void print(int packetNumber, long time, long bandwith) {
        System.out.println(
                "-------------------------------------                        \n" +
                        "\t\t\tBenchmark:                                     \n" +
                        "-------------------------------------                \n" +
                        "Packets:\t\t" + packetNumber + "                     \n" +
                        "Time:\t\t\t" + time + "ms                            \n" +
                        "Bandwidth:\t\t" + bandwith + "Mb/s                   \n" +
                        "-------------------------------------                \n" +
                        "Bandwidth reached just mapping PID:\n\t\t\t~3000Mb/s \n" +
                        "-------------------------------------                \n");
    }

}

