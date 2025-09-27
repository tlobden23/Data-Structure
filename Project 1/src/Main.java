import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        // take in file path from user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter query file name: ");
        // retrieve the file path
        String fileDirectory = scanner.nextLine();

        // retrieve the file
        File file = new File(fileDirectory);

        System.out.println("Please enter a positive cache size: ");
        // retrieve the array size
        int size = scanner.nextInt();

        // if size isn't positive then ask again
        while (size <= 0){
            System.out.printf("You entered %d\n", size);
            System.out.println("Please enter a positive cache size: ");
            size = scanner.nextInt();
        }

        // create ArrayCache object passing in size
        ArrayCache array = new ArrayCache(size);

        // read the file and simulate DNS cache
        simulate(array, file);

        // output how many hits or misses
        printStats(array);

    }

    public static void simulate(ArrayCache array, File file) {
        // read the file contents and simulate DNS cache
        try{
            // get the file
            Scanner scanner = new Scanner(file);

            // check if the file has data
            while (scanner.hasNextLine()) {
                // retrieve the line
                String line = scanner.nextLine();

                // split the line into two parts (website and ip address)
                // ':' being the delimiter
                String[] parts = line.split(":");

                // check if url is in entries (array) if not then add to entries (array)
                if (array.get(parts[0]) == null){
                    // add the url and ip address to entries (array)
                    array.put(parts[0], parts[1]);
                }

                // output current state of entries (array)
                System.out.println(array);
            }
        }
        // catch any file exception
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printStats(ArrayCache array) {
        // count the total sum + misses
        double sum = array.getMisses() + array.getHits();

        // output how many hits or misses in percentage
        System.out.printf(" Hit Rate: %.2f%%\n" +
                          "Miss Rate: %.2f%%\n", array.getHits() / sum * 100, array.getMisses() / sum * 100);
    }

}