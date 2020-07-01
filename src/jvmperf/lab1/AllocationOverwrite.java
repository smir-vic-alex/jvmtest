package jvmperf.lab1;/*
*	For jstat demostration
*/

import java.util.Random;

public class AllocationOverwrite {

    public static void main(String[] args) throws Exception{
        int arraySize = 1_000_000;
        GCMe[] gcmes = new GCMe[arraySize];
        
        int count = 0;
        Random rand = new Random();
        while(true){
            gcmes[rand.nextInt(arraySize)] = new GCMe();
            // if (count % 2_000_000 == 0){
            if (count % 1_000_000 == 0){
                System.out.print(".");
            }
            count++;
//            Thread.sleep(1);
        }
    }
}

class GCMe{
    long a;
    long aa;
    long aaa;
    long aaaa;
    long aaaaa;
    long aaaaaa;
    long aaaaaaa;
    long aaaaaaaa;
    long aaaaaaaaa;
    long aaaaaaaaaa;
    long aaaaaaaaaaa;
    long aaaaaaaaaaaa;
    long aaaaaaaaaaaaa;
    long aaaaaaaaaaaaaa;
}
