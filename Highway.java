package Przetwarzanie.rozproszone;

// element kolejki
public class Highway
{
    int counter ;
    int wait_time ;
    int MAXNumber ;
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
    Highway()
    {
        wait_time = 300;
        MAXNumber = 60;
        counter = 0;
    }
    int AverageTime()
    {
        return wait_time;
    }
    Highway(int wait_time)
    {
        this.wait_time = wait_time;
        MAXNumber = 80;
        counter = 0;
    }
}


