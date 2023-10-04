package code_part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class CollectionsArray {

    public static void main(String[] args)
    {
        //creating a constant size variable of 80 million
        final int size = 80000000;
        // creating an array of size
        int[] array = new int[size];
        // creating an arrayList of initial size
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        // creating a vector of initial size
        Vector<Integer> vector = new Vector<Integer>();
        // variable to store the elapsed time
        long arrayElapsedTime, arrayListElapsedTime, vectorElapsedTime;
        // initializing the collections with random numbers
        initializeCollections(size, array, arrayList, vector);

        long startTime = System.nanoTime();

        getSumOfArray(array);
        arrayElapsedTime = System.nanoTime();

        getSumOfArrayList(arrayList);
        arrayListElapsedTime = System.nanoTime();

        getSumOfVector(vector);
        vectorElapsedTime = System.nanoTime();

        // calculating the elapsed time in nano sec
        long t1ns = arrayElapsedTime - startTime;
        long t2ns = arrayListElapsedTime - arrayElapsedTime;
        long t3ns = vectorElapsedTime - arrayListElapsedTime;

        // calculating time elapsed in milli sec
        long t1ms = TimeUnit.NANOSECONDS.toMillis(t1ns);
        long t2ms = TimeUnit.NANOSECONDS.toMillis(t2ns);
        long t3ms = TimeUnit.NANOSECONDS.toMillis(t3ns);

        // calculating the elapsed time in sec
        long t1sec =  TimeUnit.NANOSECONDS.toSeconds(t1ns);
        long t2sec =  TimeUnit.NANOSECONDS.toSeconds(t2ns);
        long t3sec =  TimeUnit.NANOSECONDS.toSeconds(t3ns);

        System.out.println("Collection Type\t\tTotal elements\t\tTime taken to sum(milli sec)\t\tTime taken(sec) ");
        System.out.println("------------------------------------------------------"
                + "--------------------------------------------------");
        System.out.printf("%-25s%-25d%-40d%-20d\n", "Array", size, t1ms, t1sec);
        System.out.printf("%-25s%-25d%-40d%-20d\n", "ArrayList", size, t2ms, t2sec);
        System.out.printf("%-25s%-25d%-40d%-20d\n", "Vector", size, t3ms, t3sec);

    }


    // method to initialize the collections
    public static void initializeCollections(int size, int[] array,
            ArrayList<Integer> arrayList, Vector<Integer> vector)
    {
        Random random = new Random();

        for(int i = 0; i < size; i++)
        {
            // generating a random number in range 0 to 10000
            int num = random.nextInt((10000 - 0) + 1) + 0;
            array[i] = num;
            arrayList.add(num);
            vector.addElement(num);
        }
    }

    public static long getSumOfArray(int[] array)
    {
        long sum = 0;
        for(int i = 0; i < array.length; i++)
            sum += (long)array[i];
        return sum;
    }

    public static long getSumOfArrayList(ArrayList<Integer> list)
    {
        long sum = 0;
        Iterator<Integer> it = list.iterator();
        while(it.hasNext())
            sum += (long)it.next();
        return sum;
    }

    public static long getSumOfVector(Vector<Integer> vector)
    {
        long sum = 0;
        Iterator<Integer> it = vector.iterator();
        while(it.hasNext())
            sum += (long)it.next();
        return sum;
    }



}