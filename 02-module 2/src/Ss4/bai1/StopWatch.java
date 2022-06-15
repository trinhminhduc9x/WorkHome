package Ss4.bai1;

import java.util.Date;

public class StopWatch {
    Date startTime ;
    Date stopTime ;
    public StopWatch(Date startTime, Date stopTime){
        this.startTime=startTime;
        this.stopTime=stopTime;
    }
    public Date getStartTime() {
        return startTime;
    }
    public Date getStopTime() {
        return stopTime;
    }
    public void start() {
        this.startTime = new Date();
    }
    public void stop() {
        this.stopTime = new Date();
    }
    public long getElapsedTime() {
        return this.stopTime.getTime() - startTime.getTime();
    }
}
