package Przetwarzanie.rozproszone;

public class LocalRoad
{
    int counter ;
    int wait_time = 120;
    int MAXNumber = 8;
    public synchronized void EnterRoad ( ) throws InterruptedException {
        if(counter == MAXNumber)
        {
            wait();
        }
        counter += 1;
    }
    public synchronized void LeftRoad () throws InterruptedException{
        notify();
        counter -= 1;
    }
    LocalRoad()
    {
        counter= 0;
    }
    int AverageTime()
    {
        return wait_time;
    }
}