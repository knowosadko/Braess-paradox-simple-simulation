package Przetwarzanie.rozproszone;

import java.util.ConcurrentModificationException;

import static java.lang.System.currentTimeMillis;

public class Car extends Thread {
    long DrivingTime;
    Highway highawyYB;
    Highway highawyAX;
    LocalRoad localXB;
    LocalRoad localAY;
    Highway highwayYX;
    TimeAverage times;
    Boolean YXflag;
    Car(Highway highwayYB, LocalRoad localAY,Highway highwayAX, LocalRoad localXB, Highway highwayYX ,TimeAverage times )
    {
        super();
        YXflag = true;
        this.highawyAX = highwayAX;
        this.highwayYX = highwayYX;
        this.highawyYB = highwayYB;
        this.localAY = localAY;
        this.localXB = localXB;
        this.times = times;
        DrivingTime = 0;
    }
    public void run()
    {
        int timeAXXB;
        int timeAYYB;
        int timeAYXB;
        try{

             timeAXXB = (int) this.times.ReadTimeAXXB();
             timeAYYB = (int) this.times.ReadTimeAYYB();
             timeAYXB = (int) this.times.ReadTimeAYXB();
        }
        catch(ConcurrentModificationException e)
        {
            System.out.println("Empty");
            return;
        }

        if (timeAXXB >= timeAYYB)
        {
            if(timeAYYB > timeAYXB && YXflag)
            {
                try {
                    long time1 = currentTimeMillis();
                    localAY.EnterRoad();
                    DrivingTime += currentTimeMillis() - time1;
                    sleep(localAY.wait_time);
                    DrivingTime+=localAY.wait_time;
                    time1 = currentTimeMillis();
                    localAY.LeftRoad();
                    DrivingTime += currentTimeMillis() - time1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    long time1 = currentTimeMillis();
                    highwayYX.EnterRoad();
                    DrivingTime += currentTimeMillis() - time1;
                    sleep(highwayYX.wait_time);
                    DrivingTime+=highwayYX.wait_time;
                    time1 = currentTimeMillis();
                    highwayYX.LeftRoad();
                    DrivingTime += currentTimeMillis() - time1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    long time1 = currentTimeMillis();
                    localXB.EnterRoad();
                    DrivingTime += currentTimeMillis() - time1;
                    sleep(localXB.wait_time);
                    DrivingTime+=localXB.wait_time;
                    time1 = currentTimeMillis();
                    localXB.LeftRoad();
                    DrivingTime += currentTimeMillis() - time1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                times.incrementAYXB((int)this.DrivingTime);
                times.incrementAXXB(0);
                times.incrementAYYB(0);
            }
            else{
                try {
                    long time1 = currentTimeMillis();
                    localAY.EnterRoad();
                    DrivingTime += currentTimeMillis() - time1;
                    sleep(localAY.wait_time);
                    DrivingTime+=localAY.wait_time;
                    time1 = currentTimeMillis();
                    localAY.LeftRoad();
                    DrivingTime += currentTimeMillis() - time1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    long time1 = currentTimeMillis();
                    highawyYB.EnterRoad();
                    DrivingTime += currentTimeMillis() - time1;
                    sleep(highawyYB.wait_time);
                    DrivingTime+=highawyYB.wait_time;
                    time1 = currentTimeMillis();
                    highawyYB.LeftRoad();
                    DrivingTime += currentTimeMillis() - time1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                times.incrementAYYB((int)this.DrivingTime);
                times.incrementAXXB(0);
                times.incrementAYXB(0);
            }

        }
        else
        {
            if(timeAXXB > timeAYXB && YXflag)
            {
                try {
                    long time1 = currentTimeMillis();
                    localAY.EnterRoad();
                    DrivingTime += currentTimeMillis() - time1;
                    sleep(localAY.wait_time);
                    DrivingTime+=localAY.wait_time;
                    time1 = currentTimeMillis();
                    localAY.LeftRoad();
                    DrivingTime += currentTimeMillis() - time1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    long time1 = currentTimeMillis();
                    highwayYX.EnterRoad();
                    DrivingTime += currentTimeMillis() - time1;
                    sleep(highwayYX.wait_time);
                    DrivingTime+=highwayYX.wait_time;
                    time1 = currentTimeMillis();
                    highwayYX.LeftRoad();
                    DrivingTime += currentTimeMillis() - time1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    long time1 = currentTimeMillis();
                    localXB.EnterRoad();
                    DrivingTime += currentTimeMillis() - time1;
                    sleep(localXB.wait_time);
                    DrivingTime+=localXB.wait_time;
                    time1 = currentTimeMillis();
                    localXB.LeftRoad();
                    DrivingTime += currentTimeMillis() - time1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                times.incrementAYXB((int)this.DrivingTime);
                times.incrementAXXB(0);
                times.incrementAYYB(0);
            }
            else
            {
                try {
                    long time1 = currentTimeMillis();
                    highawyAX.EnterRoad();
                    DrivingTime += currentTimeMillis() - time1;
                    sleep(highawyAX.wait_time);
                    DrivingTime+=highawyAX.wait_time;
                    time1 = currentTimeMillis();
                    highawyAX.LeftRoad();
                    DrivingTime += currentTimeMillis() - time1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    long time1 = currentTimeMillis();
                    localXB.EnterRoad();
                    DrivingTime += currentTimeMillis() - time1;
                    sleep(localXB.wait_time);
                    DrivingTime+=localXB.wait_time;
                    time1 = currentTimeMillis();
                    localXB.LeftRoad();
                    DrivingTime += currentTimeMillis() - time1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                times.incrementAXXB((int)this.DrivingTime);
                times.incrementAYYB(0);
                times.incrementAYXB(0);
            }

        }
        System.out.println("Car drivingtime: "+Float.toString(DrivingTime)+" ms \n");
    }
}
