package Przetwarzanie.rozproszone;

import static java.lang.Thread.sleep;

public class Main {
    //autostrady

    public static void main(String[] args) throws InterruptedException {
        Highway highawyYB = new Highway();
        Highway highawyAX = new Highway();
        LocalRoad localXB = new LocalRoad();
        LocalRoad localAY = new LocalRoad();
        Highway highwayYX = new Highway(100);
        TimeAverage times = new TimeAverage();

        for(int i = 0 ; i<  1000;i++)
        {
            sleep(10);
            Car car = new Car(highawyYB, localAY, highawyAX, localXB, highwayYX, times);
            car.start();
        }
        sleep(10000);
        System.out.println(Integer.toString((int) times.GlobalSum/ 2000));
    }


}
