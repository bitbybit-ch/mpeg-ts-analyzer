package com.company.Timer;


public abstract class Timer {


    /**
     * Starts the Timer
     */
    abstract public void start();

    /**
     * Stops the Timer
     * @return Returns the passed time, while Timer was running
     */
    public abstract long stop();


}
