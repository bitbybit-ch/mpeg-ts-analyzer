package com.company.Timer;

import java.util.Date;


/**
 * My own Timer with Date class.
 */

public class TimerWithDate extends Timer {

    Date startTime;

    public TimerWithDate() {
    }

    /**
     * Starts the Timer
     * max resoulution: 1ms
     */
    public void start() {
        startTime = new Date();
    }

    /**
     * Stops the Timer
     * @return Returns the passed time, while Timer was running in milliseconds [ms]
     */
    @Override
    public long stop() {
        Date stopTime = new Date();
        return stopTime.getTime() - startTime.getTime();
    }


}
