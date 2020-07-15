package Przetwarzanie.rozproszone;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class TimeAverage {
    List<Integer> arrAXXB;
    List<Integer> arrAYYB;
    List<Integer> arrAYXB;
    List<Integer> plot;
    public int GlobalSum;
    int counter;
    int AXXBaverage;
    int AYYBaverage;
    int AYXBaverage;
    TimeAverage()
    {
        arrAXXB = new ArrayList<Integer>();
        arrAYYB = new ArrayList<Integer>();
        arrAYXB = new ArrayList<Integer>();
        GlobalSum = 0;
        counter = 0;
        for(int i=0;i<50;i++){
            arrAXXB.add(0);
            arrAYYB.add(0);
            arrAYXB.add(0);
        }
    }

    public void incrementAXXB(int CarTime)
    {
        synchronized (this)
        {
            arrAXXB.remove(0);
            arrAXXB.add(CarTime);
            if(CarTime != 0)
                GlobalSum += CarTime;
            int sum = 0;
            for(int i : arrAXXB)
            {
                sum += i;
            }
            this.AXXBaverage = sum/100;
        }
    }

    public void incrementAYXB(int CarTime)
    {
        synchronized (this)
        {
            arrAYXB.remove(0);
            arrAYXB.add(CarTime);
            if(CarTime != 0)
                GlobalSum += CarTime;
            int sum = 0;
            for(int i : arrAYXB)
            {
                sum += i;
            }
            this.AYXBaverage = sum/100;
        }
    }

    public void incrementAYYB(int CarTime)
    {
        synchronized (this)
        {
            arrAYYB.remove(0);
            arrAYYB.add(CarTime);
            if(CarTime != 0)
                GlobalSum += CarTime;
            int sum = 0;
            for(int i : arrAYYB)
            {
                sum += i;
            }
            this.AYYBaverage = sum/100;
        }
    }
    public float ReadTimeAXXB(){
        return AXXBaverage;
    }

    public float ReadTimeAYXB(){
        return AYXBaverage;
    }

    public float  ReadTimeAYYB()
    {
        return AYYBaverage;
    }
}
