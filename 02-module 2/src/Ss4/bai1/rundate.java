package Ss4.bai1;

import java.util.Date;

public class rundate {
    public static void main(String[] args) {
        Date newtime = new Date();
        Date stoptime = new Date();
        StopWatch stopWatch = new StopWatch(newtime,stoptime);
        System.out.println(" thoi gian đã qua là :" + stopWatch.getElapsedTime());
    }
}
